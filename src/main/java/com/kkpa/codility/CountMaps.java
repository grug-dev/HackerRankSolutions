package com.kkpa.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CountMaps {

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
