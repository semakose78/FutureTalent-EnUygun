package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class SecondQuestion {
    private Integer startNumber;

    //Initializer constructor
    public SecondQuestion(Integer startNumber) {
        this.startNumber = startNumber;
    }

    //This method prints the factorial values line by line as a triangle
    public void printFactorialTriange(){
        //Reminder value for start of the new line
        BigDecimal remainder = BigDecimal.valueOf(0);

        //First step
        if((startNumber >= 1) || startNumber == 0){
            System.out.print(factorial(BigDecimal.valueOf(1)) + "\n");
            remainder = BigDecimal.valueOf(1);
        }

        //Second step
        for (int i = 2; i <startNumber+1 ; i++) {
            for (int j = 1; j < i+1; j++) {
                //if end of the line print new line character after the value printed
                if(j == i){
                    if(remainder.compareTo(BigDecimal.valueOf(10))>=0){
                        NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
                        String str = formatter.format(factorial(BigDecimal.valueOf(j).add(remainder)));
                        System.out.print(str + "\n");
                    }
                    else{
                        System.out.print(factorial(BigDecimal.valueOf(j).add(remainder)) + "\n");
                    }
                    remainder = BigDecimal.valueOf(j).add(remainder);
                }
                //if it's not the end of the line, print " " between numbers
                else{
                    if(remainder.compareTo(BigDecimal.valueOf(10))>=0){
                        NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
                        String str = formatter.format(factorial(BigDecimal.valueOf(j).add(remainder)));
                        System.out.print(str + " ");
                    }
                    else{
                        System.out.print(factorial(BigDecimal.valueOf(j).add(remainder)) + " ");
                    }
                }
            }
        }
    }

    //This method returns the factorial of the given number
    private BigDecimal factorial(BigDecimal number){
        if(number.equals(BigDecimal.valueOf(0)) || number.equals(BigDecimal.valueOf(1)))
            return BigDecimal.valueOf(1);
        return number.multiply(factorial(number.subtract(BigDecimal.valueOf(1))));
    }
}
