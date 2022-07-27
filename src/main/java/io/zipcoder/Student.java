package io.zipcoder;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Double> testScores;

    public Student(String firstName, String lastName, Double[] examScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = new LinkedList<>(Arrays.asList(examScore));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExamsTaken() {
        return testScores.size();
    }

    public String printExamScores() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("###");
        Object[] tempArray = testScores.toArray();
        for (int i = 0; i < tempArray.length; i++) {
            sb.append("Exam " + (i + 1) + " -> " + df.format(tempArray[i]) + "\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void addExamScore(double score) {
        this.testScores.add(score);
    }

    public void changeScoreForExam(int examNum, double newScore){
        this.testScores.set(examNum, newScore);
    }

    public double getAverage() {
        return (testScores.stream().mapToDouble(i -> i).sum())/testScores.size();
    }

    @Override
    public String toString() {
        String formattedOutput = "Student Name: " + this.firstName + " " + this.lastName +
                "\n> Average Score: " + new Double(this.getAverage()).intValue() +
                "\n" + this.printExamScores();
        return formattedOutput;
    }

    public static Comparator<Student> averageGradeComparator = new Comparator<Student>() {
        public int compare(Student student1, Student student2) {
            int firstAverage = new Double(student1.getAverage()).intValue();
            int secondAverage = new Double(student2.getAverage()).intValue();
            return secondAverage - firstAverage;
        }
    };

}
