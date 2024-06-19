package LeetCode.Sort;

import java.util.List;

public class insertionSortList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();

        while (head != null){
            ListNode next = head.next;
            ListNode temp = dummy;

            while(temp.next != null && temp.next.val < head.val){
                temp = temp.next;
            }
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return dummy.next;
    }

}
