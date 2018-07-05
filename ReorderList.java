public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = head;
        ListNode r;

        int len = 0;
        int mid;

        while (p != null) {
            len++;
            p = p.next;
        }

        if (len < 2)
            return;

        mid = len % 2 == 0? len / 2: len / 2 + 1;

        p = head;
        for (int i = 1; i < mid; i++)
            p = p.next;

        r = p.next;
        p.next = null;
        r = reverseList(r);
        p = head;


        while (r != null) {
            ListNode temp = p.next;
            p.next = r;
            p = temp;
            temp = r.next;
            r.next = p;
            r = temp;
        }


    }

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode q = head;
        ListNode p = head.next;
        ListNode r;

        if (p == null)
            return head;

        q.next = null;

        while (p.next != null) {
            r = p.next;

            p.next = q;
            q = p;
            p = r;
        }

        p.next = q;
        return p;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList rl = new ReorderList();
        rl.reorderList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
