public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        int maxLength = 0;
        int iMax = 0;
        int i = 0;
        while (i < (n - 1)) {
            int left = i;
            int right = i;
            while (right < (n - 1) && sArr[left] == sArr[right + 1]) {
                right++;
            }
            i = right + 1;
            while (left > 0 && right < (n - 1) && sArr[left - 1] == sArr[right + 1]) {
                left--;
                right++;
            }
            int length = right - left + 1;
            if (length > maxLength) {
                maxLength = length;
                iMax = left;
            }
        }
        return s.substring(iMax, iMax + maxLength); // end index excluding
    }


//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 2)
//            return s;
//
//        int maxLength = 0;
//        String longest = null;
//
//        int length = s.length();
//        boolean[][] table = new boolean[length][length];
//
//        for (int i = 0; i < length; i++) {
//            table[i][i] = true;
//            longest = s.substring(i, i + 1);
//            maxLength = 1;
//        }
//
//        for (int i = 0; i < length - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                table[i][i + 1] = true;
//                longest = s.substring(i, i + 2);
//                maxLength = 2;
//            } else
//                table[i][i + 1] = false;
//        }
//
//        for (int len = 3; len <= length; len++) {
//            for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    table[i][j] = table[i + 1][j - 1];
//                    if (table[i][j] && maxLength < len) {
//                        longest = s.substring(i, j + 1);
//                        maxLength = len;
//                    }
//                } else {
//                    table[i][j] = false;
//                }
//            }
//        }
//
//        return longest;
//
//    }
}
