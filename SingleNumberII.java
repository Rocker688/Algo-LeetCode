import java.util.Arrays;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int i : nums) {
            one = (one ^ i) & ~two;
            two = (two ^ i) & ~one;
        }
        return one;
    }

//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        if (nums.length == 1)
//            return nums[0];
//        else {
//            if (nums[0] != nums[1])
//                return nums[0];
//            if (nums[nums.length - 1] != nums[nums.length - 2])
//                return nums[nums.length - 1];
//        }
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
//                return nums[i];
//        }
//        return -1;
//    }
}
