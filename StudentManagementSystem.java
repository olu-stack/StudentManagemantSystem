
package com.mycompany.studentmanagementsystem;

import java.util.Scanner;

// Name: Oluwaferanmi Olomo
// Student Management System

public class StudentManagementSystem {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Student information
        System.out.println("====================================");
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student ID: ");
        int id = input.nextInt();

        System.out.print("Enter age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter course: ");
        String course = input.nextLine();

        // Get and validate grades
        double midterm = getValidGrade("Enter midterm grade: ");
        double finalExam = getValidGrade("Enter final exam grade: ");
        double assignment = getValidGrade("Enter assignment grade: ");
        double attendance = getValidGrade("Enter attendance percentage: ");

        // Calculate quiz average
        double quizAverage = calculateQuizAverage();

        // Calculate final grade and letter grade
        double finalGrade = calculateFinalGrade(
                midterm, finalExam, assignment);

        String letterGrade = getLetterGrade(finalGrade);
        boolean passed = hasPassed(finalGrade, attendance);

        // Display menu until the user chooses Exit
        int choice = 0;

        while (choice != 6) {

            System.out.println("\n====================================");
            System.out.println("MAIN MENU");
            System.out.println("====================================");
            System.out.println("1. Display Student Information");
            System.out.println("2. Display Final Grade");
            System.out.println("3. Display Letter Grade");
            System.out.println("4. Display Course Status");
            System.out.println("5. Display Quiz Average");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displayStudentInfo(name, id, age, course);
                    break;

                case 2:
                    System.out.printf("Final Grade: %.2f%n", finalGrade);
                    break;

                case 3:
                    System.out.println("Letter Grade: " + letterGrade);
                    break;

                case 4:
                    if (passed) {
                        System.out.println("Course Status: PASS");
                    } else {
                        System.out.println("Course Status: FAIL");
                    }
                    break;

                case 5:
                    System.out.printf("Quiz Average: %.2f%n", quizAverage);
                    break;

                case 6:
                    System.out.println(
                            "Thank you for using the Student Management System.");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        input.close();
    }

    // Validates that a grade is between 0 and 100
    public static double getValidGrade(String prompt) {
        double grade;

        do {
            System.out.print(prompt);
            grade = input.nextDouble();

            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Try again.");
            }

        } while (grade < 0 || grade > 100);

        return grade;
    }

    // Calculates the final grade using the three academic grades
    public static double calculateFinalGrade(
            double midterm,
            double finalExam,
            double assignment) {

        return (midterm * 0.30)
                + (finalExam * 0.40)
                + (assignment * 0.30);
    }

    // Returns the letter grade
    public static String getLetterGrade(double grade) {

        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // A student passes only if both requirements are met
    public static boolean hasPassed(
            double grade,
            double attendance) {

        return grade >= 60 && attendance >= 70;
    }

    // Displays student information
    public static void displayStudentInfo(
            String name,
            int id,
            int age,
            String course) {

        System.out.println("\nStudent Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }

    // Collects five quiz grades and returns their average
    public static double calculateQuizAverage() {

        double total = 0;

        for (int i = 1; i <= 5; i++) {
            double quiz = getValidGrade("Enter Quiz " + i + ": ");
            total += quiz;
        }

        return total / 5;
    }
}

