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
    public void whenPalindromeIsGiven_ShouldReturnTrue() throws Exception{
        assertTrue(palindromeFactory.isPalindrome("ahha"));
    }

    @org.junit.Test
    public void whenNotPalindromeIsGiven_ShouldReturnFalse() throws Exception{
        assertFalse(palindromeFactory.isPalindrome("jhfhhf"));
    }

    @org.junit.Test
    public void whenTextIsGivenToReverse_ShouldReturnReverse() throws Exception{
        assertEquals("Reverse method has failed", "dcba", palindromeFactory.reverse("abcd"));
    }

    @org.junit.Test
    public void whenGivenTextThatHasNoPalindrome_ShouldReturnEmptyList() throws Exception{
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("abcdlpdcl");
        assertEquals("Find PalindromeFactory method should return empty list", 0, result.size());
    }

    @org.junit.Test
    public void whenGivenTextHasPalindrome_ShouldReturnPalindrome() throws Exception{
        assertEquals("asddsa", palindromeFactory.findPalindromes("abhasddsafgt").get(0).getText());
        assertEquals(3, palindromeFactory.findPalindromes("abhasddsafgt").get(0).getIndex());
        assertEquals(6, palindromeFactory.findPalindromes("abhasddsafgt").get(0).getLength());
    }

    @org.junit.Test
    public void whenGivenTextHasPalindrome_ShouldNotReturnInnerPalindrome() throws Exception{
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("abhasddsafgt");
        if (result.size() > 1) {
            assertFalse("sdds should not be added to the list!", "sdds".equals(result.get(1).getText()));
        } else {
            assertTrue(result.size() == 1);
        }
    }

    @org.junit.Test
    public void whenGivenTextHasPalindromes_ShouldReturnPalindromes() throws Exception{
        ArrayList<Palindrome> result = palindromeFactory.findPalindromes("asdabcbaopopol");
        String[] palindromeArray = new String[result.size()];
        for (int i = 0; i < result.size() ; i++) {
            palindromeArray[i] = result.get(i).getText();
        }

        String[] expectedArray = new String[]{"abcba","opopo"};

        assertArrayEquals(expectedArray, palindromeArray);
    }

    @org.junit.Test
    public void whenGivenTextHasMoreThan3Palindromes_ShouldReturnTheLongest3() throws Exception{
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

    @org.junit.Test
    public void whenPalindromeListContainsGivenText_ShouldReturnTrue() throws Exception {
        ArrayList<Palindrome> listOfPalindrome = new ArrayList<>();
        listOfPalindrome.add(new Palindrome("abcba", 2,5));
        assertTrue("Palindrome list contains given text: ", palindromeFactory.contains(listOfPalindrome, "abcba"));
    }


}
