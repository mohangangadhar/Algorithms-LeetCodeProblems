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

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        // int[] nums = {2, 13, -2, -5, -1, 10, 6, -8, 5, -5, 7, -5, -14, -4, -5, 10, -15, -2, -14, -6, 10, 6, -14, -14, -9, -11, 8, -3, -2, 12, -9, -14, 3, 5, -12, -13, -8, 1, -14, 12, 12, 0, 14, 5, 4, -14, -8, 4, -9, -7, 14, -13, 6, 7, -12, 5, 12, 11, -13, -5, 0, -6, -12, -12, 6, 13, 12, 13, 0, 5, 2, -11, 13, 1, 9, 2, 2, -14, 13, 8, -14, 4, 2, 8, -3, -3, -10, -14, -15, 14, -12, 1, -15, 14, -4, 6, 12, -6, -4, -3, 6, 5};
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        // int [] nums = {0,1,1};
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        // -4 -1 -1 0 1 2
        Arrays.sort(nums);
        List<List<Integer>> lists = threeSumOptimized(nums);
        lists.forEach(System.out::println);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time took to run " + timeElapsed);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        int targetSum = 0;
        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i <= nums.length - 2; i++) {
            int target = targetSum - nums[i];
            Set<List<Integer>> twoSum = twoSum(nums, i + 1, target);
            if (twoSum.size() > 0) {
                result.addAll(twoSum);
            }
        }
        return new ArrayList<>(result);
    }

    public static Set<List<Integer>> twoSum(int[] numList, int start, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        Set<List<Integer>> finalResult = new LinkedHashSet<>();
        for (int i = start; i < numList.length; i++) {
            List<Integer> result = new LinkedList<>();
            if (res.get(k - numList[i]) != null) {
                result.add(numList[start - 1]);
                result.add(k - numList[i]);
                result.add(numList[i]);
                finalResult.add(result);
            } else {
                res.put(numList[i], i);
            }
        }
        return finalResult;
    }


    private static List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int j = 0, k = 0;

        for (int i = 0; i <= nums.length - 3; i++) {
            j = i + 1;
            k = nums.length - 1;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

}
