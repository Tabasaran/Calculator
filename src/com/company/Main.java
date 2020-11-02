package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int firstNumber, secondNumber;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parse = input.split(" ");

        if (parse.length != 3) {
            System.out.println("invalid input");
            return;
        }

        try {
            firstNumber = Integer.parseInt(parse[0]);
            secondNumber = Integer.parseInt(parse[2]);

            if (firstNumber < 1 || firstNumber > 10 ||  secondNumber < 1 || secondNumber > 10){
                System.out.println("invalid input");
                return;
            }

            char symbol = parse[1].charAt(0);


            switch (symbol){
                case '+':
                    System.out.println(firstNumber + secondNumber);
                    break;
                case '-':
                    System.out.println(firstNumber - secondNumber);
                    break;
                case '/':
                    System.out.println(firstNumber / secondNumber);
                    break;
                case '*':
                    System.out.println(firstNumber * secondNumber);
                    break;
                default:
                    System.out.println("invalid input");
                    return;
            }
        } catch (NumberFormatException e) {
            try {
                firstNumber = RomanNumber.romanToInt(parse[0]);
                secondNumber = RomanNumber.romanToInt(parse[2]);

                if (firstNumber < 1 || firstNumber > 10 ||  secondNumber < 1 || secondNumber > 10){
                    System.out.println("invalid input");
                    return;
                }

                char symbol = parse[1].charAt(0);


                switch (symbol){
                    case '+':
                        System.out.println(RomanNumber.intToRoman(firstNumber + secondNumber));
                        break;
                    case '-':
                        System.out.println(RomanNumber.intToRoman(firstNumber - secondNumber));
                        break;
                    case '/':
                        System.out.println(RomanNumber.intToRoman(firstNumber / secondNumber));
                        break;
                    case '*':
                        System.out.println(RomanNumber.intToRoman(firstNumber * secondNumber));
                        break;
                    default:
                        System.out.println("invalid input");
                        return;
                }
            } catch (Exception exception) {
                System.out.println("invalid input");
            }

        }

    }
}

class RomanNumber {

    private static int processInt(int currentNumber, int lastNumber, int number){
        if (lastNumber > currentNumber){
            return number - currentNumber;
        } else {
            return number + currentNumber;
        }
    }

    public final static int romanToInt(String romanNumeral){
        romanNumeral = romanNumeral.toUpperCase();
        int number = 0;
        int lastNumber = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char convertToRoman = romanNumeral.charAt(i);
            switch (convertToRoman){
                case 'C':
                    number = processInt(100,lastNumber,number);
                    lastNumber = 100;
                    break;
                case 'L':
                    number = processInt(50, lastNumber, number);
                    lastNumber = 50;
                    break;

                case 'X':
                    number = processInt(10, lastNumber, number);
                    lastNumber = 10;
                    break;

                case 'V':
                    number = processInt(5, lastNumber, number);
                    lastNumber = 5;
                    break;

                case 'I':
                    number = processInt(1, lastNumber, number);
                    lastNumber = 1;
                    break;
                default:
                    return -1;
            }
        }


        return number;
    }

    public final static String intToRoman(int number) {
        if (number < 1 || number > 399)
            return "Invalid Roman Number Value";
        String romanNumber = "";

        while (number >= 100) {
            romanNumber += "C";
            number -= 100;
        }
        while (number >= 90) {
            romanNumber += "XC";
            number -= 90;
        }
        while (number >= 50) {
            romanNumber += "L";
            number -= 50;
        }
        while (number >= 40) {
            romanNumber += "XL";
            number -= 40;
        }
        while (number >= 10) {
            romanNumber += "X";
            number -= 10;
        }
        while (number >= 9) {
            romanNumber += "IX";
            number -= 9;
        }
        while (number >= 5) {
            romanNumber += "V";
            number -= 5;
        }
        while (number >= 4) {
            romanNumber += "IV";
            number -= 4;
        }
        while (number >= 1) {
            romanNumber += "I";
            number -= 1;
        }
        return romanNumber;
    }
}
