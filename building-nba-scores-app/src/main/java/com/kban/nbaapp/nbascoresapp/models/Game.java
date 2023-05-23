package com.kban.nbaapp.nbascoresapp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//A model representing an NBA team, with fields for the team name, city, and other relevant information.

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "game_id")
	private String gameId;

	@ManyToOne
	@JoinColumn(name = "home_team_id", referencedColumnName = "id")
	private Team homeTeam;

	@ManyToOne
	@JoinColumn(name = "away_team_id", referencedColumnName = "id")
	private Team awayTeam;

	@Column(name = "home_team_score")
	private Integer homeTeamScore;

	@Column(name = "away_team_score")
	private Integer awayTeamScore;

	@Column(name = "game_date_time")
	private LocalDateTime gameDateTime;

	public Game() {
		super();
	}

	public Game(Long id, String gameId, Team homeTeam, Team awayTeam, Integer homeTeamScore, Integer awayTeamScore,
			LocalDateTime gameDateTime) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.gameDateTime = gameDateTime;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public LocalDateTime getGameDateTime() {
		return gameDateTime;
	}

	public void setGameDateTime(LocalDateTime gameDateTime) {
		this.gameDateTime = gameDateTime;
	}
}
