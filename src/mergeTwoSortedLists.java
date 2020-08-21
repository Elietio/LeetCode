//21. 合并两个有序链表
//        将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//         
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4

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
public class mergeTwoSortedLists {

    public static void main(String[] args) {

        mergeTwoSortedLists mergeTwoSortedLists = new mergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        while ( listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1){
            return l2;
        }
        if (null == l2){
            return l1;
        }

        ListNode result = l1;
        ListNode last = null;
        while (l2 != null) {
            ListNode now = l2;
            l2 = l2.next;
            while (true) {
                if (now.val < l1.val) {
                    if (last != null) {
                        last.next = now;
                        now.next = l1;
                        last = now;
                    } else {
                        ListNode temp = l1;
                        l1 = now;
                        l1.next = temp;
                        result = l1;
                        last = l1;
                        l1 = l1.next;
                    }
                    break;
                } else if (l1.next == null) {
                    l1.next = now;
                    return result;
                }
                last = l1;
                l1 = l1.next;
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
}
