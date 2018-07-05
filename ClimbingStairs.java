public class ClimbingStairs {
    public int climbStairs(int n) {
        int result = 1, temp = 0;
        if (n <= 0) return 0;
        for (int i = 0; i < n; i++) {
            int tmp = result + temp;
            temp = result;
            result = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(n));
    }
}
