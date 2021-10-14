package leetcode;

class PrintCurrency {
  public static void main(String[] args) {
    System.out.println(getCurrString(1234567890L));
  }

  public static String getCurrString(Long price) {
    String str = price.toString();

    int strLength = str.length();

    String result= "";

    for (int i = 0; i < strLength; i++) {
      if ((strLength-i) % 3 == 0 && i != 0){
        result += ",";
      }
      result += str.charAt(i);
    }

    return result;
  }
}
