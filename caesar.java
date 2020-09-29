package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;
        do {
            System.out.println("plaintext: ");
            text = input.nextLine();
        } while (text.equals(""));



        String operation;
        do {
        System.out.println("Encode or Decode?");
        operation = input.nextLine();
        } while (!operation.equals("Encode") && !operation.equals("encode") && !operation.equals("Decode") && !operation.equals("decode") && !operation.equals("e") && !operation.equals("d"));


        String mytext;
        if(operation.equals("encode") || operation.equals("Encode") || operation.equals("e")){
            mytext = encode(text);
            System.out.println("Ciphertext: " + mytext);
        }
        if(operation.equals("decode") || operation.equals("Decode") || operation.equals("d")){
            mytext = decode(text);
            System.out.println("Decoded text: " + mytext);
        }
    }

    static String encode(String mytext) {
        char[] alpha = new char[mytext.length()];
        String message = "";
        for(int i = 0; i<mytext.length(); i++) {
            if(Character.isUpperCase(mytext.charAt(i))) {
                alpha[i] = mytext.charAt(i);
                int letnum = ((((alpha[i] - 65) + 1)%26)+65);
                alpha[i] = (char)letnum;
                message += alpha[i];
            } else if(Character.isLowerCase(mytext.charAt(i))) {
                alpha[i] = mytext.charAt(i);
                int letnum = ((((alpha[i] - 97) + 1)%26)+97);
                alpha[i] = (char)letnum;
                message += alpha[i];
            } else
                message += (mytext.charAt(i));
        }
        return message;
    }
    static String decode(String mytext) {
        char[] alpha = new char[mytext.length()];
        String message = "";
        for(int i = 0; i<mytext.length(); i++) {
            if(Character.isUpperCase(mytext.charAt(i))) {
                alpha[i] = mytext.charAt(i);
                int letnum = ((((alpha[i] - 65) - 1)%26)+65);
                alpha[i] = (char)letnum;
                message += alpha[i];
            } else if(Character.isLowerCase(mytext.charAt(i))) {
                alpha[i] = mytext.charAt(i);
                int letnum = ((((alpha[i] - 97) - 1)%26)+97);
                alpha[i] = (char)letnum;
                message += alpha[i];
            } else
                message += (mytext.charAt(i));
        }
        return message;
    }
}
