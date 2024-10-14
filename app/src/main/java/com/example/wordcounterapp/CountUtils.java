package com.example.wordcounterapp;

/**
 * CountUtils class provides methods to count words and characters.
 */
public class CountUtils {

    /**
     * Counts the number of words in the input text.
     * Words are separated by spaces, commas, or dots.
     *
     * @param text The input text.
     * @return The word count.
     */
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Replace commas and dots with spaces, then split by spaces
        String[] words = text.trim().replaceAll("[.,]", " ").split("\\s+");
        return words.length;
    }

    /**
     * Counts the number of characters in the input text.
     *
     * @param text The input text.
     * @return The character count.
     */
    public static int countCharacters(String text) {
        if (text == null) {
            return 0;
        }
        // Exclude spaces, commas, and dots from the character count
        return text.replaceAll("[\\s.,]", "").length();
    }
}