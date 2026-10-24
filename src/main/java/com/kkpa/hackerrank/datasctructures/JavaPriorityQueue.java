package com.kkpa.hackerrank.datasctructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */

class Student {
  private String name;
  private int id;
  private double cgpa;

  public Student() {
  }

  Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  @Override public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", id=" + id +
            ", cgpa=" + cgpa +
            '}';
  }

  public int getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCGPA() {
    return cgpa;
  }

}

class Priorities {

  public List<Student> getStudents(List<String> events) {
    List<Student> allStudents = new ArrayList<>();

    PriorityQueue<Student> priorityQueue = new PriorityQueue<>(
            Comparator.comparingDouble(Student::getCGPA).reversed().
                    thenComparing(Student::getName).
                    thenComparingInt(Student::getID)
    );
    for (String event : events) {
      String[] args = event.split(" ");
      if (args[0].toUpperCase().equalsIgnoreCase("ENTER")) {
        String name = args[1];
        double cgpt = new Double(args[2]).doubleValue();
        int id = Integer.parseInt(args[3]);
        priorityQueue.offer(new Student(id, name, cgpt));
      } else {
        Student student = priorityQueue.poll();
        System.out.println("Student removed " + student.getName());
      }
    }
    while (!priorityQueue.isEmpty()) {
      allStudents.add(priorityQueue.poll());
    }
    return allStudents;
  }
}

/**
 * The solution lives in {@link Priorities}. This class only matches the file name.
 */
public class JavaPriorityQueue {
}
