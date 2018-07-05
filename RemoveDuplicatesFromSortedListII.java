public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode q = root;
        ListNode p = head;

        int count = 0;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                count++;
                q.next = p;
                p = p.next;
            } else {
                if (count == 0) {
                    q.next = p;
                    q = p;
                    p = p.next;
                } else {
                    q.next = p.next;
                    p = p.next;
                    count = 0;
                }
            }
        }

        if (count != 0) {
            q.next = null;
        } else
            q.next = p;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,4,5};
        ListNode head = new ListNode(0);
        ListNode root = head;
        for (int i = 0; i < arr.length; i++) {
            root.val = arr[i];
            if (i == 6)
                break;
            root.next = new ListNode(0);
            root = root.next;
        }
        RemoveDuplicatesFromSortedListII rm = new RemoveDuplicatesFromSortedListII();
        rm.deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }
}
