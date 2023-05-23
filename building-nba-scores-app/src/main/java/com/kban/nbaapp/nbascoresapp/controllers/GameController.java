package com.kban.nbaapp.nbascoresapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kban.nbaapp.nbascoresapp.dao.NbaData;
import com.kban.nbaapp.nbascoresapp.models.Game;
import com.kban.nbaapp.nbascoresapp.models.Player;
import com.kban.nbaapp.nbascoresapp.models.Team;
import com.kban.nbaapp.nbascoresapp.services.NBAAPiService;
import com.kban.nbaapp.nbascoresapp.services.NBAApiClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
@RequestMapping("/api")
public class GameController {

	private static final String BASE_URL = "https://api-nba-v1.p.rapidapi.com/games/";
	private static final String API_KEY = "1d212b10a3msh1a6aeba0086370ep191e02jsnea589acdff9b";

	private NBAAPiService apiService = NBAApiClient.getClient();

	public GameController() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
				.build();

		apiService = retrofit.create(NBAAPiService.class);
	}

	@GetMapping("/live-scores")
	public String getLiveScores() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(BASE_URL + "?live=true").get()
				.addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com").addHeader("X-RapidAPI-Key", API_KEY).build();

		Response response = client.newCall(request).execute();
		String json = response.body().string();

		Gson gson = new Gson();
		Game[] games = gson.fromJson(json, Game[].class);

		if (games.length == 0) {
			return "There are no live games currently being played.";
		}

		StringBuilder sb = new StringBuilder();
		for (Game game : games) {
			String homeTeam = game.getHomeTeam().getName();
			int homeScore = game.getHomeTeamScore();
			String awayTeam = game.getAwayTeam().getName();
			int awayScore = game.getAwayTeamScore();

			sb.append(homeTeam).append(" ").append(homeScore).append(" - ").append(awayScore).append(" ")
					.append(awayTeam).append("\n");
		}

		return sb.toString();
	}

	@GetMapping("/teams")
	public List<Team> getTeams() throws IOException {
		Call<NbaData> call = apiService.getTeams(API_KEY);
		NbaData nbaData = call.execute().body();
		List<Team> teams = new ArrayList<>();

		if (nbaData != null) {
			for (Team team : nbaData.getTeams()) {
				teams.add(team);
			}
		}

		return teams;
	}

	@GetMapping("/players")
	public List<Player> getPlayers() throws IOException {
		Call<NbaData> call = apiService.getPlayers(API_KEY);
		NbaData nbaData = call.execute().body();
		List<Player> players = new ArrayList<>();

		if (nbaData != null) {
			for (Player player : nbaData.getPlayers()) {
				players.add(player);
			}
		}

		return players;
	}
}
