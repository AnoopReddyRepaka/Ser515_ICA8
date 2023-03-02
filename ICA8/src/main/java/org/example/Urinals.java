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
        int count = 0;
        System.out.println("input: " + input);
        if(readInput(input)) {
            char[] inputArray = input.toCharArray();
            char previous = '_', pre_previous = '_';
            for (char curr : inputArray) {
                if (pre_previous == '_') { //__00000
                    pre_previous = curr;
                } else if (previous == '_') { // 0_0_000
                    previous = curr;
                } else { // 00_0_00
                    System.out.println("order: " + pre_previous + " " + previous + " " + curr);
                    if (pre_previous == '0' && previous == '0' && curr == '0') {
                        count++;
                    }
                    pre_previous = previous;
                    previous = curr;
                }
            }
            return count;
        }
        return -1;
    }
}
