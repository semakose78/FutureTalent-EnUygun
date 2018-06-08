package com.company;

import com.sun.media.sound.InvalidDataException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidDataException {
        System.out.print("Test etmek istediğiniz soru numarasını giriniz (Çıkmak için 0 giriniz) : ");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        while (inputNumber != 0){
            switch (inputNumber){
                case 1:
                    //TEST FOR FIRST QUESTION
                    System.out.println();
                    System.out.println("Birinci sorunun testi : ");
                    System.out.println(".........................");
                    testQuestion1();
                    System.out.println();
                    break;
                case 2:
                    //TEST FOR SECOND QUESTION
                    System.out.println();
                    System.out.println("İkinci sorunun testi : ");
                    System.out.println(".........................");
                    System.out.println();
                    testQuestion2();
                    System.out.println();
                    break;
                case 3:
                    //TEST FOR THIRD QUESTION
                    System.out.println();
                    System.out.println("Üçüncü sorunun testi : ");
                    System.out.println(".........................");
                    System.out.println();
                    testQuestion3();
                    System.out.println();
                    break;
                case 4:
                    //TEST FOR FOURTH QUESTION
                    System.out.println();
                    System.out.println("Dördüncü sorunun testi : ");
                    System.out.println(".........................");
                    testQuestion4();
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Geçersiz soru numarası");
                    System.out.println();
                    break;
            }
            System.out.print("Test etmek istediğiniz soru numarasını giriniz (Çıkmak için 0 giriniz.) : ");
            inputNumber = input.nextInt();
        }
    }

    public static void testQuestion1() throws InvalidDataException {
        Integer x_points[] = new Integer[4];
        Integer y_points[] = new Integer[4];

        //Initialize the triangle's corners and the fourth point
        for (int i = 0; i <4 ; i++) {
            System.out.print("x"+(i+1)+", " + "y" + (i+1) +" : ");
            Scanner input = new Scanner(System.in);
            x_points[i] = input.nextInt();
            y_points[i] = input.nextInt();
        }

        //Print the points
        System.out.println();
        System.out.println("Girdi : \n");
        for (int i = 0; i <x_points.length ; i++) {
            System.out.println("x"+(i+1) + ", "+ "y"+(i+1) +" : " + x_points[i] +" "+ y_points[i]);
        }

        //Create the triangle
        FirstQuestion test = new FirstQuestion(x_points, y_points);
        System.out.println();
        if(test.isInTheTriangle())
            System.out.println("Sonuç : 4. nokta üçgenin içinde.");
        else
            System.out.println("Sonuç : 4. nokta üçgenin dışında.");
    }

    public static void testQuestion2(){
        //Take the start number from user
        System.out.print("Başlangıç sayısını giriniz : ");
        Scanner input = new Scanner(System.in);
        Integer startNumber = input.nextInt();

        //Print the start number and the pyramid
        System.out.println();
        System.out.println("Başlangıç Sayısı : " + startNumber +"\n");
        SecondQuestion test = new SecondQuestion(startNumber);
        test.printFactorialTriange();
    }

    public static void testQuestion3(){
        //Take the number which wanted to be taken the square root from user
        System.out.print("Karekökü alınacak sayıyı giriniz : ");
        Scanner input = new Scanner(System.in);
        ThirdQuestion test = new ThirdQuestion();
        Integer number = input.nextInt();
        //Print the number and the square root with steps
        System.out.println();
        System.out.print("Karekökü alınacak sayı = " + number);
        System.out.println();
        double squareRoot = test.getSquareRoot(number);
        System.out.println("\nKarekökü = " + squareRoot);
    }

    public static void testQuestion4(){
        //Print the chess board
        System.out.println();
        System.out.println("Satranç Tahtası : ");
        System.out.println();
        FourtQuestion test = new FourtQuestion();
        test.printTheBoard();
        System.out.println();
        test.printLocations();
        //Print the result
        System.out.println("Sonuç : En fazla " + test.getKnightCount() + " tane at konabilir.");
    }
}
