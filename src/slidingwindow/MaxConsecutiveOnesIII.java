package slidingwindow;
/*
 * Author: Mohan Gangadhar Gudey
 * Date: December 07, 2019
 * Description: Max Consecutive Ones III
 * LeetCode problem no: 1004
 */

//Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
//
//        Return the length of the longest (contiguous) subarray that contains only 1s.
//
//
//
//        Example 1:
//
//        Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        Output: 6
//        Explanation:
//        [1,1,1,0,0,1,1,1,1,1,1]
//        Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
//        Example 2:
//
//        Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//        Output: 10
//        Explanation:
//        [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//        Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
//
//        Note:
//
//        1 <= A.length <= 20000
//        0 <= K <= A.length
//        A[i] is 0 or 1

public class MaxConsecutiveOnesIII {

    public static void main(String... args) {
        Validate validate = new Validate();
        validate.assertInt(6, countMaxOne(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        validate.assertInt(10, countMaxOne(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        //validate.assertInt(10,countMaxOne());
    }

    private static int countMaxOne(int[] A, int K) {
        int res = 0, i = 0;
        for (int j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
