package com.gautam;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.gautam.entities.Game;
import com.gautam.entities.Team;
import com.gautam.entities.impl.BaseballGame;

@Configuration
@ComponentScan(basePackages = "com.gautam")
public class AppConfig {
	
	@Autowired
	private String dataSource;
	
	@Autowired @Qualifier("redSocks")
	private Team homeTeam;
	
	@Autowired @Qualifier("cubs")
	private Team awayTeam;
	
	@Bean
	public NumberFormat nf() {
		return NumberFormat.getCurrencyInstance();
	}
	
	@Bean
	public Game game() {
		Game game =  new BaseballGame(homeTeam, awayTeam);
		game.setDataSource(dataSource);
		return game;
	}
}
