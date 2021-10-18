package leetcode;

public class IntegerToEnglish {
    String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TYS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] HUNDREDS = {"Billion", "Million", "Thousand", "Hundred"};
    int[] RADIX = {1000000000, 1000000, 1000, 100};

    String getPhrase(int num) {
        if (num == 0) {
            return LESS_THAN_TWENTY[0];
        } else if (num < 0) {
            return "Negative " + getPhraseOfInt(-1 * num, new StringBuilder());
        } else {
            return getPhraseOfInt(num, new StringBuilder());
        }
    }

    String getPhraseOfInt(int num, StringBuilder sb) {
        for (int i = 0; i < RADIX.length; i++) {
            int dividend = num / RADIX[i];
            if (dividend == 0) {
                continue;
            }

            sb.append(getPhraseOfInt(dividend, sb)).append(" ");
            sb.append(HUNDREDS[i]);

            num = num % RADIX[i];
        }

        if (num < 20) {
            sb.append(LESS_THAN_TWENTY[num]);
        } else {
            sb.append(TYS[num/10]).append(" ").append(LESS_THAN_TWENTY[num % 10]);
        }
        return sb.toString();
    }
}
