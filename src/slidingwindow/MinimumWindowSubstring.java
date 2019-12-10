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


import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String... args) {
        Validate validate = new Validate();
        //validate.assertString("BANC",findMinSubStringWindow("ABC", "ADOBECODEBANC"));
        validate.assertString("A",findMinSubStringWindow("A", "ADOBECODEBANC"));
        //printArrayMovements("ADOBECODEBANC".toCharArray(), 1, 5);
    }

    static String findMinSubStringWindow(String inpString, String testString) {
        if(testString.isEmpty() || inpString.isEmpty()) return "";

        HashMap<Character, Integer> inpMap = new HashMap<>();
        int slowPointer = 0;
        int currMin = Integer.MAX_VALUE;
        int i = 0;
        int missingLetters = inpString.length();
        for (int j = 0; j < inpString.length(); j++) {
            inpMap.put(inpString.charAt(j), 0);
        }

        for ( i = 0; i < testString.length(); i++) {
            if(inpMap.get(testString.charAt(i)) != null){
                inpMap.put(testString.charAt(i), inpMap.get(testString.charAt(i)) + 1 );
                missingLetters --;
            }

            while(missingLetters == 0){
                System.out.println(testString.substring(slowPointer, i + 1));
                if(inpMap.get(testString.charAt(slowPointer)) != null){
                    inpMap.put(testString.charAt(slowPointer), inpMap.get(testString.charAt(slowPointer)) - 1 );
                    missingLetters ++;
                }
                slowPointer++;
                currMin = Math.min(currMin,  i - slowPointer + 1);
            }

        }

        return testString.substring(slowPointer -1, i);
    }

    static void printArrayMovements(char[] arr, int left, int right) {
        int length = arr.length;
        char[] leftArray = new char[length];
        char[] rightArray = new char[length];

        for (int i = 0; i <= length - 1; i++) {
            if (left == i) {
                leftArray[i] = 'L';
            } else {
                leftArray[i] = ' ';
            }
            if (right == i) {
                rightArray[i] = 'R';
            } else {
                rightArray[i] = ' ';
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(leftArray[i] + "-");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + "-");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(rightArray[i] + "-");
        }

    }
}
