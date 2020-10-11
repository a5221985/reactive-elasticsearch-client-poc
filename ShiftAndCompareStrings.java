public class ShiftAndCompareStrings {
    public boolean isShifted(String a, String b) {
        int start = 0;
        int index = 0;
        while (start >= 0  && start < a.length() && (index = b.substring(start).indexOf(a.charAt(0))) != -1) {
            index += b.substring(0, start).length();
            String subString1 = b.substring(index);
            String subString2 = b.substring(0, index);
            if (subString1.equals(a.substring(0, subString1.length())) && subString2.equals(a.substring(subString1.length())))
                return true;
            start = index + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        ShiftAndCompareStrings sacs = new ShiftAndCompareStrings();
        //String a = "abcde";
        //String b = "cdeab";
        //String a = "abc";
        //String b = "acb";
        String a = "abcabcde";
        String b = "cabcdeab";
        System.out.println(sacs.isShifted(a, b));
    }
}
