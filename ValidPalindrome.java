public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;

        while (beg <= end) {
            if (!isNumOrLetter(s.charAt(beg))) {
              beg++;
              continue;
            }

            if (!isNumOrLetter(s.charAt(end))) {
                end--;
                continue;
            }

            char begChar = Character.toLowerCase(s.charAt(beg));
            char endChar = Character.toLowerCase(s.charAt(end));

            if (begChar != endChar)
                return false;

            beg++;
            end--;
        }

        return true;
    }

    private boolean isNumOrLetter(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        String str = "0P";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(str));
    }
}
