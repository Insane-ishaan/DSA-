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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> ls = new ArrayList<>();
        ListNode curr = null;

        for (ListNode list : lists) {
            curr = list;
            while (curr != null) {
                ls.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(ls);
        ListNode head = null;
        ListNode tail = null;

        for (int val : ls) {
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }
}