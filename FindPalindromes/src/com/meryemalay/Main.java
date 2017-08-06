package com.meryemalay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	    getPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop", 3);
    }

    private static void getPalindromes(String source, int limit) {
        PalindromeFactory factory = new PalindromeFactory();
        ArrayList<Palindrome> palindromes = factory.findPalindromes(source);
        Comparator<Palindrome> sortByLength =
                (Palindrome o1, Palindrome o2) -> o2.getLength() - o1.getLength();
        Collections.sort(palindromes, sortByLength);

        for (int i = 0; i < limit; i++) {
            System.out.println(palindromes.get(i).toString());
        }
    }
}
