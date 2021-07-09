package ctci.arraysandstring;

public class Problem9_StringRotation {

    public static boolean areStringsRotated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s3 = s2.concat(s2);

        return s3.contains(s1);
    }

    public static void main(String[] args) {
        System.out.println(Problem9_StringRotation.areStringsRotated("cooler", "ercool"));
    }
}
