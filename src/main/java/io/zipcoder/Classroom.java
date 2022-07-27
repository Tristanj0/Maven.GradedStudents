package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Classroom {

    private Student[] students;
    private int studentsEnrolled;
    private int maxStudents;

    public Classroom() {
        this(30);
    }

    public Classroom(int maxStudents) {
        this.students = new Student[maxStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public boolean addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }
        return false;
    }

    public Student removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if ((students[i].getFirstName() == firstName) && (students[i].getLastName() == lastName)) {
                Student studentToBeRemoved = students[i];
                students[i] = null;
                return studentToBeRemoved;
            }
        }
        return null;
    }

    public double getClassAverage(){
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        double sumOfAllAverages = 0;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                sumOfAllAverages += students[i].getAverage();
                count++;
            }
        }
        return Double.parseDouble(decimalFormat.format(sumOfAllAverages/count));
    }

    public String listStudentsByScore() {
        ArrayList<Student> noEmptySpaces = new ArrayList<>();
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                noEmptySpaces.add(this.students[i]);
            }
        }
        Collections.sort(noEmptySpaces, Student.averageGradeComparator.thenComparing(Student::getLastName));
        return noEmptySpaces.toString();
    }

    public ArrayList<Student> getOrderedStudentsAsList() {
        ArrayList<Student> noEmptySpaces = new ArrayList<>();
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                noEmptySpaces.add(this.students[i]);
            }
        }
        Collections.sort(noEmptySpaces, Student.averageGradeComparator.thenComparing(Student::getLastName));
        return noEmptySpaces;
    }

    public String gradeClass() {
        ArrayList<Student> OrderedListOfStudents = this.getOrderedStudentsAsList();
        StringBuilder gradedStudents = new StringBuilder();
        for (int index = 0; index < OrderedListOfStudents.size(); index++) {
            if ((int) Math.ceil(OrderedListOfStudents.size() * .1) >= index + 1) {
                gradedStudents.append(OrderedListOfStudents.get(index).getFirstName() + " " + OrderedListOfStudents.get(index).getLastName() + " : A\n");
            } else if ((int) Math.ceil(OrderedListOfStudents.size() * .29) >= index + 1) {
                gradedStudents.append(OrderedListOfStudents.get(index).getFirstName() + " " + OrderedListOfStudents.get(index).getLastName() + " : B\n");
            } else if ((int) Math.ceil(OrderedListOfStudents.size() * .5) >= index + 1) {
                gradedStudents.append(OrderedListOfStudents.get(index).getFirstName() + " " + OrderedListOfStudents.get(index).getLastName() + " : C\n");
            } else if ((int) Math.ceil(OrderedListOfStudents.size() * .89) >= index + 1) {
                gradedStudents.append(OrderedListOfStudents.get(index).getFirstName() + " " + OrderedListOfStudents.get(index).getLastName() + " : D\n");
            } else if ((int) Math.ceil(OrderedListOfStudents.size() * .89) <= index + 1){
                gradedStudents.append(OrderedListOfStudents.get(index).getFirstName() + " " +OrderedListOfStudents.get(index).getLastName() + " : F\n");
            }
        }
        return gradedStudents.toString();
    }
}
