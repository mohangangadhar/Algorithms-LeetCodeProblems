/*
 * Author: Mohan Gangadhar Gudey
 * Date: Jan 18, 2020
 * Description: Valid Anagram
 * LeetCode problem no: 242
 */

import slidingwindow.Validate;

import java.util.Arrays;

public class Anagram {

    public static void main(String... args) {
        Validate validate = new Validate();
        validate.assertBoolean(true, isAnagram2("hello", "ollhe"));
        validate.assertBoolean(false, isAnagram2("hello", "ollhh"));
        validate.assertBoolean(false, isAnagram2("hello", "man"));
        validate.assertBoolean(true, isAnagram2("olga", "galo"));
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }

    static boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int MAX_SIZE = 256;
        int[] words = new int[MAX_SIZE];
        int[] words2 = new int[MAX_SIZE];

        for (char ch : s1.toCharArray()) {
            words[ch] = words[ch] + 1;
        }

        for (char ch : s2.toCharArray()) {
            words2[ch] = words2[ch] + 1;
        }

        for (int i = 0; i < MAX_SIZE; i++) {
            if (words[i] != words2[i])
                return false;
        }
        return true;
    }
}