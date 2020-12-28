/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.sessionbean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author heffel
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class HelloSessionBean {

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String sayHello() {
        return "Hello world";
    }
}
