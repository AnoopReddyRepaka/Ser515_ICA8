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
}