package ctci.mediumproblems;

public class P1_NumberSwapper {

    void swap(int a, int b) {
        // 0-----a--------b
        //       |- diff -|

        if (b > a) {
            b = b - a ; // diff
            a = a + b; // a has now value of b
            b = a - b;
        }
    }
}
