package ctci.recursionanddynamicprogramming;

public class P11_Coins {
    //  A 2x2 matrix

    //     25c, 10c, 5c, 1c
    //  1 [   ,    ,   ,   ]
    //  2 [                ]
    //  3 [                ]
    //  4 [                ]
    int makeChange(int amountTotal, int[] denoms) {
        //cache
        int[][] cache = new int[amountTotal + 1][denoms.length];
        return makeChange(amountTotal, denoms, 0, cache);
    }

    int makeChange(int total, int[] denoms, int index, int[][] cache) {
        if (cache[total][index] > 0) {
            return cache[total][index];
        }

        int coin = denoms[index];
        // last denomination (1 cent)
        if (index == denoms.length - 1) {
            int rem = total % coin;
            return rem == 0 ? 1 : 0;
        }

        int numberOfWays = 0;
        for (int amount = 0; amount <= total; amount+= coin) {
            numberOfWays += makeChange(total-amount, denoms, index + 1, cache);
        }

        cache[total][index] = numberOfWays;

        return numberOfWays;
    }
}
