package org.example;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
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
                } else {
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

   public int consoleRead()
    {
        Scanner scan = new Scanner(System.in);
        String x="";
        int res;
        do{
            System.out.println("Enter a string to get the number of free spots, or -1 to stop the program");
            x=scan.nextLine();
            res= validSpots(x);
            if(res== -1 && !x.equals("-1")) System.out.println("Invalid Inputs");
        }
        while(!x.equals("0"));
        System.out.println(-1);
        scan.close();
        return 0;
    }

    public boolean readInFile(String filename) {
        StringBuffer buffer = new StringBuffer();
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            String input = "";
            while(scan.hasNext() && !input.equals("-1")) {
                input = scan.nextLine();
                int res = validSpots(input);
                System.out.println(input + " : " + res);
                if(res == -1 && !input.equals("-1")) {
                    buffer.append("Invalid Input");
                } else {
                    buffer.append(res);
                }
            }

            scan.close();
        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

}
