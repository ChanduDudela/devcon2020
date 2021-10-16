package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> wordListSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // COUNT NUMBER OF WORDS TRANSFORMED
        int count = 1;
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();

            // FOR ALL WORDS THIS ROUND
            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                char[] charArr = str.toCharArray();

                // TRAVERSE CURRENT WORD
                for (int j = 0; j < charArr.length; j++) {
                    char temp = charArr[j];

                    // CHANGE ONE LETTER AT A TIME
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArr[j] = c;

                        String newStr = String.valueOf(charArr);

                        // WHEN NEXT WORD IS IN THE SET
                        if (wordListSet.contains(newStr)) {

                            if (newStr.equals(endWord)) {
                                return count + 1;
                            }

                            wordListSet.remove(newStr);
                            queue.offer(newStr);
                        }
                    }

                    // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
                    charArr[j] = temp;
                }
            }

            // THIS ROUND ENDS WITH ONE LETTER CHANGED
            count++;
        }

        return 0;
    }
}
