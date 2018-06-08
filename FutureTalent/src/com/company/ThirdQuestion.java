package com.company;

public class ThirdQuestion {
    private int number;
    private double squareRoot;
    private int degree;

    //This constructor initializes the degree of the square root
    public ThirdQuestion() {
        this.degree = 5;
    }

    //This method calculates the square root from 5th degree by applying the formula
    private void calculateTheSquareRoot(){
        double initial = number/2;
        for (int i = 0; i <degree ; i++) {
            System.out.print("x"+i+" = " + "(" + initial + "+" + number + "/" + initial + ")" + "/2" + " = ");
            initial = (initial + (number/initial))/2;
            System.out.println(initial);
        }
        squareRoot = initial;
    }

    //This method calls the calculating method and returns the value of the square root
    public double getSquareRoot(int number) {
        this.number = number;
        System.out.println();
        calculateTheSquareRoot();
        return squareRoot;
    }
}
