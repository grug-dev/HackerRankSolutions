package com.kkpa.hackerrank.config;

import com.kkpa.hackerrank.datasctructures.arrayList.JavaList;
import com.kkpa.hackerrank.datasctructures.arrays.Java1DArrayPartII;
import com.kkpa.hackerrank.datasctructures.arrays.JavaSubArray;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataStructuresConfig {

  @Bean
  public JavaSubArray javaSubArrayBean() {
    return new JavaSubArray();
  }

  @Bean
  public JavaList javaListBean() {
    return new JavaList();
  }

  @Bean
  public Java1DArrayPartII java1DArrayPartIIBean() {
    return new Java1DArrayPartII();
  }

}
