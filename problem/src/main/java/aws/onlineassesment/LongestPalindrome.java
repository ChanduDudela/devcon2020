package aws.onlineassesment;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {

    int resultStart;
    int resultLength;

    public String longestPalindrome(String s) {
        int len = s.length();

        if(len < 2) {
            return s;
        }

        for(int start=0; start < len -1; start++)
        {
            checkPalindrome(s, start, start);
            checkPalindrome(s, start, start+1);
        }

        return s.substring(resultStart, resultStart + resultLength);
    }

    private void checkPalindrome(String str, int begin, int end) {
        while(begin >=0 && end < str.length() && str.charAt(begin) == str.charAt(end)){
            begin--;
            end++;
        }

        if(resultLength < end - begin -1) {
            resultLength = end - begin -1;
            resultStart = ++begin;
        }
    }
    //

    //Brute force
    public String longestPalindrome_BruteForce(String s) {

        if (s.length() == 1) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            int j = s.length();

            while (j > i) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    if (result.length() < j - i + 1) {
                        result = sub;
                        break;
                    }
                }
                j--;
            }
        }

        return result;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }



    ///getting String out of bounds exception
    public String longestPalindrome_Test(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int maxlength = 0;
        String palindrome = "";

        for(int i =0; i < s.length(); i++){
            String x = findPalindrome(s, i, i);
            String y = findPalindrome(s, i, i+1);

            if(x.length() > y.length() && x.length() > maxlength){
                palindrome = x;
                maxlength = x.length();
            } else if(y.length() > maxlength){
                palindrome = y;
                maxlength = y.length();
            }
        }

        return palindrome;
    }


    private String findPalindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length() -1 && s.charAt(start) == s.charAt(end)){
            start --;
            end ++;
        }

        int begin = ++start;
        // int e = --end;

        return s.substring(begin, end);
    }
}
