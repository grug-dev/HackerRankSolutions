package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class NewYearChaos {

  // Complete the minimumBribes function below.
  public String minimumBribes(List<Integer> q) {
    //System.out.println(q);

    int totalBribes = 0;
    for (int i = q.size(); i > 0; i--) {


      Integer curr = q.get(i - 1);

      if (i == curr) {

        continue;

      }
      if (i == q.get(i - 2)) {

        Collections.swap(q, i - 1, i - 2);
        //System.out.println(q);
        totalBribes++;
        continue;


      }


      if (i == q.get(i - 3)) {

        Collections.swap(q, i - 3, i - 2);
        //System.out.println(q);
        totalBribes++;
        Collections.swap(q, i - 2, i - 1);
        //System.out.println(q);
        totalBribes++;
        continue;
      }


      return ("Too chaotic");
    }

    return "" + totalBribes;
  }

}
