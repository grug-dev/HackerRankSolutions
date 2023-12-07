package com.kkpa.hackerrank.config;

import com.kkpa.hackerrank.dynamicprogramming.MaxArraySum;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.LeftRotation;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.MinimumSwapsTwo;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.NewYearChaos;
import com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps.CountTriplets;
import com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps.SherlockAnagrams;
import com.kkpa.hackerrank.interviewpreparationkit.linkedlist.DoublyLinkedListNodeSolution;
import com.kkpa.hackerrank.interviewpreparationkit.search.SearchTriplets;
import com.kkpa.hackerrank.interviewpreparationkit.search.SwapNodes;
import com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation.AlternativeCharacteres;
import com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation.SpecialStringAgain;
import com.kkpa.hackerrank.interviewpreparationkit.warmup.JumpingOnTheClouds;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

  @Bean
  public MinimumSwapsTwo minimumSwapsTwoBean() {
    return new MinimumSwapsTwo();
  }

  @Bean
  protected JumpingOnTheClouds jumpingOnTheClouds() {
    return new JumpingOnTheClouds();
  }

  @Bean
  protected SherlockAnagrams sherlockAnagrams() {
    return new SherlockAnagrams();
  }

  @Bean
  protected SpecialStringAgain specialStringAgain() {
    return new SpecialStringAgain();
  }

  @Bean
  protected AlternativeCharacteres alternativeCharacteres() {
    return new AlternativeCharacteres();
  }

  @Bean
  protected CountTriplets countTriplets() {
    return new CountTriplets();
  }

  @Bean
  protected SwapNodes swapNodes() {
    return new SwapNodes();
  }

  @Bean
  protected SearchTriplets searchTriplets() {
    return new SearchTriplets();
  }

  @Bean
  protected MaxArraySum maxArraySum() {
    return new MaxArraySum();
  }

  @Bean
  protected DoublyLinkedListNodeSolution doublyLinkedListNode() {
    return new DoublyLinkedListNodeSolution();
  }
}
