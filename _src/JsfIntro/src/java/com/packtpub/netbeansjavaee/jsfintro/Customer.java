/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.jsfintro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author heffel
 */
@ManagedBean
@RequestScoped
public class Customer {

    private String firstName;
    private String lastName;
    private Integer age;

    /**
     * Creates a new instance of Customer
     */
    public Customer() {
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
