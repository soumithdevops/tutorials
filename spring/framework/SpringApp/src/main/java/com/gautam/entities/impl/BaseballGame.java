package com.gautam.entities.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.gautam.entities.Game;
import com.gautam.entities.Team;

public class BaseballGame implements Game {
	private Team homeTeam;
	private Team awayTeam;
	
	private String dataSource;
	
	public BaseballGame() {	}
	
	public BaseballGame(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	@PostConstruct
	public void startGame() {
		System.out.println("Play national anthem.");
	}	
	
	@PreDestroy
	public void endGame() {
		System.out.println("Send highlights to NFL.");
	}
	
	@Override
	public Team getHomeTeam() {
		return this.homeTeam;
	}

	@Override
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@Override
	public Team getAwayTeam() {
		return this.awayTeam;
	}

	@Override
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public void setDataSource(String dataSource) {
		this.dataSource =dataSource;
	}
	
	public String getDataSource() {
		return this.dataSource;
	}

	@Override
	public String playGame() {
		return Math.random() > 0.5 ? getHomeTeam().getTeamName() : getAwayTeam().getTeamName();
	}

}
