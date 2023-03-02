package org.example;

public class Urinals {
    String urinals;
    public boolean readInput(String input)
    {
       urinals=input;
       if(input==""||input.length()>20) return false;
       for(char curr:input.toCharArray())
       {
           if(curr!=0||curr!=1) return false;
       }

       return true;
    }
}
