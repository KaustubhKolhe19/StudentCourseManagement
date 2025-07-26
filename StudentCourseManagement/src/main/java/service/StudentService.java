package service;

import model.Student;
import java.util.*;

public class StudentService {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student s) {
        studentMap.put(s.getId(), s);
    }

    public Student getStudent(int id) {
        return studentMap.get(id);
    }

    public void showAllStudents() {
        for (Student s : studentMap.values()) {
            System.out.println("ID: " + s.getId() + " | Name: " + s.getName());
        }
    }

    public void showTopStudents() {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> b.getTotalScore() - a.getTotalScore()
        );
        pq.addAll(studentMap.values());

        System.out.println("Top Scorers:");
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            Student s = pq.poll();
            System.out.println(s.getName() + " - Score: " + s.getTotalScore());
        }
    }

    public void showSortedByName() {
        TreeSet<Student> sortedSet = new TreeSet<>(studentMap.values());
        for (Student s : sortedSet) {
            System.out.println(s.getName() + " - ID: " + s.getId());
        }
    }
}
