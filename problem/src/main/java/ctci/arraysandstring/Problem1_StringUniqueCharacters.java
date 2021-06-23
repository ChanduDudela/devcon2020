package ctci.arraysandstring;

public class Problem1_StringUniqueCharacters {

    private boolean hasUniqueCharacters(final String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i=0; i < str.length(); i++) {
            int val = str.charAt(i);

            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isUnique = new Problem1_StringUniqueCharacters().hasUniqueCharacters("tes");
        System.out.println(isUnique);
    }
}
