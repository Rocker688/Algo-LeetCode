public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 0) return;
        int firstDigit = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstDigit = i;
                break;
            }
        }

        if (firstDigit == -1) {
            int prev = nums.length - 1;
            for (int i = 0; i < prev; i++) {
                int temp = nums[i];
                nums[i] = nums[prev];
                nums[prev--] = temp;
            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstDigit]) {
                    int temp = nums[i];
                    nums[i] = nums[firstDigit];
                    nums[firstDigit] = temp;
                    break;
                }
            }
            int prev = nums.length - 1;
            for (int i = firstDigit + 1; i < prev; i++) {
                int temp = nums[i];
                nums[i] = nums[prev];
                nums[prev--] = temp;
            }
        }
    }

    public static void main(String [] args) {
        int [] arr = new int[]{1, 2, 3};
        NextPermutation.nextPermutation(arr);
        for (int i : arr)
            System.out.println(i);
    }
}
