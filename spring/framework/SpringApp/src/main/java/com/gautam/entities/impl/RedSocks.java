package com.gautam.entities.impl;

import org.springframework.stereotype.Component;

import com.gautam.entities.Team;

@Component
public class RedSocks implements Team {

	@Override
	public String getTeamName() {
		return "Boston Red Socks";
	}
	
}
