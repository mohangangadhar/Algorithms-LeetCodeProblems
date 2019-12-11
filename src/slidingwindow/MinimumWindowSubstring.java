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
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String... args) {
        Validate validate = new Validate();
        //validate.assertString("BANC",findMinSubStringWindow("ABC", "ADOBECODEBANC"));
        //validate.assertString("ABCA", findMinSubStringWindow("AA", "ABCADEFGHA"));
//        validate.assertString("ABCA", minWindow("ABCADEFGHA", "AA"));
//        validate.assertString("BANC", minWindow("ADOBECODEBANC", "ABC"));
//        validate.assertString("AA", minWindow("AA", "AA"));
                validate.assertString("ABCA", minWindow2("ABCADEFGHA", "AA"));
        validate.assertString("BANC", minWindow2("ADOBECODEBANC", "ABC"));
        validate.assertString("AA", minWindow2("AA", "AA"));

        //printArrayMovements("ADOBECODEBANC".toCharArray(), 1, 5);
    }

    private static String findMinSubStringWindow(String inpString, String testString) {
        if (testString.isEmpty() || inpString.isEmpty()) return "";

        HashMap<Character, Integer> inpMap = new HashMap<>();
        int slowPointer = 0;
        int currMin = Integer.MAX_VALUE;
        int i;
        String s = null;
        int missingLetters = inpString.length();
        for (int j = 0; j < inpString.length(); j++) {
            if (inpMap.get(inpString.charAt(j)) != null)
                inpMap.put(inpString.charAt(j), inpMap.get(inpString.charAt(j)) + 1);
            else
                inpMap.put(inpString.charAt(j), 1);
        }

        for (i = 0; i < testString.length(); i++) {
            if (inpMap.get(testString.charAt(i)) != null) {
                inpMap.put(testString.charAt(i), inpMap.get(testString.charAt(i)) - 1);
                if (inpMap.get(testString.charAt(i)) == 0) missingLetters--;
            }

            while (missingLetters == 0) {
                if (currMin > i - slowPointer + 1) {
                    s = testString.substring(slowPointer, i + 1);
                    currMin = i - slowPointer + 1;
                }

                if (inpMap.get(testString.charAt(slowPointer)) != null) {
                    inpMap.put(testString.charAt(slowPointer), inpMap.get(testString.charAt(slowPointer)) + 1);
                    missingLetters++;
                } else {
                    slowPointer++;
                }
            }

        }

        return s;
    }

    public static String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), 0);

            if (dict.containsKey(T.charAt(i))) {
                dict.put(T.charAt(i), dict.get(T.charAt(i)) + 1);
            } else {
                dict.put(T.charAt(i), 1);
            }
        }

        int start = 0;
        int count = 0;
        int minLen = S.length() + 1;
        String result = "";

        for (int end = 0; end < S.length(); end++) {
            if (map.containsKey(S.charAt(end))) {
                map.put(S.charAt(end), map.get(S.charAt(end)) + 1);

                if (map.get(S.charAt(end)) <= dict.get(S.charAt(end))) {
                    count++;
                }
            }

            if (count == T.length()) {
                while (!dict.containsKey(S.charAt(start)) || map.get(S.charAt(start)) > dict.get(S.charAt(start))) {
                    if (map.containsKey(S.charAt(start))) {
                        map.put(S.charAt(start), map.get(S.charAt(start)) - 1);
                    }
                    start++;
                }

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result = S.substring(start, end + 1);
                }
            }
        }

        System.out.println(result);
        return result;
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

    public  static String minWindow2(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }

}
