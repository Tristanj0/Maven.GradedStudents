package io.zipcoder;

import java.text.DecimalFormat;
import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getExamScores() {
        String scores = "Exam Scores:";

        for(int i = 1; i <= this.examScores.size(); i++){
            scores += "\n\tExam " + i + " -> " + examScores.get(i - 1);
        }
        return scores;
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScores(int examNumber, double newScore){
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore(){
        return this.examScores.stream().mapToDouble(a -> a).average().orElseThrow();
    }


    @Override
    public String toString() {
        return "\nStudent Name: " + getFirstName() + " " + getLastName() +
                "\n> Average Score: " + getAverageExamScore() +
                "\n> " + getExamScores();
    }

}
