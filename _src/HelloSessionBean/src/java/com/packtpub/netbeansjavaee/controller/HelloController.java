/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.controller;

import com.packtpub.netbeansjavaee.sessionbean.HelloSessionBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author heffel
 */
@ManagedBean
@RequestScoped
public class HelloController {
    
    private String greeting;
    
    @EJB
    private HelloSessionBean newSessionBean;
    
    @PostConstruct
    public void init(){
        greeting = newSessionBean.sayHello();
    }

    /**
     * Creates a new instance of HelloController
     */
    public HelloController() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    
}
