package com.kban.nbaapp.nbascoresapp.dao;

import com.google.gson.annotations.SerializedName;
import com.kban.nbaapp.nbascoresapp.models.Player;
import com.kban.nbaapp.nbascoresapp.models.Schedule;
import com.kban.nbaapp.nbascoresapp.models.Team;

import java.util.List;

public class NbaData {

	@SerializedName("schedule")
	private List<Schedule> schedule;

	@SerializedName("teams")
	private List<Team> teams;

	@SerializedName("players")
	private List<Player> players;

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
