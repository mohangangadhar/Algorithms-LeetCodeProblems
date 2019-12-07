/*
 * Author: Mohan Gangadhar Gudey
 * Date: December 06, 2019
 * Description: Minimum Window Substring
 * LeetCode problem no: 76
 */

package slidingwindow;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//        Example:
//
//        Input: S = "ADOBECODEBANC", T = "ABC"
//        Output: "BANC"
//        Note:
//
//        If there is no such window in S that covers all characters in T, return the empty string "".
//        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


public class MinimumWindowSubstring {

    public static void main(String... args){
        Validate validate = new Validate();
        validate.assertString("BANC",findMinSubStringWindow("ADOBECODEBANC"));
    }

    static String findMinSubStringWindow(String inp){
        return null;
    }
}
