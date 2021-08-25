package ctci.hardproblems;

import java.util.Random;

public class ShuffleCards {
    int[] shuffleCards (int[] cards) {
        Random random = new Random();

        for (int i = 0; i < cards.length; i++) {
            int randomIndex = random.nextInt(i + 1);

            int temp = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = temp;
        }

        return cards;
    }
}
