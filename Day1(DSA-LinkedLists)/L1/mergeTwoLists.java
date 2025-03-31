package DSA.LinkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeTwoLists {

    public ListNode mergeTwoLinkedLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLinkedLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLinkedLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        // Test lists
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        mergeTwoLists merger = new mergeTwoLists();
        ListNode mergedList = merger.mergeTwoLinkedLists(list1, list2);

        // Print the merged list
        System.out.print("Merged List: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}