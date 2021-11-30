package aws.onlineassesment;

import java.util.Arrays;

public class LogFiltering_LC937 {
    public static void main(String[] args) {
        String[] inputLogs =
            {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(LogFiltering_LC937.reorderLogFiles_Comparator(inputLogs)));
    }

    // Using Array Sort Comparator
    public static String[] reorderLogFiles_Comparator(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] firstLog = a.split(" ", 2);
            String[] secondLog = b.split(" ", 2);

            boolean firstLogIsLetter = Character.isLetter(firstLog[1].charAt(0));
            boolean secondLogIsLetter = Character.isLetter(secondLog[1].charAt(0));

            if (firstLogIsLetter && secondLogIsLetter) {
                //both are letter logs
                int comparedValue = firstLog[1].compareToIgnoreCase(secondLog[1]);
                //if both log values are same, compare ids
                if (comparedValue == 0) {
                    return firstLog[0].compareToIgnoreCase(secondLog[0]);
                }
                return comparedValue;
            } else if (firstLogIsLetter) {
                //first log is letter and second is digit, keep them in the order
                return -1;
            } else if (secondLogIsLetter) {
                //first log is digit and second is letter, swap the order
                return 1;
            } else {
                // both are digit logs, return original order
                return 0;
            }
        });

        return logs;
    }
}
