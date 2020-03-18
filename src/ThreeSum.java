/*
 * Author: Mohan Gangadhar Gudey
 * Date: MAR 15, 2020
 * Description: 3 SUM
 * LeetCode problem no: 15
 */

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]


import java.util.*;

public class ThreeSum {

    public static void main(String... args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 0 ) {
            return new ArrayList<>();
        }
        int targetSum = 0;
        Set<List<Integer>> result = new LinkedHashSet<>();

        for(int i=0;i <= nums.length -2; i++){
            int target = targetSum - nums[i];
            Set<List<Integer>> twoSum = twoSum(nums,i + 1, target);
            if(twoSum.size() > 0){
                result.addAll(twoSum);
            }
        }
        return new ArrayList<>(result);
    }

    public static Set<List<Integer>>twoSum(int[] numList, int start, int k){
        HashMap<Integer, Integer> res = new HashMap<>();
        Set<List<Integer>> finalResult = new LinkedHashSet<>();
        for(int i= start; i < numList.length; i++){
            List<Integer> result = new LinkedList<>();
            if(res.get(k - numList[i] ) != null) {
                result.add(numList[start - 1]);
                result.add(k - numList[i]);
                result.add(numList[i]);
                Collections.sort(result);
                finalResult.add(result);
            } else {
                res.put(numList[i], i);
            }
        }
        return finalResult;
    }
}
