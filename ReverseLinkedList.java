public class ReverseLinkedList {
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

        ReverseLinkedList rll = new ReverseLinkedList();
        head = rll.reverseList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
