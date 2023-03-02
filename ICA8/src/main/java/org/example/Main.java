package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Urinals urinals= new Urinals();
        int input;
        boolean valid = true;
        do {
            System.out.println("Enter 1 to run the program using the console, or 2 to run it using files.");
            input = scan.nextInt();
            if (input != 1 && input != 2) {
                System.out.println("Invalid Input");
            } else {
                valid = true;
            }
        } while(!valid);
        if(input == 1) {
            System.out.println(urinals.consoleRead());
        } else {
            // read in file?
            urinals.readInFile("src/main/resources/urinal.dat");
        }



    }
}