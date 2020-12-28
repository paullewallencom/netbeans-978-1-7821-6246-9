/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.sessionbean;

import com.packtpub.netbeansjavaee.sessionbean.interceptor.LoggingInterceptor;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author heffel
 */
@Stateless
public class HelloSessionBean {

    @Interceptors({LoggingInterceptor.class})
    public String sayHello() {
        return "Hello world";
    }
}
