package com.kkpa.hackerrank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kkpa.hackerrank.interviewpreparationkit.arrays.LeftRotation;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.NewYearChaos;

@Configuration
public class InterviewPreparationKitConfig {

  @Bean
  public LeftRotation leftRotationBean() {
    return new LeftRotation();
  }
  
  @Bean
  public NewYearChaos newYearChaosBean() {
	  return new NewYearChaos();
  }

}
