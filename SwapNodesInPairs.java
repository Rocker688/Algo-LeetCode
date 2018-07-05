public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode q = root;
        ListNode p = head;

        if (p.next != null) {
            q = p;
            p = p.next;
        } else {
            return root.next;
        }

        while (p != null) {
            swap(q, p);
            q = p.next;
            if (q != null && q.next != null)
                p = q.next;
            else
                return root.next;
        }



        return root.next;
    }

    private void swap(ListNode l1, ListNode l2) {
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
    }
}
