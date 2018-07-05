public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode root = new ListNode(0);
        ListNode p = root;
        root.next = head;

        for (int i = 1; i < m && p != null; i++) {
            p = p.next;
        }

        if (p != null) {
            ListNode q = p.next;
            ListNode r;

            // 如果m为负数就认为是从第一个开始交换
            if (m < 1) {
                m = 1;
            }

            n = n - m + 1; // n为要换的结点数目
            // 有两个结点时才要使用尾插法，尾插的个数为n-1
            for (int i = 1; i < n && q.next != null; i++) {
                // 为要进行尾插的结点
                r = q.next;

                // 在q结点的后面进行尾插操作
                q.next = r.next;
                r.next = p.next;
                p.next = r;
            }

            head = root.next;
        }

        return head;
    }
}
