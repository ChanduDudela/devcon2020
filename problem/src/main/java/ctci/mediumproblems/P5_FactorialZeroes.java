package ctci.mediumproblems;

public class P5_FactorialZeroes {
    int getFactorsOf5(int n) {
        int count = 0;
        while (n % 5 == 0) {
            count++;
            n = n / 5;
        }
        return count;
    }

    // Just count the multiples of 5 from 2 to 'n'
    int getFactorialZeroes(int n) {
        int count = 0;
        for (int i = 2; i <= n ; i++) {
            count += getFactorsOf5(i);
        }

        return count;
    }
}
