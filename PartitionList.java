public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        ListNode le = new ListNode(0); // 小于x的链表
        ListNode ge = new ListNode(0); // 大于等于x的链表
        ListNode t1 = le;
        ListNode t2 = ge;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                t1.next = p;
                t1 = p;
            } else {
                t2.next = p;
                t2 = p;
            }
            p = p.next;
        }

        t2.next = null;

        // 说明小于的链表上有数据
        if (t1 != le) {
            t1.next = ge.next;
            head = le.next;
        } else {
            head = ge.next;
        }
        return head;
    }
}
