# HackerRankSolutions

My Java solutions to HackerRank and Codility problems, with a JUnit test for each one.

[![CI](https://github.com/grug-dev/HackerRankSolutions/actions/workflows/ci.yml/badge.svg)](https://github.com/grug-dev/HackerRankSolutions/actions/workflows/ci.yml)

This is a learning repo. I use it to practice algorithms, data structures and Java.
I started it in 2018 and I come back to it when I prepare for interviews.

## Requirements

- JDK 17 or newer to run Gradle.
- The code uses Java 21. If you do not have JDK 21, Gradle downloads it for you.

## Run the tests

```sh
./gradlew test
```

Run the tests of one class:

```sh
./gradlew test --tests 'com.kkpa.hackerrank.algorithms.BinarySearchTest'
```

After the tests, the coverage report is in `build/reports/jacoco/test/html/index.html`.
GitHub Actions runs the tests on every push and pull request, and shows the line coverage in the run summary.

## Code layout

There are about 60 solutions in `src/main/java/com/kkpa`. Each test is in `src/test/java`.

| Package | What is inside |
|---|---|
| `codility` | Codility tasks: binary gap, count user visits from several maps |
| `hackerrank.algorithms` | Binary search, sorting, implementation, one dynamic programming problem |
| `hackerrank.crackingcodinginterview` | Cycle in a linked list, Fibonacci, anagrams |
| `hackerrank.datastructures` | Arrays, lists, maps, heap, linked list, stacks, `BitSet`, `Deque`, `PriorityQueue` |
| `hackerrank.dynamicprogramming` | Memoization (`canSum`, `howSum`, `bestSum`, `allConstruct`, ...) and tabulation |
| `hackerrank.interviewpreparationkit` | Interview Preparation Kit: arrays, dictionaries and hashmaps, greedy, search, sorting, strings, warm-up |
| `hackerrank.java` | Java topics: primality with `BigInteger`, `BigDecimal` sorting, palindrome, regex |

About a third of the classes have a link to the problem in the Javadoc.

## Decisions

- **Solutions return a value. They do not read `System.in`.** So a test can call the method and check the result.
  To submit on HackerRank, I add the input code again.
- **Some solutions print.** When HackerRank asks for printed output (for example `BubbleSort`, `QHeap1`),
  the code prints it, and the test reads it with `TestSupport.captureOutput`.
- **Plain Java and JUnit 4. No framework.** An older version used Spring only to create the objects. I removed it.
  I kept JUnit 4 because many tests use the `Parameterized` runner.
- **The tests check the HackerRank sample, plus edge cases** like empty input or the limits of `int`.

## Known limits

- Some tests are not in the same package as their class. For example `JavaHashSetTest` is in `java.arrays`.
- Some methods keep the HackerRank signature, even when it is not nice Java.
  For example `NewYearChaos` returns the number of bribes as a `String`, because the answer can be `"Too chaotic"`.
- Not every solution is the fastest one. Some classes have two versions to compare them.

## License

MIT. See [LICENSE](LICENSE).
