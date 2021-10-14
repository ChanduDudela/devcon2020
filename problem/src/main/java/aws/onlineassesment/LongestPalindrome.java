package aws.onlineassesment;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {

    /* int resultStart;
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
    }*/

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int resultIndex =0;
        int maxLength =0;

        for (int i =0; i< s.length()-1; i++) {
            Result res = getLongestPalindrome(s, i, i);
            Result res2 = getLongestPalindrome(s, i, i+1);

            if (res.length > maxLength) {
                maxLength = res.length;
                resultIndex = res.beginIndex;
            }
            if (res2.length > maxLength) {
                maxLength = res2.length;
                resultIndex = res2.beginIndex;
            }
        }
        return s.substring(resultIndex, resultIndex + maxLength+1);
    }

    static Result getLongestPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return new Result(++start, end-start-1);
    }

    static class Result {
        int beginIndex;
        int length;

        Result (int beginIndex, int length) {
            this.beginIndex = beginIndex;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindrome.longestPalindrome("cbbddbbc"));
    }
}
