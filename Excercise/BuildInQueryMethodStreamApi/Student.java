package Excercise.BuildInQueryMethodStreamApi;

import java.util.ArrayList;

public class Student {
    public String facultyNumber;
    public String firstName;
    public String lastName;
    public String email;
    public int age;
    public int group;
    public ArrayList<Integer> grades;
    public String phone;

    public Student() {
    }

    public Student(String facultyNumber, String firstName, String lastName, String email, int age, int group, ArrayList<Integer> grades, String phones) {

        this.facultyNumber = facultyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.group = group;
        this.grades = grades;
        this.phone = phones;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    private void setGroup(int group) {
        this.group = group;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    private void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }
}
