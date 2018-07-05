import java.util.Arrays;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        boolean match[][] = new boolean[p.length() + 1][s.length() + 1];
        match[0][0] = true;

//        if (p.charAt(0) == '.')
//            match[1][0] = true;

        for (int j = 1; j <= s.length(); j++) {
            match[0][j] = false;
        }

        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*')
                match[i][0] = match[i - 2][0];
        }

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1))
                    match[i][j] = match[i - 1][j - 1];
                else if (p.charAt(i - 1) == '*') {
                    if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.')
                        match[i][j] = match[i - 2][j] || match[i][j - 1];
                    else {
                        match[i][j] = match[i - 2][j];
                    }
                } else
                    match[i][j] = false;
            }
        }

        for (int i = 0; i < match.length; i++) {
            for (int j = 0; j < match[0].length; j++)
                System.out.print(match[i][j] + "\t");
            System.out.println();
        }

        return match[p.length()][s.length()];

    }

    public static void main(String[] agrs) {
        String s = "abcdd";
        String p = "abcd*";
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch(s, p));
    }
}
