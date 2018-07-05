
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode root = head;
        while (root != null) {
            root = root.next;
            if (root == null)
                return head;
            if (root.val != pre.val) {
                pre.next = root;
                pre = pre.next;
            }

            if (root.next == null && pre.val == root.val) {
                pre.next = null;
                break;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode head = l1;
        l1.next = new ListNode(1);
        l1 = l1.next;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;
        l1.next = new ListNode(3);
        RemoveDuplicatesFromSortedList rm = new RemoveDuplicatesFromSortedList();
        rm.deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
