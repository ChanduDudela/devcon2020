package leetcode;

public class ReverseWordsInAString {
    //In place
    public void reverseWordsInPlace(char[] s) {
        reverse(s, 0, s.length - 1); //reverse all chars in the array

        int r = 0;

        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1); //then reverse each word
            r++;
        }
    }

    //helper to reverse array from index l to r
    private void reverse(char[] s, int l, int r) {
        char temp;
        while (l < r) {
            temp = s[r];
            s[r] = s[l];
            s[l] = temp;

            l++;
            r--;
        }
    }
}
