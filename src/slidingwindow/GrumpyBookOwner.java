package slidingwindow;


//        Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
//
//        On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
//
//        The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
//
//        Return the maximum number of customers that can be satisfied throughout the day.
//
//
//
//        Example 1:
//
//        Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//        Output: 16
//        Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
//        The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//
//        Note:
//
//        1 <= X <= customers.length == grumpy.length <= 20000
//        0 <= customers[i] <= 1000
//        0 <= grumpy[i] <= 1

public class GrumpyBookOwner {
    public static void main(String... args) {
        Validate validate = new Validate();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5}, grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        validate.assertInt(16, getSatisfiedCustomersCount(customers, grumpy, X));
        validate.assertInt(18, getSatisfiedCustomersCount(new int [] {1, 0, 1, 2, 1, 1, 7, 5},new int [] {0, 0, 0, 0, 0, 0, 0, 1}, X));
        validate.assertInt(17, getSatisfiedCustomersCount(new int [] {1, 0, 1, 2, 1, 1, 7, 5},new int [] {1, 0, 0, 0, 0, 0, 0, 1}, X));
        validate.assertInt(18, getSatisfiedCustomersCount(new int [] {1, 0, 1, 2, 1, 1, 7, 5},new int [] {0, 0, 0, 0, 0, 0, 0, 0}, X));
        validate.assertInt(17, getSatisfiedCustomersCount(new int [] {1, 0, 1, 2, 1, 1, 7, 5},new int [] {1, 0, 0, 0, 0, 0, 0, 1}, 1));
        validate.assertInt(3, getSatisfiedCustomersCount(new int [] {3},new int [] {1}, 1));
    }

    private static int getSatisfiedCustomersCount(int[] customers, int[] grumpy, int x) {

        int maxValue = 0, maxHappySum = 0;
        int oneSum = 0;
        for (int j = 0; j < customers.length; j++) {
            if (grumpy[j] == 0) {
                maxHappySum = customers[j] + maxHappySum;
                customers[j] = 0;
            }
        }
        for (int j = 0; j < x; j++) {
            if(grumpy[j] == 1)
                oneSum = oneSum + customers[j];
        }
        maxValue = oneSum;

        for (int j = x; j < customers.length; j++) {
            oneSum = customers[j] + oneSum - customers[j-x];
            if(maxValue < oneSum){
                maxValue = oneSum;
            }
        }
        return maxHappySum + maxValue;
    }
}
