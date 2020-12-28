/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.managedbean;

import com.packtpub.netbeansjavaee.jpa.dao.CustomerFacade;
import com.packtpub.netbeansjavaee.jpa.entity.Customer;
import java.util.List;
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
public class CustomerController {

    @EJB
    private CustomerFacade customerFacade;
    private List<Customer> customerList;

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }

    @PostConstruct
    public void init() {
        customerList = customerFacade.findAll();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
