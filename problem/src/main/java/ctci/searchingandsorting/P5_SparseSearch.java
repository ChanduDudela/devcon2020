package ctci.searchingandsorting;

public class P5_SparseSearch {
    int search(String[] strings, String element) {
        if (strings == null || strings.length == 0 || element.equals("")) {
            return -1;
        }

        return search(strings, element, 0, strings.length-1);
    }

    int search(String[] strings, String element, int start, int end) {
        if (end < start) {
            return -1;
        }

        int middle = start + end / 2;

        if (strings[middle].isEmpty()) { // move to closer non-empty String and set it to middle
            int left = middle - 1;
            int right = middle + 1;

            while (true) {
                if (left < start || right > end) {
                    return -1;
                }

                if (!strings[left].isEmpty()) {
                    middle = left;
                    break;
                }

                if (!strings[right].isEmpty()) {
                    middle = right;
                    break;
                }

                left --;
                right ++;
            }
        }

        if (strings[middle].equals(element)) {
            return middle;
        } else if (element.compareTo(strings[middle]) < 0) { // search left
            return search(strings, element, start, middle -1);
        } else {
            return search(strings, element, middle + 1, end);
        }
    }
}
