package com.kban.nbaapp.nbascoresapp.services;

import java.util.List;

import com.kban.nbaapp.nbascoresapp.dao.NbaData;
import com.kban.nbaapp.nbascoresapp.models.Game;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NBAAPiService {

	@GET("schedule")
	Call<NbaData> getGames(@Query("api_key") String apiKey, @Query("seasonYear") String seasonYear);

	@GET("teams")
	Call<NbaData> getTeams(@Query("api_key") String apiKey);

	@GET("players")
	Call<NbaData> getPlayers(@Query("api_key") String apiKey);

	@GET("standings")
	Call<NbaData> getStandings(@Query("api_key") String apiKey);

	@GET("games")
	Call<List<Game>> getGames();

}