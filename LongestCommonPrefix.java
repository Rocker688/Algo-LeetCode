public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String pre = strs[0];

        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }
//    public String longestCommonPrefix(String[] strs) {
//        String result = "";
//
//        if (strs.length < 1 || strs == null)
//            return "";
//
//        if (strs.length == 1)
//            return strs[0];
//
//        int minLen = Integer.MAX_VALUE;
//
//        for (int i = 0; i < strs.length; i++) {
//            if (strs[i].length() < minLen) {
//                minLen = strs[i].length();
//                String temp = strs[0];
//                strs[0] = strs[i];
//                strs[i] = temp;
//            }
//        }
//
//        if (strs[0].length() < 1)
//            return "";
//
//        for (int i = 0; i < minLen; i++) {
//            boolean flag = true;
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (strs[j].charAt(i) != c) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (!flag)
//                break;
//            else
//                result += c;
//        }
//
//        return result;
//
//    }

    public static void main(String[] args) {
        String[] strs = new String[2];
        strs[0] = new String("");
        strs[1] = new String("b");

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.print(lcp.longestCommonPrefix(strs));

    }
}
