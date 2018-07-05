import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        k--;

        for (int i = n; i >= 1; i--) {
            int j = k / factorial[i - 1];
            k %= factorial[i - 1];
            sb.append(nums.get(j));
            nums.remove(j);

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}
