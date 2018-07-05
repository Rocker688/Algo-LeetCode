public class IntegerToRoman {
    public String intToRoman(int num) {
        final String[][] roman = new String[][]{
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "MC"},
                {"M", "MM", "MMM", "", "", "", "", "", ""}};

        String result = "";

        for (int i = 0; num != 0; num /= 10, i++) {
            if (num % 10 != 0) {
                result = roman[i][num % 10 - 1] + result;
            }
        }

        return result;
    }
}
