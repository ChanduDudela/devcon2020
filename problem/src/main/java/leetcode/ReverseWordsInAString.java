package leetcode;

public class ReverseWordsInAString {

    //preferred approach - In place
    public void reverseWordsInplace(char[] s) {
        reverse(s, 0, s.length-1); //reverse all chars in the array

        int r = 0;

        while(r < s.length){
            int l = r;
            while(r < s.length && s[r] != ' '){
                r++;
            }
            reverse(s, l, r-1); //then reverse each word
            r++;
        }
    }

    //helper to reverse array from index l to r
    private void reverse(char[] s, int l, int r){
        char temp;
        while(l < r){
            temp = s[r];
            s[r] = s[l];
            s[l] = temp;

            l++;
            r--;
        }
    }

    //my way.
    public void reverseWords(char[] s) {

        char[] str = new char[s.length];
        int endIndex = s.length-1;
        int targetStartIndex = 0;

        for(int i = s.length-1; i >= 0; i--) {
            if(s[i] == ' ')
            {
                for(int j = i+1; j <= endIndex; j++){
                    str[targetStartIndex++] = s[j];
                }
                endIndex = i-1;
                str[targetStartIndex++] = ' ';
            } else if(i == 0){
                for(int j = 0; j <= endIndex; j++){
                    str[targetStartIndex++] = s[j];
                }
            }
        }

        for(int i = 0; i < s.length; i++){
            s[i] = str[i];
        }
    }
}
