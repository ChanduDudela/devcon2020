package ctci.arraysandstring;

public class Problem3_URLify {

    private static String getUrl(char[] strArr, int trueLength) {
        int count = getSpaceCount(strArr, trueLength);
        int newIndex = trueLength - 1 + count * 2;

        if (newIndex + 1 < strArr.length) {
            strArr[newIndex + 1] = '\0';
        }

        for (int oldIndex = trueLength-1; oldIndex >= 0; oldIndex--) {
            if(strArr[oldIndex] == ' ') {
                strArr[newIndex] = '0';
                strArr[newIndex-1] = '2';
                strArr[newIndex-2] = '%';

                newIndex = newIndex-3;
            } else {
                strArr[newIndex] = strArr[oldIndex];
                newIndex--;
            }
        }
        return new String(strArr);
    }

    private static int getSpaceCount(char[] strArr, int trueLength) {
        int count = 0;
        for (int i = 0; i < trueLength; i++) {
            if (strArr[i] == ' ') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[] arr = new char[17];
        arr[0] = 'M';
        arr[1] = 'r';
        arr[2] = ' ';
        arr[3] = 'J';
        arr[4] = 'o';
        arr[5] = 'h';
        arr[6] = 'n';
        arr[7] = ' ';
        arr[8] = 'S';
        arr[9] = 'M';
        arr[10] = 'I';
        arr[11] = 'T';
        arr[12] = 'H';


        System.out.println(Problem3_URLify.getUrl(arr, 13));
    }
}
