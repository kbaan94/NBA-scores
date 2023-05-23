package com.kban.nbaapp.nbascoresapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//A model representing an NBA player, with fields for the player name, position, team, and other relevant information.
@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;

	private String lastName;

	private int number;

	//
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	// Constructors, getters, and setters

	public Player() {
	}

	public Player(String firstName, String lastName, int number, Team team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
