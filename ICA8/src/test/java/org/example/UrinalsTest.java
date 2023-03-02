package org.example;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void readInput() {
        Urinals urinals=new Urinals();

        assertTrue(urinals.readInput("1001001"));
    }

    @Test
    void addEmptyString() {
        Urinals urinals=new Urinals();

        assertFalse(urinals.readInput(""));
    }
    @Test
    void readIn_tooLong() {
        Urinals urinals=new Urinals();

        assertFalse(urinals.readInput("00000000000000000000000"));
    }
    @Test
    void readIn_InvalidCharacter(){
        Urinals urinals=new Urinals();

        assertFalse(urinals.readInput("a0000"));
    }
    @Test
    void readIn_neighbor1s()
    {
        Urinals urinals=new Urinals();

        assertFalse(urinals.readInput("01111"));

    }
    @Test
    void ValidSpotsFirst()
    {
        Urinals urinals= new Urinals();
        assertEquals(3,urinals.validSpots("00000"));
    }
    @Test
    void ValidSpotsSecond()
    {
        Urinals urinals= new Urinals();
        assertEquals(0,urinals.validSpots("10101"));
    }
    @Test
    void ValidSpotsThird()
    {
        Urinals urinals= new Urinals();
        assertEquals(1,urinals.validSpots("101000"));
    }
    @Test
    void ReadinFileTest()
    {
        Urinals urinals= new Urinals();
        assertTrue(urinals.readInFile("src/main/resources/urinal.dat"));
    }
    @Test
    void FilenotFound()
    {
        Urinals urinals= new Urinals();
        String filename="src/main/resources/urinals.dat";
        assertFalse(urinals.readInFile(filename));
    }
    @Test
    void emptyFile()
    {
        Urinals urinals= new Urinals();
        String filename="";
        assertFalse(urinals.readInFile(filename));
    }
    @Test



        public void readIoexception() throws IOException {
            String filename = "src/main/resources/urinal.dat";
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                // do something with the line
                line = reader.readLine();
            }
            reader.close();
    }
}