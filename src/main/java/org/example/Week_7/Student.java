package org.example.Week_7;

// OOP Basics (Class & Object)
// Assignment: Create a Student class and print its data using objects.

public class Student {
    // Attributes
    private String name;
    private int rollNumber;
    private int age;

    // Constructor to initialize the Student object
    public Student(String name, int rollNumber, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Age: " + age);
        System.out.println(); // Empty line for separation
    }

    public static void main(String[] args) {
        // Create Student objects
        Student student1 = new Student("Alice Johnson", 101, 20);
        Student student2 = new Student("Bob Smith", 102, 22);

        // Display student details using objects
        student1.displayDetails();
        student2.displayDetails();
    }
}
