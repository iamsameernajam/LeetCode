class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);

        ListNode cur = head, prev = null;
        while(cur != null) {
            if(hs.contains(cur.val)) {
                if(cur == head) 
                    head=head.next;
                else
                    prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}