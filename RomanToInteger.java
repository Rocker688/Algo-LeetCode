public class RomanToInteger {
    /**
     * 根据罗马数字与整数数字对应关系进行加法操作，如果前一个数字比后一个大就相减，否则进行相加。
     * */
    public int romanToInt(String s) {

        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I': // 1
                    if (1 < prev) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    prev = 1;
                    break;

                case 'V': // 5

                    if (5 < prev) {
                        result -= 5;
                    } else {
                        result += 5;
                    }

                    prev = 5;

                    break;
                case 'X': // 10
                    if (10 < prev) {
                        result -= 10;
                    } else {
                        result += 10;
                    }

                    prev = 10;
                    break;
                case 'L': // 50
                    if (50 < prev) {
                        result -= 50;
                    } else {
                        result += 50;
                    }

                    prev = 50;
                    break;
                case 'C': // 100
                    if (100 < prev) {
                        result -= 100;
                    } else {
                        result += 100;
                    }

                    prev = 100;
                    break;
                case 'D': // 500
                    if (500 < prev) {
                        result -= 500;
                    } else {
                        result += 500;
                    }

                    prev = 500;
                    break;
                case 'M': // 1000
                    result += 1000;
                    prev = 1000;
                    break;
            }
        }

        return result;
    }
}
