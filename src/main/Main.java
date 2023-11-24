package main;

public class Main {
    public static void main(String[] args) {

        // DELETE THIS BEFORE SUBMISSION
        System.out.println(factorial1(5));

    }

    // DELETE THIS BEFORE SUBMISSION
    static int factorial1 (int x) {
        if (x == 1) {
            return 1;
        }
        return x * factorial1(x - 1);
    }
}

