package model;

public class Course {
    private String courseName;
    private int maxMarks;

    public Course(String courseName, int maxMarks) {
        this.courseName = courseName;
        this.maxMarks = maxMarks;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxMarks() {
        return maxMarks;
    }
}
