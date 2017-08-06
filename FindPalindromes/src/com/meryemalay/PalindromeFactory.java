package com.meryemalay;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public class PalindromeFactory {

    public ArrayList<Palindrome> findPalindromes(String source) {
        ArrayList<Palindrome> listOfPalindrome = new ArrayList<>();
        int i = 0;
        while(i < source.length() -1){
            for (int j = source.length() - 1; j > i ; j--) {
                if(source.substring(i,i + 2).equals(reverse(source.substring(j-1, j+1)))){
                    if(isPalindrome(source.substring(i, j + 1))){
                        int length = j - i + 1;
                        String palindromeText = source.substring(i, j + 1);
                        if(!contains(listOfPalindrome, palindromeText)) {
                            listOfPalindrome.add(new Palindrome(source.substring(i, j + 1), i, length));
                            i += length / 2;
                            break;
                        }
                    }
                }
            }
            i++;
        }

        return listOfPalindrome;
    }

    public boolean isPalindrome(String str) {
        return (str.equals(reverse(str)));
    }

    public String reverse(String str) {
        StringBuilder reverseStrBuilder = new StringBuilder();
        for (int i = str.length() -1; i >= 0; i--) {
            reverseStrBuilder.append(str.charAt(i));
        }
        return reverseStrBuilder.toString();
    }

    public boolean contains(@NotNull ArrayList<Palindrome> listOfPalindrome, String palindrome) {
        for (Palindrome p: listOfPalindrome) {
            if(p.getText().equals(palindrome)){
                return true;
            }
        }
        return false;
    }
}
