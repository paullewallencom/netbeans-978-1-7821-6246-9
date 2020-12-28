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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

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

    public List<Customer> getAllCustomersCriteriaAPI() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);
        TypedQuery<Customer> typedQuery = em.createQuery(criteriaQuery);

        List<Customer> resultList = typedQuery.getResultList();

        return resultList;
    }

    public Customer getCustomerCriteriaAPI(Integer customerId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        ParameterExpression<Integer> parameterExpression = criteriaBuilder.parameter(Integer.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("customerId"), parameterExpression));
        TypedQuery<Customer> typedQuery = em.createQuery(criteriaQuery);
        typedQuery.setParameter(parameterExpression, customerId);

        Object result = typedQuery.getSingleResult();

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
