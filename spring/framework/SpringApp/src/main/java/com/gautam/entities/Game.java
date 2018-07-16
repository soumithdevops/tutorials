package com.gautam.entities;

public interface Game {
	Team getHomeTeam();
	void setHomeTeam(Team homeTeam);
	Team getAwayTeam();
	void setAwayTeam(Team awayTeam);
	String playGame();
	void setDataSource(String dataSource);
	String getDataSource();
}
