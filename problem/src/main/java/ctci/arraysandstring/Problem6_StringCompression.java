package ctci.arraysandstring;

public class Problem6_StringCompression {
    //aaabccccaaa -> a3b1c4a3
    private static String stringCompression(final String str) {
        if (str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString().length() > str.length() ? str : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Problem6_StringCompression.stringCompression("aaabccccaaa"));
    }
}
