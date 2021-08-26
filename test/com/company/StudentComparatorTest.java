package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentComparatorTest {

    private StudentComparator comparator;

    @BeforeEach
    public void init() {
        this.comparator = new StudentComparator();
    }

    @Test
    void compareWithHighestCGPA() {
        Student pepito = new Student(1, "Pepito", 5);
        Student david = new Student(2, "David", 3);

        assertTrue(this.comparator.compare(pepito, david) < 0,
            "Pepito should go first since he has better CGPA");
    }

    @Test
    void compareWithSameCGPA() {
        Student pepito = new Student(1, "Pepito", 3);
        Student david = new Student(2, "David", 3);

        assertTrue(this.comparator.compare(pepito, david) > 0,
            "Pepito should go after David since David is lexicographically bigger then Pepito");
    }

    @Test
    void compareWithSameCGPAAndName() {
        Student pepito1 = new Student(1, "Pepito", 3);
        Student pepito2 = new Student(2, "Pepito", 3);

        assertTrue(this.comparator.compare(pepito1, pepito2) < 0);
    }
}
