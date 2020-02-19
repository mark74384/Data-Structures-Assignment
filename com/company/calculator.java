package com.company;

public class calculator implements icalculator {

    @Override
    public int add (int x , int y) {
        return x + y ;
    }
    @Override
    public float divide (int x , int y){
        if (y == 0){
            throw new RuntimeException("you cannot divide by zero!");
        }
        else {
        float sol = (float) x / y;
        return sol ;
    }}
}
