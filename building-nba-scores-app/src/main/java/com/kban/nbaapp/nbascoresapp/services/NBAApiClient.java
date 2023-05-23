package com.kban.nbaapp.nbascoresapp.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NBAApiClient {
	private static final String BASE_URL = "https://api-nba-v1.p.rapidapi.com/";

	private static Retrofit retrofit = null;

	public static NBAAPiService getClient() {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit.create(NBAAPiService.class);
	}
}
