package com.meryemalay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;

public class PalindromeFactoryTest {

    private PalindromeFactory palindromeFactory;

    @org.junit.Before
    public void setup(){
        palindromeFactory = new PalindromeFactory();
    }


    @org.junit.Test
    public void whenPalindromeIsGiven_ShouldReturnTrue(){
        assertTrue(palindromeFactory.isPalindrome("ahha"));
    }

    @org.junit.Test
    public void whenNotPalindromeIsGiven_ShouldReturnFalse(){
        assertFalse(palindromeFactory.isPalindrome("jhfhhf"));
    }

    @org.junit.Test
    public void whenTextIsGivenToReverse_ShouldReturnReverse(){
        assertEquals("Reverse method has failed", "dcba", palindromeFactory.reverse("abcd"));
    }

    @org.junit.Test
    public void whenGivenTextThatHasNoPalindrome_ShouldReturnEmptyList(){
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("abcdlpdcl");
        assertEquals("Find PalindromeFactory method should return empty list", 0, result.size());
    }

    @org.junit.Test
    public void whenGivenTextHasPalindrome_ShouldReturnPalindrome(){
        assertEquals("asddsa", palindromeFactory.findPalindromes("abhasddsafgt").get(0).getText());
        assertEquals(3, palindromeFactory.findPalindromes("abhasddsafgt").get(0).getIndex());
        assertEquals(6, palindromeFactory.findPalindromes("abhasddsafgt").get(0).getLength());
    }

    @org.junit.Test
    public void whenGivenTextHasPalindrome_ShouldNotReturnInnerPalindrome(){
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("abhasddsafgt");
        if (result.size() > 1) {
            assertFalse("sdds should not be added to the list!", "sdds".equals(result.get(1).getText()));
        } else {
            assertTrue(result.size() == 1);
        }
    }

    @org.junit.Test
    public void whenGivenTextHasPalindromes_ShouldReturnPalindromes(){
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("asdabcbaopopol");
        String[] palindromeArray = new String[result.size()];
        for (int i = 0; i < result.size() ; i++) {
            palindromeArray[i] = result.get(i).getText();
        }

        String[] expectedArray = new String[]{"abcba","opopo"};

        assertArrayEquals(expectedArray, palindromeArray);
    }

    @org.junit.Test
    public void whenGivenTextHasMoreThan3Palindromes_ShouldReturnTheLongest3() {
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");
        Comparator<Palindrome> sortByLength =
                (Palindrome o1, Palindrome o2) -> o2.getLength() - o1.getLength();
        Collections.sort(result, sortByLength);
        String[] palindromeArray = new String[3];
        for (int i = 0; i < 3 ; i++) {
            palindromeArray[i] = result.get(i).getText();
        }

        String[] expectedArray = new String[]{"hijkllkjih","defggfed", "abccba"};
        assertArrayEquals(expectedArray, palindromeArray);
    }



}
