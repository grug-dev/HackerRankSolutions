package com.kkpa.hackerrank.datasctructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
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


public class JavaPriorityQueue {
  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
