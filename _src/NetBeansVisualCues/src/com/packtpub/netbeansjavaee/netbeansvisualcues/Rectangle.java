/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.netbeansvisualcues;

/**
 *
 * @author heffel
 */
public class Rectangle implements Shape {

    private double side1;
    private double side2;
    
    @Override
    public double area() {
        return side1 * side2;
    }

    @Override
    public double perimeter() {
        return 2 * (side1 + side2);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }
}
