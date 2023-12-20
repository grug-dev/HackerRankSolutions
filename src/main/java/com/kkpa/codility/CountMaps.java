package com.kkpa.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CountMaps {
  public static void main(String[] args) {
// Populate the first map
    Map<String, UserStats> map1 = new HashMap<>();
    map1.put("1", new UserStats(Optional.of(3L)));
    map1.put("2", new UserStats(Optional.of(5L)));
    map1.put("user3", new UserStats(Optional.empty())); // No visit count for user3

    // Populate the second map
    Map<String, UserStats> map2 = new HashMap<>();
    map2.put("1", new UserStats(Optional.of(2L)));
    map2.put("2", new UserStats(Optional.of(4L)));
    map2.put("3", new UserStats(Optional.of(1L)));

    // Call the count method with the created maps
    Map<Long, Long> result = count(map1, map2);

    System.out.println(result);
  }

  static Map<Long, Long> count(Map<String, UserStats>... visits) {
    if (visits == null) {
      return new HashMap<>();
    }
    Map<Long, Long> totalCountsPerUser = new HashMap<>();

    for (Map<String, UserStats> visitPerMs : visits) {
      for (Map.Entry<String, UserStats> entry : visitPerMs.entrySet()) {
        if (entry == null) continue;


        String userId = entry.getKey();
        if (userId.isEmpty()) continue;

        UserStats userStats = entry.getValue();
        if (userStats == null) {
          continue;
        }
        Long visitCount = userStats.getVisitCount().orElse(0L);
        if (visitCount > 0) {
          totalCountsPerUser.merge(Long.parseLong(userId), visitCount, Long::sum);
        }
      }
    }

    return totalCountsPerUser;
  }

  static class UserStats {

    UserStats(Optional<Long> visitCount) {
      this.visitCount = visitCount;
    }

    Optional<Long> visitCount; //might be empty

    public Optional<Long> getVisitCount() {
      return visitCount;
    }
  }
}
