public class LengOfLastWord {

    public int lengthOfLastWord(String s) {
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') tail--;
        while (tail >= 0 && s.charAt(tail) != ' ') {
            len++;
            tail--;
        }
        return len;
    }

//    public int lengthOfLastWord(String s) {
//        if (s.length() < 1)
//            return 0;
//
//        while (s.charAt(s.length() - 1) == ' ') {
//            s = s.substring(0, s.length() - 1);
//            if (s.length() == 0)
//                break;
//        }
//
//        int length = 0, beg = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                length = i - beg;
//                beg = i;
//            } else if (i == s.length() - 1) {
//                if (s.charAt(beg) == ' ')
//                    length = i - beg;
//                else
//                    length = i - beg + 1;
//            }
//
//        }
//
//        return length;
//    }

    public static void main(String[] args) {
        String str = "ab abccs abc";
        LengOfLastWord lolw = new LengOfLastWord();
        System.out.print(lolw.lengthOfLastWord(str));
    }
}
