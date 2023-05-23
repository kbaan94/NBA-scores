package com.kban.nbaapp.nbascoresapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String city;

	private String conference;

	private String division;

	// Constructors, getters, and setters

	public Team() {
	}

	public Team(String name, String city, String conference, String division) {
		this.name = name;
		this.city = city;
		this.conference = conference;
		this.division = division;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
}
