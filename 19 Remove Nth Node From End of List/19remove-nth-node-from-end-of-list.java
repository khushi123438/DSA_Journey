/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         int s = 0;
        ListNode temp = head;

       
        while (temp != null) {
            temp = temp.next;
            s++;
        }

      
        if (n == s) {
            return head.next;
        }

        int c = s - n; 
        ListNode prev = head;

    for (int i = 1; i < c; i++) {
            prev = prev.next;
        }

     
        prev.next = prev.next.next;

        return head;
    
    }
}