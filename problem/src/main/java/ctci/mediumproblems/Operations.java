package ctci.mediumproblems;

public class Operations {

    int negate(int a) {
        int sym = a < 0 ? -1 : 1;
        int negated=0;
        while(a != 0){
            a += sym;
            negated += sym;
        }
        return negated;
    }

    int subtract(int a, int b) {
        return a + negate(b);
    }

    int multiply(int a, int b) {
        if (a < b) {
            multiply(b, a);
        }

        int sum = 0;
        for (int i = abs(b); i > 0; i = subtract(i, 1)) {
            sum += a;
        }

        if (b < 0) {
            sum = negate(sum);
        }

        return sum;
    }

    int abs(int b) {
        if (b < 0) {
            return negate(b);
        } else {
            return b;
        }
    }

    // a/b = x
    // a = b * x
    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }

        int absA = abs(a);
        int absB = abs(b);
        int count = 0;
        int sum = 0;
        while (sum + absB < absA) {
            sum += absB;
            count++;
        }

        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            return count;
        } else {
            return negate(count);
        }
    }
}
