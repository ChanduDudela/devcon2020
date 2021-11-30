package aws.onlineassesment;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int beginIndex = 0;
        int maxLength = 0;

        for (int i =0; i< s.length()-1; i++) {
            Result res = getLongestPalindrome(s, i, i);
            Result res2 = getLongestPalindrome(s, i, i+1);

            if (res.length > maxLength) {
                maxLength = res.length;
                beginIndex = res.beginIndex;
            }
            if (res2.length > maxLength) {
                maxLength = res2.length;
                beginIndex = res2.beginIndex;
            }
        }
        return s.substring(beginIndex, beginIndex + maxLength);
    }

    static Result getLongestPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return new Result(++start, end-start);
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
