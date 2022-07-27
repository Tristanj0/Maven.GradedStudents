package io.zipcoder;

import java.text.DecimalFormat;
import java.util.*;

public class Classroom {
    Student[] students;


    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore() {
        double totalAverages = 0;
        for (Student s : this.students) {
            totalAverages += s.getAverageExamScore();
        }
        return totalAverages / this.students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        int indexToReplace = -1;
        int lastStudentIndex = this.students.length - 1;

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getFirstName().equals(firstName) && this.students[i].getLastName().equals(lastName)) {
                indexToReplace = i;
                break;
            }
        }
        for(int i = 0; i < this.students.length; i++){
            if(this.students[i] == null){
                lastStudentIndex = i - 1;
                break;
            }
        }

        if(indexToReplace != -1){
            this.students[indexToReplace] = this.students[lastStudentIndex];
            this.students[lastStudentIndex] = null;
        }
    }

    public Student[] getStudentsByGrade() {
        int amountOfStudents = this.students.length;
        for(int i = 0; i < this.students.length; i++){
            if(this.students[i] == null){
                amountOfStudents = i;
                break;
            }
        }
        Student[] s = new Student[amountOfStudents];

        for(int i = 0; i < s.length; i++){
            s[i] = this.students[i];
        }

        Comparator c = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getAverageExamScore() < s2.getAverageExamScore()) {
                    return 1;
                }
                if (s1.getAverageExamScore() == s2.getAverageExamScore()) {
                    if (s1.getLastName().compareTo(s2.getLastName()) > 0) {
                        return 1;
                    }
                }
                return -1;
            }
        };


        Arrays.sort(s, c);

        return s;
    }

    public HashMap<Character, ArrayList<Student>> getGradeBook(){
        HashMap<Character, ArrayList<Student>> gradeBook = new HashMap<>();
        gradeBook.put('A', new ArrayList<>());
        gradeBook.put('B', new ArrayList<>());
        gradeBook.put('C', new ArrayList<>());
        gradeBook.put('D', new ArrayList<>());
        gradeBook.put('F', new ArrayList<>());

        ArrayList<Student> ascendingOrderStudents = new ArrayList<>(Arrays.asList(getStudentsByGrade()));
        Collections.reverse(ascendingOrderStudents);

        for(int i = 0; i < ascendingOrderStudents.size(); i++){
            if((double)(i + 1) / ascendingOrderStudents.size() > .90){
                gradeBook.get('A').add(ascendingOrderStudents.get(i));
            } else if((double)(i + 1) / ascendingOrderStudents.size() > .70){
                gradeBook.get('B').add(ascendingOrderStudents.get(i));
            } else if((double)(i + 1) / ascendingOrderStudents.size() > .49){
                gradeBook.get('C').add(ascendingOrderStudents.get(i));
            } else if((double)(i + 1) / ascendingOrderStudents.size() > .12){
                gradeBook.get('D').add(ascendingOrderStudents.get(i));
            } else {
                gradeBook.get('F').add(ascendingOrderStudents.get(i));
            }
        }

        return gradeBook;
    }

}
