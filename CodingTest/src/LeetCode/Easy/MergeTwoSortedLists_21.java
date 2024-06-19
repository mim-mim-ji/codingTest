package LeetCode.Easy;

public class MergeTwoSortedLists_21 {

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
        ListNode l1 = ArrayToList(new int[] {1,3,8,10});
        ListNode l2 = ArrayToList(new int[] {1,4,5,6});
        System.out.print("List1 = ");
        PrintList(l1);
        System.out.print("List2 = ");
        PrintList(l2);
        System.out.print("Merged List = ");
        PrintList(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2:l1;
        return dummy.next;
    }

    private static ListNode ArrayToList(int[] nums) {
         if(nums == null || nums.length == 0){
             return null;
         }
         ListNode node = new ListNode(0);
         ListNode head = node;

         for(int num : nums){
             node.next = new ListNode(num);
             node = node.next;
         }
         return head.next;
    }

    private static void PrintList(ListNode root) {
         System.out.print(root.val);
         if(root.next != null){
             System.out.print("-->");
             PrintList(root.next);
         }else{
             System.out.println();
         }
    }
}
