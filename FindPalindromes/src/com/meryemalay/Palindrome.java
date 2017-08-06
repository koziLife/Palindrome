package com.meryemalay;

public class Palindrome {
    private String text;
    private int index;
    private int length;

    public Palindrome(String text, int index, int length) {
        this.text = text;
        this.index = index;
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Text: \"" + this.getText() + "\", Index: " + this.getIndex() + ", Length: " + this.getLength();
    }

}