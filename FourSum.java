import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++)
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] > target)
                        l--;
                    else if (nums[i] + nums[j] + nums[k] + nums[l] < target)
                        k++;
                    else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        result.add(tmp);
                        l--;
                        k++;
                    }
                }
            }
        Set<List<Integer>> hs = new HashSet<>();
        hs.addAll(result);
        result.clear();
        result.addAll(hs);
        return result;
    }

    public List<List<Integer>> fourSumSol2(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (num.length < 4) return ans;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (num[i] + num[i + 1] + num[i + 2] + num[i + 3] > target)
                break; //first candidate too large, search finished
            if (num[i] + num[num.length - 1] + num[num.length - 2] + num[num.length - 3] < target)
                continue; //first candidate too small
            if (i > 0 && num[i] == num[i - 1]) continue; //prevents duplicate result in ans list
            for (int j = i + 1; j < num.length - 2; j++) {
                if (num[i] + num[j] + num[j + 1] + num[j + 2] > target) break; //second candidate too large
                if (num[i] + num[j] + num[num.length - 1] + num[num.length - 2] < target)
                    continue; //second candidate too small
                if (j > i + 1 && num[j] == num[j - 1]) continue; //prevents duplicate results in ans list
                int low = j + 1, high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while (low < high && num[low] == num[low + 1]) low++; //skipping over duplicate on low
                        while (low < high && num[high] == num[high - 1]) high--; //skipping over duplicate on high
                        low++;
                        high--;
                    }
                    //move window
                    else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3, -1, 0, 2, 4, 5};
        //int[] arr = new int[]{1, 0, -1, 0, -2, 2}; //{-2, -1, 0, 0, 1, 2}
        FourSum fs = new FourSum();
        for (List<Integer> i : fs.fourSum(arr, 2)) {
            for (int j : i)
                System.out.print(j + "\t");
            System.out.println();
        }
    }
}
