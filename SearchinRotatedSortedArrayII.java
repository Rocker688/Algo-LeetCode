public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = (first + last) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && nums[mid] > target)
                    last = mid;
                else
                    first = mid + 1;
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last - 1])
                    first = mid + 1;
                else
                    last = mid;
            } else
                first++;
        }
        return false;
    }
}
