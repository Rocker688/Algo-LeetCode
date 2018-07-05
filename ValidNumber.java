public class ValidNumber {
    public boolean isNumber(String s) {
        if (s.length() == 0 || s == null)
            return false;

        boolean num = false, numAfterE = true, dot = false, exp = false, sign = false;

        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                if (i < n - 1 && s.charAt(i + 1) != ' ' && (num || dot || exp || sign))
                    return false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != ' ') return false;
                sign = true;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = true;
                numAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (s.charAt(i) == 'e') {
                if (exp || !num)
                    return false;
                exp = true;
                numAfterE = false;
            } else return false;
        }

        return num && numAfterE;
    }

    public static void main(String[] args) {
        String str = "0";
        ValidNumber vn = new ValidNumber();
        System.out.print(vn.isNumber(str));
    }
}
