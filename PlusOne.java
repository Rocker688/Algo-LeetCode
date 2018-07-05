import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] >= 10 && i == 0) {
                result[0] = 1;
                return result;
            } else if ( digits[i] >= 10){
                digits[i] %= 10;
                carry = 1;
            } else {
                return digits;
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] arr = new int[]{1, 2, 3};
        for (int i : po.plusOne(arr))
            System.out.println(i);
    }
}
