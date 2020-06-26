package aws.random.questions;

public class IntegerToEnglish {
    private static final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] TYS = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty",
        "Seventy", "Eighty", "Ninety"};

    private static final String[] UNITS = {"Billion", "Million","Thousand", "Hundred"};
    private static final int[] RADIX = {1000000000, 1000000, 1000, 100};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        StringBuilder sb =new StringBuilder();

        int count;
        for(int i =0; i < RADIX.length; i++) {
            count = num / RADIX[i];

            if(count == 0){
                continue;
            }

            sb.append(numberToWords(count)).append(" ");
            sb.append(UNITS[i]).append(" ");

            num %= RADIX[i];
        }
        if(num < 20) {
            sb.append( LESS_THAN_TWENTY[num]);
        } else{
            sb.append( TYS[num/10 -2] ).append(" ");
            sb.append( LESS_THAN_TWENTY[num % 10]);
        }

        return sb.toString().trim();
    }
}
