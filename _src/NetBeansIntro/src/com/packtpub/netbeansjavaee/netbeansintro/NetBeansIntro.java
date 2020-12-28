/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.netbeansintro;

/**
 *
 * @author heffel
 */
public class NetBeansIntro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customer customer = new Customer("John", "Doe", 33);
        
        customer.setFirstName("Dan");
        
        System.out.println(customer);
    }
}
