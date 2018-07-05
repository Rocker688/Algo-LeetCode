/**
 * @author Yi Zeng
 * */
public class AddBinary {
    public String addBinary(String a, String b) {
        int[] ca = new int[a.length()];
        int[] cb = new int[b.length()];

        for (int i = 0; i < a.length(); i++) {
            ca[i] = a.charAt(i) - '0';
        }

        for (int i = 0; i < b.length(); i++)
            cb[i] = b.charAt(i) - '0';

        if (ca.length < cb.length) {
            int[] temp = ca;
            ca = cb;
            cb = temp;
        }

        int ai = ca.length - 1;
        int bi = cb.length - 1;
        int carry = 0;
        int result;

        while (ai >= 0 && bi >= 0) {
            result = ca[ai] + cb[bi] + carry;
            ca[ai] = result % 2;
            carry = result / 2;

            ai--;
            bi--;
        }

        while (ai >= 0) {
            result = ca[ai] + carry;
            ca[ai] = result % 2;
            carry = result / 2;

            ai--;
        }

        for (int i = 0; i < ca.length; i++)
            ca[i] += '0';

        if (carry == 0) {
            char[] c = new char[ca.length];
            for (int i = 0; i < ca.length; i++)
                c[i] = (char)(ca[i]);
            //System.out.println(new String(c));
            return new String(c);
        } else {
            char[] c = new char[ca.length + 1];
            c[0] = 1 + '0';
            for (int i = 0; i < ca.length; i++)
                c[i + 1] = (char)(ca[i]);

            //System.out.println(new String(c));
            return new String(c);
        }
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary(a, b));
    }
}
