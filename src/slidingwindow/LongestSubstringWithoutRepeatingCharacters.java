/*
 * Author: Mohan Gangadhar Gudey
 * Date: December 06, 2019
 * Description: Longest Substring Without Repeating Characters
 * LeetCode problem no: 3
 */

package slidingwindow;

import java.util.HashMap;

// Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String... args) {
        Validate validate = new Validate();
        validate.assertInt(3, calculateLength("abcabcbb"));
        validate.assertInt(1, calculateLength("bbbbb"));
        validate.assertInt(3, calculateLength("pwwkew"));
        validate.assertInt(2, calculateLength("au"));
        validate.assertInt(1, calculateLength(" "));
        validate.assertInt(0, calculateLength(""));
        validate.assertInt(1, calculateLength("aa"));
        validate.assertInt(1, calculateLength("a"));
        validate.assertInt(2, calculateLength("abba"));
    }

// Step 1: Have two pointers, begin and end
// Step 2: Loop through the characters and add the character and it's position in a map.
// Step 3: check if the character already exits in the map, if exists then move the
// begin pointer to index which is next to it.
// Step 4: Calculate the maximum length by taking the difference of begin and current.
// Step 5: every time max is calculated, compare it with previous window's max and then keep new max if the
// new max is bigger than old max


    private static int calculateLength(String s) {
        if (s.isEmpty()) return 0;
        char[] chars = s.toCharArray();

        int windowStart = 0;
        int i = 0;
        int curMax = Integer.MIN_VALUE;
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (char ch : chars) {
            i++;
            if (charMap.containsKey(ch)) {
                if (windowStart < charMap.get(ch))
                    windowStart = charMap.get(ch);
            }
            charMap.put(ch, i);
            curMax = Math.max(curMax, i - windowStart);
        }
        return curMax;
    }
}
