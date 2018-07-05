import java.util.LinkedList;
import java.util.List;

public class GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        if (n >= 0) {
            // 格雷码的前半部分
            result.add(0);
            // 格雷码最高位的值（非0时）
            int t = 1;
            // 每一次外循环求出的是位数i+1位的格雷码表，其相当于长度为i+1位的格雷码表的前半部分
            for (int i = 0; i < n; i++) {
                // 求出的长度为i+1位格雷码表的后半部分，前半部分由长度为i位的格雷码表给出
                for (int j = result.size() - 1; j >= 0; j--) {
                    result.add(result.get(j) ^ t);
                }
                // 最高位右移
                t <<= 1;
            }
        }
        return result;
    }
}
