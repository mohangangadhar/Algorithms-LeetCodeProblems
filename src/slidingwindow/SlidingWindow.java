package slidingwindow;

/*
 * Author: Mohan Gangadhar Gudey
 * Date: December 04, 2019
 * Description: Diet Plan Performance
 * LeetCode problem no: 1176
 */

// A dieter consumes calories[i] calories on the i-th day. For every consecutive sequence of k days,
// they look at T, the total calories consumed during that sequence of k days:
//
//        If T < lower, they performed poorly on their diet and lose 1 point;
//        If T > upper, they performed well on their diet and gain 1 point;
//        Otherwise, they performed normally and there is no change in points.
//        Return the total number of points the dieter has after all calories.length days.
//
//        Note that: The total points could be negative.
//
//        Example 1:
//
//        Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
//        Output: 0
//        Explanation: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.
//        Example 2:
//
//        Input: calories = [3,2], k = 2, lower = 0, upper = 1
//        Output: 1
//        Explanation: calories[0] + calories[1] > upper, total points = 1.
//        Example 3:
//
//        Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
//        Output: 0
//        Explanation: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
//        Constraints:
//
//        1 <= k <= calories.length <= 10^5
//        0 <= calories[i] <= 20000
//        0 <= lower <= upper

public class SlidingWindow {

    public static void main(String... args) {

        int[] calories = {1, 2, 3, 4, 5};
        int lower = 3;
        int upper = 3;
        int k = 1;

        System.out.println(calculateTotalCalories(calories, lower, upper, k));
        System.out.println(calculateTotalCalories(new int[]{3, 2}, 0, 1, 2));
        System.out.println(calculateTotalCalories(new int[]{6, 5, 0, 0}, 1, 5, 2));

    }

    // Brute Force Algorithm
    private static int calculateTotalCalories(int[] calories, int lower, int upper, int k) {
        int totVal = 0;

        for (int i = 0; i < calories.length; i++) {
            int totCal = 0;
            if (i + k <= calories.length) {
                for (int j = i; j < i + k; j++) {
                    totCal = totCal + calories[j];
                }
                if (totCal < lower) totVal = totVal - 1;
                if (totCal > upper) totVal = totVal + 1;
            }
        }
        return totVal;
    }

}
