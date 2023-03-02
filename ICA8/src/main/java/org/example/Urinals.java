package org.example;

public class Urinals {
    String urinals;
    public boolean readInput(String input)
    {
       urinals=input;
       if(input== ""||input.length()>20) return false;
       for(char curr:input.toCharArray())
       {
           if(curr!= '0'&& curr!='1') return false;
       }
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '1' && input.charAt(i + 1) == '1') {
                return false;
            }
        }

       return true;
    }

    public int validSpots(String input)
    {
        return -1;
    }
}
