package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassroomTest {

    @Test
    public void ClassroomConstructorTest1(){
        //Given
        int expectedLength = 15;

        //When
        Classroom c = new Classroom(15);
        int actualLength = c.students.length;

        //Then
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void ClassroomConstructorTest2(){
        //Given
        Student s1 = new Student("f1", "l1", new Double[]{79.0, 85.0, 95.0});
        Student s2 = new Student("f2", "l2", new Double[]{84.0, 93.0, 97.0});
        Student[] s = {s1, s2};

        //When
        Classroom c = new Classroom(s);

        //Then
        Assert.assertNotNull(c);
    }

    @Test
    public void ClassroomConstructorTest3(){
        //Given
        int expectedLength = 30;

        //When
        Classroom c = new Classroom();
        int actualLength = c.students.length;

        //Then
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void getAverageExamScoreTest(){
        //Given
        Student s1 = new Student("f1", "l1", new Double[]{79.0, 85.0, 95.0});
        Student s2 = new Student("f2", "l2", new Double[]{84.0, 93.0, 97.0});
        Student[] s = {s1, s2};
        Classroom c = new Classroom(s);

        double expected = (79.0 + 85.0 + 95.0 + 84.0 + 93.0 + 97.0) / 6.0;

        //When
        double actual = c.getAverageExamScore();

        //Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void addStudentTest(){
        //Given
        Classroom c = new Classroom(3);
        Student s = new Student("f", "l", new Double[]{95.0, 93.0, 94.5});

        //When
        c.addStudent(s);

        //Then
        Assert.assertNotNull(c.students[0]);
    }

    @Test
    public void removeStudentTest(){
        //Given
        Student s1 = new Student("f1", "l1", new Double[]{79.0, 85.0, 95.0});
        Student s2 = new Student("f2", "l2", new Double[]{84.0, 93.0, 97.0});
        Student s3 = new Student("f3", "l3", new Double[]{14.0, 33.0, 47.0});
        Student s4 = new Student("f4", "l4", new Double[]{87.0, 97.0, 99.0});
        Classroom c = new Classroom(5);
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);

        Student[] expected = {s1, s2, s4, null, null};

        //When
        c.removeStudent("f3", "l3");
        Student[] actual = c.getStudents();

        //Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getStudentByScoreTest(){
        //Given
        Student s1 = new Student("John", "C", new Double[]{70.0});
        Student s2 = new Student("Harry", "G", new Double[]{90.0});
        Student s3 = new Student("Joe", "L", new Double[]{80.0});
        Student s4 = new Student("Bob", "B", new Double[]{80.0});
        Student[] s = {s1, s2, s3, s4};
        Classroom c = new Classroom(s);

        Student[] expected = {s2, s4, s3, s1};

        //When
        Student[] actual = c.getStudentsByGrade();

        //Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void getGradeBookTest(){
        //Given
        Student s1 = new Student("Bob", "l1", new Double[]{85.0});
        Student s2 = new Student("Harry", "l2", new Double[]{55.0});
        Student s3 = new Student("Larry", "l3", new Double[]{25.0});
        Student s4 = new Student("Mary", "l4", new Double[]{100.0});
        Student[] s = {s1, s2, s3, s4};
        Classroom c = new Classroom(s);

        HashMap<Character, ArrayList<Student>> expected = new HashMap<>();
        expected.put('A', new ArrayList<>());
        expected.put('B', new ArrayList<>());
        expected.put('C', new ArrayList<>());
        expected.put('D', new ArrayList<>());
        expected.put('F', new ArrayList<>());
        expected.get('A').add(s4);
        expected.get('B').add(s1);
        expected.get('C').add(s2);
        expected.get('D').add(s3);

        //When
        HashMap<Character, ArrayList<Student>> actual = c.getGradeBook();

        //Then
        Assert.assertEquals(expected, actual);

    }
}
