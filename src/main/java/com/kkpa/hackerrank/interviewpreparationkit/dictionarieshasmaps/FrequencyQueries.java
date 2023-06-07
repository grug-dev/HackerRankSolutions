package com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class FrequencyQueries {

  static List<Integer> freqQuery(List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();

    for (List<Integer> query : queries) {
      int operation = query.get(0);
      int value = query.get(1);

      switch (operation) {
        case 1:
          frequencyMap.merge(value, 1, Integer::sum);
          break;
        case 2:
          frequencyMap.merge(value, 1, (a, b) -> (a - b) < 0 ? 0 : (a - b));
          break;
        case 3:
          Long frequency = frequencyMap.values().stream().filter(freq -> freq == value).count();
          int r = frequency > 0 ? 1 : 0;
          result.add(r);
          break;
      }
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    List<List<Integer>> queries = new ArrayList<>();

    queries.add(Arrays.asList(1, 3));
    queries.add(Arrays.asList(1, 6));
    queries.add(Arrays.asList(3, 2));
    queries.add(Arrays.asList(1, 10));
    queries.add(Arrays.asList(1, 10));
    queries.add(Arrays.asList(1, 6));
    queries.add(Arrays.asList(2, 5));
    queries.add(Arrays.asList(3, 2));

    freqQuery(queries);
  }
}
