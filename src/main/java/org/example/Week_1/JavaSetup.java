package org.example.Week_1;

//Assignment: Write a Java program that prints your name and age.

public class JavaSetup {

    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        JavaSetup newObject = new JavaSetup();

        newObject.setName("Sai");
        newObject.setAge(25);
        System.out.println("Name: " + newObject.getName() + ", age: " + newObject.getAge());
    }
}
