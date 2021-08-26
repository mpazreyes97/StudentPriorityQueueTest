package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrioritiesTest {

    private Priorities priorities;

    @BeforeEach
    void init() { this.priorities = new Priorities(); }

    @Test
    void getStudents() {
        List<String> events = createEventList();

        List<Student> students = priorities.getStudents(events);

        assertEquals("Dan", students.get(0).getName());
        assertEquals("Ashley", students.get(1).getName());
        assertEquals("Shafaet", students.get(2).getName());
        assertEquals("Maria", students.get(3).getName());
    }

    private List<String> createEventList() {
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        return events;
    }

    @Test
    void getStudentsWithSameAverage() {
        List<String> events = new ArrayList<>();
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");

        List<Student> students = priorities.getStudents(events);

        assertEquals("Anik", students.get(0).getName());
        assertEquals("Dan", students.get(1).getName());
    }

    @Test
    void getStudentsWithSameAverageAndName() {
        List<String> events = new ArrayList<>();
        events.add("ENTER Dan 3.95 49");
        events.add("ENTER Dan 3.95 50");

        List<Student> students = priorities.getStudents(events);

        assertEquals(49, students.get(0).getId());
    }

    @Test
    void getStudentsAfterFirstServe() {
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");

        List<Student> students = priorities.getStudents(events);

        assertEquals(1, students.size());
        assertEquals("Shafaet", students.get(0).getName());
    }

    @Test
    void getStudentsAfterSecondServe() {
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");

        List<Student> students = priorities.getStudents(events);

        assertEquals(3, students.size());
        assertEquals("Ashley", students.get(0).getName());
        assertEquals("Shafaet", students.get(1).getName());
        assertEquals("Maria", students.get(2).getName());
    }
}
