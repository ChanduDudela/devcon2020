package ctci.searchingandsorting;

public class RotatedArray {
    int search(int arr[], int k) {
        return search(arr, k, 0, arr.length-1);
    }

    // find k in arr
    int search(int arr[], int k, int left, int right) {
        if (right < left) return -1; // doesn't exist

        int middle = left + (right - left) /2;

        if (arr[middle] == k) {
            return middle;
        }

        if (arr[left] < arr[middle]) { // left is normally ordered
            if (arr[left] <= k && k < arr[middle]) {
                return search(arr, k, left, middle - 1); // search left
            } else {
                return search(arr, k, middle + 1, right); // search right
            }
        } else if (arr[middle] < arr[right]) { // right is normally ordered
            if (arr[middle] < k && k < arr[right]) {
                return search(arr, k, middle + 1, right); // search right
            } else {
                return search(arr, k, left, middle - 1); // search left
            }
        } else {
            int flag = -1;
            if (arr[left] == arr[middle]) {
                flag = search(arr, k, middle + 1, right);
            }

            if (flag == -1 && arr[middle] == arr[right]) {
                flag = search(arr, k, left, middle - 1);
            }

            return flag;
        }
    }
}
