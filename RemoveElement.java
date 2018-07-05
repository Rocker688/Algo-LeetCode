import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int [] nums, int val) {
        if (nums.length <= 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String [] args) {
        int [] arr = new int[]{1, 2, 3, 1, -1, 2, 2, 4, 5, 3, 1};
        System.out.println(RemoveElement.removeElement(arr, 2));
    }
}
