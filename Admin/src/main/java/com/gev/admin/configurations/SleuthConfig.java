package com.gev.admin.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class SleuthConfig {
	
	@Bean
	public Sampler defaulSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
