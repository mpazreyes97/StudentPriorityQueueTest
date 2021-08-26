package com.company;

import java.util.*;

public class Priorities {

    public Priorities() {
    }

    //Time Complexity of the algorithm = O(n^2)
    public List<Student> getStudents(List<String> events) {
        StudentComparator studentComparator = new StudentComparator();
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(events.size(), studentComparator);

        for (String event : events) {
            //split de words in the line to process the information
            String[] strings = splitString(event);
            if (strings[0].equals("ENTER")) { //enter a student to de priority queue
                Student student = new Student(Integer.parseInt(
                    strings[3]),
                    strings[1],
                    Double.parseDouble(strings[2]));
                studentPriorityQueue.add(student);
            } else if (strings[0].equals("SERVED")) {//serve a student
                studentPriorityQueue.poll();
            }else{
                System.err.println("Please write a valid command: ENTER <name> <cumulativeGradePointAverage> <id> or SERVED");
            }
        }

        List<Student> studentList = new ArrayList<>();
        while (!studentPriorityQueue.isEmpty()) {
            studentList.add(studentPriorityQueue.poll());
        }
        //Collections.reverse(studentList);

        return studentList;
    }

    private String[] splitString(String event) {
        return event.split(" ");
    }
}

class StudentComparator implements Comparator<Student> {

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
