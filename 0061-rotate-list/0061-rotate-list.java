class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // find length and tail
        ListNode tail = head;
        int n = 1;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // make circular
        tail.next = head;

        // reduce k
        k = k % n;

        // find new tail
        int steps = n - k;
        ListNode newTail = tail;

        while (steps > 0) {
            newTail = newTail.next;
            steps--;
        }

        // new head
        ListNode newHead = newTail.next;

        // break circle
        newTail.next = null;

        return newHead;
    }
}