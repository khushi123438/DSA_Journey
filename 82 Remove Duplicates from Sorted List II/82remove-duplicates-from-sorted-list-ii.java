class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

       
        while (head != null && head.next != null && head.val == head.next.val) {
            int dup = head.val;

            while (head != null && head.val == dup) {
                head = head.next;
            }
        }

      
        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.next.next != null && curr.next.val == curr.next.next.val) {
                int dup = curr.next.val;

           
                while (curr.next != null && curr.next.val == dup) {
                    curr.next = curr.next.next;
                }

            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
