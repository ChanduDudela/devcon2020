package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LogFiltering_LC937 {
    public static void main(String[] args) {
        String[] inputLogs =
            {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(LogFiltering_LC937.reorderLogFiles(inputLogs)));
    }

    //Approach-1 using TreeMap and PQ
    public static String[] reorderLogFiles(String[] logs) {
        //to add letter based logs by natural ordering
        TreeMap<String, PriorityQueue<String>> letterLogsMap = new TreeMap<>();

        //to add digit based logs as is
        List<String> digitLogsList = new ArrayList<>();

        for (String log : logs) {
            String[] logIdValueArray = log.split(" ", 2);
            if (Character.isLetter(logIdValueArray[1].charAt(0))) {
                //Get existing pq (if there is), for this same log value
                PriorityQueue<String> pq =
                    letterLogsMap.getOrDefault(logIdValueArray[1], new PriorityQueue<>());
                //Add this log id to pq
                pq.add(logIdValueArray[0]);

                letterLogsMap.put(logIdValueArray[1], pq);
            } else {
                digitLogsList.add(log);
            }
        }

        String[] resultArray = new String[logs.length];
        int ind = 0;

        while (!letterLogsMap.isEmpty()) {
            Map.Entry<String, PriorityQueue<String>> entry = letterLogsMap.firstEntry();

            while (!entry.getValue().isEmpty()) {
                resultArray[ind++] = entry.getValue().poll() + " " + entry.getKey();
            }
            letterLogsMap.remove(entry.getKey());
        }
        for (String s : digitLogsList) {
            resultArray[ind++] = s;
        }

        return resultArray;
    }


    //Approach-2 using Array Sort Comparator
    public String[] reorderLogFiles_Comparator(String[] logs) {
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
