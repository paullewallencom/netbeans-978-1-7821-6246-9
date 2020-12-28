/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.managedbean;

import com.packtpub.netbeansjavaee.jpa.dao.CustomerFacade;
import com.packtpub.netbeansjavaee.jpa.entity.Customer;
import java.util.List;
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
    private Integer customerId;
    private Customer customer;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public CustomerController() {
    }

    public List<Customer> getAllCustomers() {
        return customerFacade.getAllCustomersJpql();
    }

    public Customer getCustomer() {
        customer = customerFacade.getCustomerJpql(customerId);
        
        return customer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public String retrieveCustomer(){
        getCustomer();
        
        return "customer_id_output";
    }
    
    public String insertTemporaryCustomers(){
        customerFacade.insertCustomers();
        return "customers_inserted_output";
    }
    
    public String updateTemporaryCustomers(){
        customerFacade.updateCustomers();
        
        return "customers_updated_output";
    }
    
    public String deleteTemporaryCustomers(){
        customerFacade.deleteCustomers();
        
        return "customers_deleted_output";
    }
}
