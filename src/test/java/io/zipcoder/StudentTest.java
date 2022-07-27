package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getAndSetStudentFirstNameTest() {
        Double[] dubArray = {};
        Student mitch = new Student("Mitch", "Taylor", dubArray);
        mitch.setFirstName("Bob");
        String expected = "Bob";
        String actual = mitch.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAndSetStudentLastNameTest() {
        Double[] dubArray = {};
        Student mitch = new Student("Joe", "Tim", dubArray);
        mitch.setLastName("Jim");
        String expected = "Jim";
        String actual = mitch.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        Double[] dubArray = {100.0, 99.0, 98.0};
        Student mitch = new Student("Billy", "Bob", dubArray);
        int expected = 3;
        int actual = mitch.getExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printExamScoresTest() {
        Double[] dubArray = {100.0, 99.0, 98.0};
        Student mitch = new Student("Billy", "Bob", dubArray);
        String expected = "Exam 1 -> 100\nExam 2 -> 99\nExam 3 -> 98";
        String actual = mitch.printExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageTest() {
        Double[] dubArray = {100.0, 99.0, 98.0};
        Student mitch = new Student("Billy", "Bob", dubArray);
        double expected = 99.0;
        double actual = mitch.getAverage();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void addExamScoreTest() {
        Double[] dubArray = {100.0, 99.0, 98.0};
        Student mitch = new Student("Billy", "Bob", dubArray);
        mitch.addExamScore(97.0);
        String expected = "Exam 1 -> 100\nExam 2 -> 99\nExam 3 -> 98\nExam 4 -> 97";
        String actual = mitch.printExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeExamScoreTest() {
        Double[] dubArray = {100.0, 99.0, 98.0};
        Student mitch = new Student("Billy", "Bob", dubArray);
        mitch.changeScoreForExam(1, 97.0);
        String expected = "Exam 1 -> 100\nExam 2 -> 97\nExam 3 -> 98";
        String actual = mitch.printExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void overrideToStringTest() {
        Double[] examScores = {95.0, 92.0, 75.0, 80.0};
        Student student = new Student("Brian", "He", examScores);
        String expected = "Student Name: Brian He\n> Average Score: 85\n> Exam Scores:\n\t\tExam 1 -> 95\n\t\tExam 2 -> 92\n\t\tExam 3 -> 75\n\t\tExam 4 -> 80\n";
        String actual = student.toString();
        Assert.assertEquals(expected, actual);
    }

}