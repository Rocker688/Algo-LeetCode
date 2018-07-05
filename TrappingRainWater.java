public class TrappingRainWater {

    public int trap(int[] height) {
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++)
            if (height[i] > height[maxHeight])
                maxHeight = i;
        int water = 0;
        for (int i = 0, peak = 0; i < maxHeight; i++) {
            if (height[i] > peak)
                peak = height[i];
            else
                water += peak - height[i];
        }

        for (int i = height.length - 1, top = 0; i > maxHeight; i--) {
            if (height[i] > top)
                top = height[i];
            else
                water += top - height[i];
        }

        return water;
    }

//    public int trap(int[] height) {
//        int result = 0;
//        int maxHeight = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > maxHeight)
//                maxHeight = height[i];
//        }
//
//        for (int i = 0; i < maxHeight; i++) {
//
//            int index = -1;
//            for (int j = 0; j < height.length; j++) {
//                if (index == -1 && height[j] > 0) {
//                    index = j;
//                } else if (height[j] > 0) {
//                    if (j - index > 1) {
//                        result += j - index - 1;
//
//                        index = j;
//                    } else
//                        index = j;
//                } else {
//                    continue;
//                }
//            }
//            System.out.println(result);
//            reset(height);
//        }
//
//        return result;
//    }
//
//    private void reset(int[] origin) {
//        for (int i = 0; i < origin.length; i++) {
//            origin[i]--;
//        }
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater tp = new TrappingRainWater();
        System.out.println(tp.trap(arr));
    }

}
