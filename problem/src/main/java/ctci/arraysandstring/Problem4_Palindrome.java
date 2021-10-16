package ctci.arraysandstring;

public class Problem4_Palindrome {
    private static boolean isPalindrome(final String str) {
        // should have even number of same characters, can have 1 odd character
        int[] arr = new int[128];

        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                arr[str.charAt(i)]++;
            }
        }

        boolean check = false;
        for(int i=0; i < str.length(); i++) {
            if(arr[str.charAt(i)] % 2 == 1) {
                if (check) {
                    return false;
                }
                check = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Problem4_Palindrome.isPalindrome("tacttttcoa"));
    }
}
