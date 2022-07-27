package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void studentConstructorTest(){
        //Given
        String firstName = "f";
        String lastName = "l";
        Double[] examScores = {};

        //When
        Student student = new Student(firstName, lastName, examScores);

        //Then
        Assert.assertNotNull(student);

    }

    @Test
    public void getExamScoresTest(){
        //Given
        String firstName = "f";
        String lastName = "l";
        Double[] examScores = {100.0, 95.0, 93.0};
        Student student = new Student(firstName, lastName, examScores);

        String expected = "Exam Scores:" +
                "\n\tExam 1 -> 100.0" +
                "\n\tExam 2 -> 95.0" +
                "\n\tExam 3 -> 93.0" ;

        //When
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addExamScoreTest(){
        //Given
        String firstName = "f";
        String lastName = "l";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);

        String expected = "Exam Scores:" +
                "\n\tExam 1 -> 100.0" ;

        //When

        student.addExamScore(100.0);
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest(){
        //Given
        String firstName = "f";
        String lastName = "l";
        Double[] examScores = {50.0};
        Student student = new Student(firstName, lastName, examScores);

        String expected = "Exam Scores:" +
                "\n\tExam 1 -> 100.0" ;

        //When
        student.setExamScores(1, 100.0);
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest(){
        //Given
        String firstName = "f";
        String lastName = "l";
        Double[] examScores = {100.0, 95.0, 93.0, 85.0};
        Student student = new Student(firstName, lastName, examScores);

        double expected = (100.0 + 95.0 + 93.0 + 85.0) / 4.0;

        //When
        double actual = student.getAverageExamScore();

        //Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void toStringTest(){
        //Given
        String firstName = "Hunter";
        String lastName = "A";
        Double[] examScores = {100.0, 95.0, 93.0};
        Student student = new Student(firstName, lastName, examScores);

        String expected = "\nStudent Name: Hunter A" +
                "\n> Average Score: 96.0" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 100.0" +
                "\n\tExam 2 -> 95.0" +
                "\n\tExam 3 -> 93.0" ;

        //When
        String actual = student.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

}