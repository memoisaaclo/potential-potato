package com.company;
/*
 * Isaac Lo - iilo
 * 202102 CIS171 22832
 * 3/8/21
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextQuestLoTest {

    @Test
    void returnQuoteTest1() {
        // arrange
        String expected = "Understandable, have a nice day.";
        int selector = 1;
        // act
        String actual = TextQuestLo.returnQuote(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void returnQuoteTest2() {
        // arrange
        String expected = "You win some and you lose a lot.";
        int selector = 2;
        // act
        String actual = TextQuestLo.returnQuote(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void returnQuoteTest3() {
        // arrange
        String expected = "At least you tried! Next time don't lose.";
        int selector = 3;
        // act
        String actual = TextQuestLo.returnQuote(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void returnQuoteTest4() {
        // arrange
        String expected = "Everyone has lost once! Don't let it keep you down";
        int selector = 4;
        // act
        String actual = TextQuestLo.returnQuote(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void returnQuoteTest5() {
        // arrange
        String expected = "Uyuh chico, trabaja mas duro proxima tiempo.";
        int selector = 5;
        // act
        String actual = TextQuestLo.returnQuote(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void intToElementTest1() {
        // arrange
        String expected = "FIRE";
        int selector = 1;
        // act
        String actual = TextQuestLo.intToElement(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void intToElementTest2() {
        // arrange
        String expected = "WATER";
        int selector = 2;
        // act
        String actual = TextQuestLo.intToElement(selector);
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void intToElementTest3() {
        // arrange
        String expected = "AIR";
        int selector = 3;
        // act
        String actual = TextQuestLo.intToElement(selector);
        //assert
        assertEquals(expected, actual);
    }
}