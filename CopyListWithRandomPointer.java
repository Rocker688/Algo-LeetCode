class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        copyNode(head);
        linkRandomPointer(head);

        return splitList(head);
    }

    private void copyNode(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode cpNode = new RandomListNode(node.label);
            cpNode.next = node.next;
            node.next = cpNode;
            node = node.next.next;
        }
    }

    private void linkRandomPointer(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode cpNode;
        while (node != null) {
            cpNode = node.next;
            if (node.random != null)
                cpNode.random = node.random.next;
            node = cpNode.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode cpNode;
        RandomListNode result = head.next;

        while (node != null) {
            cpNode = node.next;
            node.next = cpNode.next;
            if (node.next != null)
                cpNode.next = node.next.next;
            node = node.next;
        }

        return result;
    }

}
