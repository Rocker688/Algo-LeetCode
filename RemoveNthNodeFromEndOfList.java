public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode q = root;
        ListNode p = head;

        int len = 0;

        while (p != null) {
            len++;
            p = p.next;
        }

        p = head;

        for (int i = 0; i < len - n; i++) {
            q = q.next;
        }

        if (q.next != null) {
            p = q.next;
        } else
            return root.next;

        q.next = p.next;

        return root.next;
    }
}
