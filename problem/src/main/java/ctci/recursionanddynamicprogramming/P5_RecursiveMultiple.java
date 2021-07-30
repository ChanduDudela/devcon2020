package ctci.recursionanddynamicprogramming;

public class P5_RecursiveMultiple {
    int multiply (int a, int b) {
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);

        //int[] memo = new int[smaller+1];
        return multiplyRecursive(smaller, bigger);
    }

    int multiplyRecursive (int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else if (a == 1) {
            return b;
        }

        int c = a / 2;
        int side1 = multiplyRecursive(c, b);
        int side2 = side1;

        boolean aIsOdd = a % 2 == 1;
        if (aIsOdd) {
            side2 = multiplyRecursive(a - c, b);
        }

        return side1 + side2;
    }

    // Using memoization
    int multiplyRecursiveMemoization(int smaller, int bigger, int[] memo) {
        if (smaller == 0 || bigger == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        }

        int c = smaller / 2;
        int side1 = multiplyRecursive(c, bigger);
        int side2 = side1;

        boolean aIsOdd = smaller % 2 == 1;
        if (aIsOdd) {
            side2 = multiplyRecursive(smaller - c, bigger);
        }

        memo[smaller] = side1 + side2;
        return memo[smaller];
    }

    public static void main(String[] args) {
        System.out.println(new P5_RecursiveMultiple().multiply(11, 8));
    }
}
