public class Calculator {
    public static int add(int a, int b) {
        assert (a >= 0 && b >= 0) : "Pre-condition failed";
        return a + b;
    }
}
