package model;

import java.util.*;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Map<String, Integer> grades = new HashMap<>();
    private Set<String> courses = new HashSet<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void enroll(String course) {
        courses.add(course);
    }

    public void assignGrade(String course, int grade) {
        grades.put(course, grade);
    }

    public int getTotalScore() {
        return grades.values().stream().mapToInt(i->i).sum();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Set<String> getCourses() { return courses; }
    public Map<String, Integer> getGrades() { return grades; }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); // sort by name
    }
}
