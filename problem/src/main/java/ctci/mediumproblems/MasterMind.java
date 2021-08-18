package ctci.mediumproblems;

public class MasterMind {
    static class Result {
        int hits;
        int pseudoHits;
    }

    int getColorCode(char c) {
        switch (c) {
            case 'Y': return 0;
            case 'B': return 1;
            case 'G': return 2;
            case 'R': return 3;
            default: return -1;
        }
    }

    int MAX_COLORS = 4;

    Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) {
            return null;
        }

        Result rs = new Result();
        int[] frequency = new int[MAX_COLORS];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                rs.hits ++;
            } else {
                int code = getColorCode(solution.charAt(i));
                frequency[code]++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int code = getColorCode(guess.charAt(i));
            if (guess.charAt(i) != solution.charAt(i)
                && code >= 0 && frequency[code] > 0) {
                rs.pseudoHits++;
                frequency[code]--;
            }
        }

        return rs;
    }
}
