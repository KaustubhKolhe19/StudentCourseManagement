package com.demo;

import model.Student;
import service.StudentService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Course Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. Show All Students");
            System.out.println("5. Show Sorted By Name");
            System.out.println("6. Show Top Scorers");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    service.addStudent(new Student(id, name));
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();
                    Student s = service.getStudent(id);
                    if (s != null) {
                        s.enroll(course);
                        System.out.println("Enrolled successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    course = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    int grade = sc.nextInt();
                    s = service.getStudent(id);
                    if (s != null) {
                        s.assignGrade(course, grade);
                        System.out.println("Grade assigned.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    service.showAllStudents();
                    break;

                case 5:
                    service.showSortedByName();
                    break;

                case 6:
                    service.showTopStudents();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
