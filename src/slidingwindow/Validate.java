package slidingwindow;

public class Validate {

    public void assertInt(int expected, int actual) {
        if (expected == actual)
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }

    public void assertString(String expected, String actual) {
        if (expected.equals(actual))
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }

}