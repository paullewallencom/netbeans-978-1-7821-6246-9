/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.netbeansintro;

/**
 *
 * @author heffel
 */
public class Customer {

    public Customer() {
    }

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
    }
}
