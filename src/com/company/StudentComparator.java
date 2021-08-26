package com.company;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getCumulativeGradePointAverage() == student2.getCumulativeGradePointAverage()) {
            if (student1.getName().compareTo(student2.getName()) == 0) {
                return Integer.compare(student1.getId(), student2.getId());
            } else {
                return student1.getName().compareTo(student2.getName());
            }
        } else {
            return Double.compare(student1.getCumulativeGradePointAverage(), student2.getCumulativeGradePointAverage()) * -1;
        }
    }
}