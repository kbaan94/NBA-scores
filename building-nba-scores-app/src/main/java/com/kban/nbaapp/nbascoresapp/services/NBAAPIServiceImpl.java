package com.kban.nbaapp.nbascoresapp.services;

import java.util.List;

import com.kban.nbaapp.nbascoresapp.dao.NbaData;
import com.kban.nbaapp.nbascoresapp.models.Game;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NBAAPIServiceImpl implements NBAAPiService {

	private static final String BASE_URL = "https://api.nba.net/2/";
	private final NBAAPiService apiService;

	public NBAAPIServiceImpl() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
				.build();
		apiService = retrofit.create(NBAAPiService.class);
	}

	@Override
	public Call<NbaData> getGames(String apiKey, String seasonYear) {
		return apiService.getGames(apiKey, seasonYear);
	}

	@Override
	public Call<NbaData> getTeams(String apiKey) {
		return apiService.getTeams(apiKey);
	}

	@Override
	public Call<NbaData> getPlayers(String apiKey) {
		return apiService.getPlayers(apiKey);
	}

	@Override
	public Call<NbaData> getStandings(String apiKey) {
		return apiService.getStandings(apiKey);
	}

	@Override
	public Call<List<Game>> getGames() {
		// TODO Auto-generated method stub
		return null;
	}

}
