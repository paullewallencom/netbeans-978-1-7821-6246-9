/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.jpa.dao;

import com.packtpub.netbeansjavaee.jpa.entity.Customer;
import com.packtpub.netbeansjavaee.jpa.entity.DiscountCode;
import com.packtpub.netbeansjavaee.jpa.entity.MicroMarket;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author heffel
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "JPQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public List<Customer> getAllCustomersJpql() {
        String queryString = "select c from Customer c where c.name = 'Jumbo Eagle Corp'";
        Query query = em.createQuery(queryString);
        List<Customer> resultList = query.getResultList();

        return resultList;
    }

    public Customer getCustomerJpql(Integer customerId) {
        String queryString = "select c from Customer c where c.customerId = :id";
        Query query = em.createQuery(queryString);

        query.setParameter("id", customerId);
        Object result = query.getSingleResult();

        return (Customer) result;
    }

    public String retrieveCustomer() {

        return "customer_id_output";
    }

    /**
     * Insert some temporary customers into the database
     *
     * For test/demonstration purposes only
     */
    public void insertCustomers() {
        List<Customer> customerList = new ArrayList<>(3);
        Integer firstNewId = 900;
        Customer tempCustomer;

        DiscountCode discountCode = em.find(DiscountCode.class, 'N');
        MicroMarket microMarket = em.find(MicroMarket.class, "95051");

        //create temporary customers (in memory)
        for (int i = 0; i < 3; i++) {
            tempCustomer = new Customer();
            tempCustomer.setCustomerId(firstNewId++);
            tempCustomer.setName("Temporary Customer " + (firstNewId - 1));
            tempCustomer.setDiscountCode(discountCode);
            tempCustomer.setZip(microMarket);

            customerList.add(tempCustomer);
        }

        //persist temporary customers to the database
        for (Customer customer : customerList) {
            create(customer);
        }

    }

    public void updateCustomers() {
        String queryString = "UPDATE Customer SET city='Washington' WHERE name LIKE 'Temporary%'";
        
        Query query = em.createQuery(queryString);
        
        query.executeUpdate();
    }
    
    public void deleteCustomers() {
        String queryString = "DELETE FROM Customer c where c.name LIKE 'Temporary%'";
        
        Query query = em.createQuery(queryString);
        
        query.executeUpdate();
    }
}
