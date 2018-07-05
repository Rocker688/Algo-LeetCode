public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode q = root;
        ListNode p = head;

        while (q != null && p != null) {

            if (q == p)
                return true;

            q = q.next;

            if (p.next != null)
                p = p.next.next;
            else
                return false;

            if (q == null || p == null)
                return false;
        }

        return false;
    }
}
