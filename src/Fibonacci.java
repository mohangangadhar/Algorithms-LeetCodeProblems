public class Fibonacci {
    public static void main(String... args) {
//        long start = System.currentTimeMillis();
//        System.out.println("fibonacci "+fib(120));
//        long finish = System.currentTimeMillis();
//        long timeElapsed = finish - start;
//        System.out.println("Time took to run "+ timeElapsed);
        long start1 = System.currentTimeMillis();
        System.out.println("fibonacci " + fibDy(12000));
        long finish1 = System.currentTimeMillis();
        long timeElapsed1 = finish1 - start1;
        System.out.println("Time took to run "+ timeElapsed1);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibDy(int n) {
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
