package com.example.login_keeper1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private final int mLength;
    private final boolean mIncludeUpperCaseLetters;
    private final boolean mIncludeLowerCaseLetters;
    private final boolean mIncludeSymbols;
    private final boolean mIncludeNumbers;
    private final boolean mIncludeCustomCharSet;
    private final char[] mCustomCharSet;

    public PasswordGenerator(
            int length,
            boolean includeUpperCaseLetters,
            boolean includeLowerCaseLetters,
            boolean includeSymbols,
            boolean includeNumbers
    ) {
        mLength = length;
        mIncludeUpperCaseLetters = includeUpperCaseLetters;
        mIncludeLowerCaseLetters = includeLowerCaseLetters;
        mIncludeSymbols = includeSymbols;
        mIncludeNumbers = includeNumbers;
        mIncludeCustomCharSet = false;
        mCustomCharSet = new char[0];
    }

    public PasswordGenerator(int length, String customCharSet) {
        mLength = length;
        mIncludeUpperCaseLetters = false;
        mIncludeLowerCaseLetters = false;
        mIncludeSymbols = false;
        mIncludeNumbers = false;
        mIncludeCustomCharSet = true;
        mCustomCharSet = customCharSet.toCharArray();
    }

    public String generate() {
        if (mIncludeCustomCharSet) {
            return generateCustom();
        }

        return generateWithRules();
    }

    private String generateWithRules() {
        StringBuilder password = new StringBuilder();
        List<char[]> charset = new ArrayList<>();

        if(mIncludeUpperCaseLetters)
            charset.add("QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray());
        if(mIncludeLowerCaseLetters)
            charset.add("qwertyuiopasdfghjklzxcvbnm".toCharArray());
        if(mIncludeNumbers)
            charset.add("0123456789".toCharArray());
        if(mIncludeSymbols)
            charset.add("!@#$%&*+=-~?/".toCharArray());

        Random r = new Random();

        for (int i = 0; i < mLength; i++) {
            int choice = r.nextInt(charset.size());
            char[] characters = charset.get(choice);
            char ch = characters[r.nextInt(characters.length)];
            password.append(ch);
        }

        return password.toString();
    }

    private String generateCustom() {
        StringBuilder password = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < mLength; i++) {
            password.append(mCustomCharSet[r.nextInt(mCustomCharSet.length)]);
        }
        return password.toString();
    }
}
