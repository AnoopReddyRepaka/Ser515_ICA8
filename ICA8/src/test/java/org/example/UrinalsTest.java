package org.example;

import org.junit.jupiter.api.Test;

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
        assertEquals(1,urinals.validSpots("00101"));
    }
    @Test
    void ValidSpotsThird()
    {
        Urinals urinals= new Urinals();
        assertEquals(1,urinals.validSpots("101000"));
    }
}