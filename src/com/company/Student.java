package com.company;

public class Student {

    private final int id;
    private final String name;
    private final double cumulativeGradePointAverage;

    public Student(int id, String name, double cumulativeGradePointAverage) {
        this.id = id;
        this.name = name;
        this.cumulativeGradePointAverage = cumulativeGradePointAverage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCumulativeGradePointAverage() {
        return cumulativeGradePointAverage;
    }
}
