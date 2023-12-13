package com.kkpa.hackerrank.config;

import com.kkpa.hackerrank.algorithms.dynamicprogramming.SamAndSubstrings;
import com.kkpa.hackerrank.algorithms.sorting.Insertion_Sort_Part1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgorithmsConfig {

  @Bean
  public Insertion_Sort_Part1 insertionSortPart1Bean() {
    return new Insertion_Sort_Part1();
  }

  @Bean
  public SamAndSubstrings samAndSubstrings() {
    return new SamAndSubstrings();
  }
}
