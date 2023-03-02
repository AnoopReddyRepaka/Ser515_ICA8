package org.example;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.*;
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
        
        if(readInput(input)) {
            char[] inputArray = input.toCharArray();
            char previous = '_', pre_previous = '_';
            for (char curr : inputArray) {
                if (pre_previous == '_') { //__00000
                    pre_previous = curr;
                } else if (previous == '_') { // 0_0_000
                    previous = curr;
                } else {

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
        String input;
        int res;
        do {
            System.out.println("Enter a urinal string to get the free spots, or -1 to stop the program");
            input = scan.nextLine();
            res = validSpots(input);
            if(res == -1 && !input.equals("-1")) {
                System.out.println("-1");
            } else {
                System.out.println(res);
            }
        } while (!input.equals("-1"));
        System.out.println(-1);
        scan.close();
        return 0;
    }

    public boolean readInFile(String filename) {
        StringBuilder buffer = new StringBuilder();
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            String input = "";
            while(scan.hasNext() && !input.equals("-1")) {
                input = scan.nextLine();
                int res = validSpots(input);
                if(res == -1 && !input.equals("-1")) {
                    buffer.append("-1");
                } else {
                    buffer.append(res);
                }
                buffer.append("\n");
            }
            String base = "output";
            base= base+"/rule";
            int copy = 0;
            boolean loop = true;
            do { // getting file name to write to
                String filename2 = base;
                if(copy != 0) {
                    filename2 += "" + copy;
                }
                filename2 += ".txt";
                File version = new File(filename2);
                if (version.exists()) { // iterate through
                    copy++;
                } else { // not an existing file, need to make one
                    loop = false;
                    FileWriter fw = new FileWriter(version);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(buffer.toString());
                    bw.close();
                    scan.close();
                }
            } while(loop);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
