package com.gautam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfig {
	
	@Bean 
	public String getDataSource() {
		return "Data source";
	}
}
