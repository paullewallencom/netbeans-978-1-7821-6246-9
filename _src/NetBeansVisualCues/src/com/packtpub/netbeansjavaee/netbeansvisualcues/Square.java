/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.netbeansvisualcues;

/**
 *
 * @author heffel
 */
public class Square extends Rectangle {

    @Override
    public void setSide1(double side1) {
        super.setSide1(side1); 
        super.setSide2(side1);
    }

    @Override
    public void setSide2(double side2) {
        setSide1(side2);
    }
    
}
