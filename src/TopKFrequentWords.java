/*
 * Author: Mohan Gangadhar Gudey
 * Date: Jan 17, 2020
 * Description: Top K Frequent words
 * LeetCode problem no: 692
 */

//Given a non-empty list of words, return the k most frequent elements.
//
//        Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//        Example 1:
//        Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//        Output: ["i", "love"]
//        Explanation: "i" and "love" are the two most frequent words.
//        Note that "i" comes before "love" due to a lower alphabetical order.
//        Example 2:
//        Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//        Output: ["the", "is", "sunny", "day"]
//        Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//        with the number of occurrence being 4, 3, 2 and 1 respectively.
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Input words contain only lowercase letters.
//        Follow up:
//        Try to solve it in O(n log k) time and O(n) extra space.


import slidingwindow.Validate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String... args) {
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        Validate validate = new Validate();
        topKFreq(input, k);
    }

    static List<String> topKFreq(String[] words, int k) {
        Map<String, Integer> wordMapCount = new HashMap<>();

        for (String word : words) {
            if (wordMapCount.containsKey(word)) {
                wordMapCount.put(word, wordMapCount.get(word) + 1);
            } else {
                wordMapCount.put(word, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey())
                : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> wo : wordMapCount.entrySet()) {
            pq.offer(wo);
            if (pq.size() > k) {
                pq.poll();
            }

        }
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0,pq.poll().getKey());
        }

        return result;
    }
}
