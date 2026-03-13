class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0)
            return head;

        // find length
        ListNode curr = head;
        int length = 1;

        while(curr.next != null){
            curr = curr.next;
            length++;
        }

        k = k % length;

        if(k == 0)
            return head;

        int steps = length - k;

        ListNode temp = head;

        for(int i = 1; i < steps; i++){
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        curr.next = head;

        return newHead;
    }
}