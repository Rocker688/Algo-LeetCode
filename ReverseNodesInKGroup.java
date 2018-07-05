public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        // 分组的头一个元素的前驱
        ListNode groupHead = root;
        // 当前要处理的结点
        ListNode curr = head;
        // 处理好的链表的尾结点
        ListNode groupTail = head;
        // 当前要处理的结点的后继
        ListNode next;

        // 对每个组，处理了多少个结点
        int count = 0;


        while (curr != null) {

            // 如果是分组的第一个元素就记录它
            if (count == 0) {
                groupTail = curr;
            }

            // 记录处理的元素个数
            count++;
            // 记录下一个待处理结点
            next = curr.next;
            // 进行尾插法操作
            curr.next = groupHead.next;
            groupHead.next = curr;
            curr = next;

            // 已经处理完了k个结点，分组头的前驱移动到最后一个链接好的结点
            if (count == k) {
                groupHead = groupTail;
                // 计数器归零
                count = 0;
            }
        }


        // 说明结点个数不是k的整数倍，将最后不是整数倍的个元素的结点，
        // 再次使用尾插法进行还原
        if (count != 0) {
            curr = groupHead.next;
            groupHead.next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = groupHead.next;
                groupHead.next = curr;
                curr = next;
            }
        }

        return root.next;
    }

}
