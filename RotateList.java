public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 1)
            return head;

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode q = root;
        ListNode p = head;

        int len = 0;

        while (q.next != null) {
            len++;
            q = q.next;
        }

        if (k == len) {
            return head;
        }

        q.next = head;
        root = q;

        if (k > len) {
            k %= len;
        }

        for (int i = 0; i < len - k; i++)
            root = root.next;
        q = root.next;
        root.next = null;

        return q;
    }
}
