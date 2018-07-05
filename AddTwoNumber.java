
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p = l1, q = l2, current = l3;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
            current = current.next;
        }
        return l3.next;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = new ListNode(-1);
//        ListNode first = result;
//        int carry = 0;
//        while (l1 != null || l2 != null || carry != 0) {
//            if (l1 == null && l2 == null){
//                result.val = carry;
//            } else if (l1 == null) {
//                result.val = l2.val + carry;
//                l2 = l2.next;
//            } else if (l2 == null) {
//                result.val = l1.val + carry;
//                l1 = l1.next;
//            } else {
//                result.val = l1.val + l2.val + carry;
//                l1 = l1.next;
//                l2 = l2.next;
//            }
//            if (result.val >= 10) {
//                carry = 1;
//                result.val %= 10;
//            } else
//                carry = 0;
//            if (l1 == null && l2 == null && carry == 0)
//                break;
//            result.next = new ListNode(-1);
//            result = result.next;
//
//        }
//
//        return first;
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        AddTwoNumber atn = new AddTwoNumber();
        ListNode res = atn.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}


