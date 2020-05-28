import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LogFiltering_LC937 {
    public static void main(String[] args) {
        String[] inputLogs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(LogFiltering_LC937.reorderLogFiles(inputLogs)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        //to add letter based logs by natural ordering
        TreeMap<String, PriorityQueue<String>> letterLogsMap = new TreeMap<>();

        //to add digit based logs as is
        List<String> digitLogsList = new ArrayList<>();

        for (String log : logs) {
            String[] logIdValueArray = log.split(" ", 2);
            if (Character.isLetter(logIdValueArray[1].charAt(0))) {
                //Get existing pq (if there is), for this same log value
                PriorityQueue<String> pq = letterLogsMap.getOrDefault(logIdValueArray[1], new PriorityQueue<>());
                //Add this log id to pq
                pq.add(logIdValueArray[0]);

                letterLogsMap.put(logIdValueArray[1], pq);
            } else {
                digitLogsList.add(log);
            }
        }

        String[] resultArray = new String[logs.length];
        int ind = 0;

        while(!letterLogsMap.isEmpty()){
            Map.Entry<String, PriorityQueue<String>> entry = letterLogsMap.firstEntry();

            while(!entry.getValue().isEmpty()){
                resultArray[ind++] = entry.getValue().poll() + " " + entry.getKey();
            }
            letterLogsMap.remove(entry.getKey());
        }
        for(String s: digitLogsList) {
            resultArray[ind++] = s;
        }

        return resultArray;
    }
}
