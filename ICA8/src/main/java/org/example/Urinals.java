package org.example;

public class Urinals {
    String urinals;
    public boolean readInput(String input)
    {
       urinals=input;
       if(input==""||input.length()>20) return false;


       return true;
    }
}
