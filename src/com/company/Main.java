package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            //get the number of events
            int n = scanner.nextInt();

            //create the events list
            List<String> eventsList = new ArrayList<>();

            //Data reading
            for (int i = 0; i <= n; i++) {
                if (scanner.hasNext("ENTER") || scanner.hasNext("SERVED")) {
                    String line = scanner.nextLine();
                    if (!line.isEmpty()) {
                        eventsList.add(line);
                    }
                }
            }
            if (eventsList.size() == n) {
                //run getStudents to show the results
                Priorities priorities = new Priorities();
                List<Student> studentList = priorities.getStudents(eventsList);

                //show the results
                if (studentList.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    for (Student student : studentList) {
                        System.out.println(student.getName());
                    }
                }
            } else {
                System.out.println("the number of valid entries is not equal to the total number of events");
            }
        } catch (Exception exception) {
            System.out.println("error, Invalid number");
        }
    }
}
