package com.example.binaryclaculator;

public class BinaryNumberCalculator {

    public BinaryNumberCalculator(){

    }

    public String add(int a,int b){
        int sum = a + b;
        return Integer.toBinaryString(sum);
    }

    public String substract(int a, int b){
        int sub = a-b;
        return Integer.toBinaryString(sub);
    }

}
