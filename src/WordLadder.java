/*
 * Author: Mohan Gangadhar Gudey
 * Date: Jan 18, 2020
 * LeetCode problem no: 127
 */

//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time.
//        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//        Note:
//
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Example 1:
//
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        Output: 5
//
//        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//        Example 2:
//
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        Output: 0
//
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

import slidingwindow.Validate;

import java.util.*;

public class WordLadder {
    public static void main(String... args) {
        Validate validate = new Validate();
        validate.assertInt(5, new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        validate.assertInt(0, new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    class WordNode {
        String word;
        Integer noOfSteps;

        public WordNode(String word, Integer noOfSteps) {
            this.word = word;
            this.noOfSteps = noOfSteps;
        }

        @Override
        public String toString() {
            return new StringBuilder(this.word + ' ' + this.noOfSteps).toString();
        }
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList == null || wordList.isEmpty())
            return 0;
// this is done using BFS algorithm
        Queue<WordNode> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        WordNode wordNode = new WordNode(beginWord, 1);
        queue.add(wordNode);

        while (!queue.isEmpty()) {
            // get the top node
            WordNode topNode = queue.poll();
            String curString = topNode.word;
            // if it is the end string then return the no of steps
            if (curString.equals(endWord))
                return topNode.noOfSteps;
            // change each letter in the string and check if the newly created word is in the list or not
            // if present, remove the word from the list and then repeat the above process
            // removal is needed to not to have infinte loops
            for (int i = 0; i < curString.length(); i++) {
                char[] curStringArray = curString.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    char newChar = curStringArray[i];
                    if (newChar != c) {
                        newChar = c;
                    }
                    curStringArray[i] = newChar;
                    String newString = new String(curStringArray);
                    if (wordSet.remove(newString)) {
                        WordNode newStringWord = new WordNode(newString, topNode.noOfSteps + 1);
                        queue.add(newStringWord);
                        System.out.println(newStringWord);
                    }
                }
            }
        }
        return 0;
    }
}
