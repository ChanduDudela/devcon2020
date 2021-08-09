package ctci.searchingandsorting;

public class SortedSearchNoSize {
    class Listy {
        int[] arr;

        Listy() {
            arr = new int[10];
        }

        int elementAt(int i) {
            return arr[i];
        }
    }


    int search(Listy list, int element) {
        // find the size of the list by exponential back off strategy
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < element) {
            index *= 2;
        }
        return binarySearch(list, element, index / 2 , index);
    }


    int binarySearch(Listy list, int element, int left, int right) {
        if (right < left) {
            return -1;
        }

        int middle = left + (right - left) /2;

        if (list.elementAt(middle) == element) {
            return middle;
        } else if (list.elementAt(middle) > element || list.elementAt(middle) == -1) {
            binarySearch(list, element, left, middle - 1);
        } else {
            binarySearch(list, element, middle + 1, right);
        }

        return -1;
    }
}
