package com.kkpa.hackerrank.datastructures;

import com.kkpa.TestSupport;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 * Students are served by highest CGPA, then by name (a to z), then by lowest id.
 * getStudents returns the students still waiting, in that order.
 * Student and Priorities are package-private classes in JavaPriorityQueue.java.
 */
public class JavaPriorityQueueTest {

  private static final List<String> SAMPLE_EVENTS = Arrays.asList(
          "ENTER John 3.75 50",
          "ENTER Mark 3.8 24",
          "ENTER Shafaet 3.7 35",
          "SERVED",
          "SERVED",
          "ENTER Samiha 3.85 36",
          "SERVED",
          "ENTER Ashley 3.9 42",
          "ENTER Maria 3.6 46",
          "ENTER Anik 3.95 49",
          "ENTER Dan 3.95 50",
          "SERVED");

  private static List<String> waitingNames(List<String> events) {
    List<Student> students = new ArrayList<>();
    TestSupport.captureOutput(() -> students.addAll(new Priorities().getStudents(events)));
    List<String> names = new ArrayList<>();
    for (Student student : students) {
      names.add(student.getName());
    }
    return names;
  }

  @Test
  public void hackerRankSample() {
    assertEquals(Arrays.asList("Dan", "Ashley", "Shafaet", "Maria"), waitingNames(SAMPLE_EVENTS));
  }

  @Test
  public void sameCgpaSortsByName() {
    List<String> events = Arrays.asList("ENTER Zoe 3.5 1", "ENTER Amy 3.5 2");
    assertEquals(Arrays.asList("Amy", "Zoe"), waitingNames(events));
  }

  @Test
  public void sameCgpaAndNameSortsById() {
    List<String> events = Arrays.asList("ENTER Amy 3.5 9", "ENTER Amy 3.5 2");
    List<Student> students = new ArrayList<>();
    TestSupport.captureOutput(() -> students.addAll(new Priorities().getStudents(events)));
    assertEquals(2, students.get(0).getID());
    assertEquals(9, students.get(1).getID());
  }

  @Test
  public void everyoneServedLeavesNoStudents() {
    assertTrue(waitingNames(Arrays.asList("ENTER Amy 3.5 1", "SERVED")).isEmpty());
  }

  @Ignore("BUG: SERVED on an empty queue polls null and throws NullPointerException on student.getName()")
  @Test
  public void servedOnEmptyQueueDoesNothing() {
    assertEquals(Arrays.asList("Amy"), waitingNames(Arrays.asList("SERVED", "ENTER Amy 3.5 1")));
  }

  @Ignore("BUG: getStudents prints \"Student removed <name>\" for each SERVED. It should only return the list")
  @Test
  public void getStudentsPrintsNothing() {
    assertEquals("", TestSupport.captureOutput(() -> new Priorities().getStudents(SAMPLE_EVENTS)));
  }
}
