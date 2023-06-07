package com.kkpa.hackerrank.interviewpreparationkit.warmup;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JumpingOnTheClouds {

  public int jumpingOnClouds(List<Integer> c) {
    // Write your code here
    int minJumps = Integer.MAX_VALUE;
    int length = c.size();

    if (length == 1) {
      return 1;
    }
    int result = findPath(c, 1);
    minJumps = result < minJumps ? result : minJumps;
    result = findPath(c, 2);
    minJumps = result < minJumps ? result : minJumps;


    return minJumps;
  }

  private int findPath(List<Integer> c, int priority) {
    int jumps = 0;
    for (int i = 0; i < c.size(); i++) {
      if (i == c.size() - 1) {
        break;
      }
      if (i == c.size() - 2) {
        priority = 1;
      }
      int next = c.get(i + priority);
      if (next == 0) {
        i += priority - 1;
        jumps++;
        continue;
      } else {
        if (priority == 2) {
          next = c.get(i + priority - 1);
          if (next == 0) {
            jumps++;
            continue;
          } else {
            break;
          }
        } else {
          next = c.get(i + 2);
          if (next == 0) {
            jumps++;
            i = i + 2 - 1;
          }
        }
      }
    }
    return jumps;
  }

}
