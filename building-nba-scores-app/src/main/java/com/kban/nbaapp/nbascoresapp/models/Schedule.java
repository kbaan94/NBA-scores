package com.kban.nbaapp.nbascoresapp.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//A model representing the NBA schedule, with fields for the date, time, location, and teams playing in each game.
@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Team homeTeam;

	@ManyToOne
	private Team awayTeam;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String location;

	public Schedule() {
	}

	public Schedule(Team homeTeam, Team awayTeam, Date date, String location) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.date = date;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
