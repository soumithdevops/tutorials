package com.gautam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gautam.entities.Game;

public class RunDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Game game = context.getBean("game", Game.class);
		System.out.println(game.playGame());
		
		context.close();
	}

}
