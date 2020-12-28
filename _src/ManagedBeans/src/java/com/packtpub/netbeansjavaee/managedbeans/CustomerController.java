/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author heffel
 */
@ManagedBean
@RequestScoped
public class CustomerController {

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }
    
    public String navigate(){
        //some processing done here
        //typically save to database
        
        System.out.println("navigate() invoked");
        
        return "confirmation";
    }
}
