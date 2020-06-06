package LeetCode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode d11 = new ListNode(9, null);
        ListNode d0 = new ListNode(9, d11);
        ListNode d1 = new ListNode(3, d0);
        ListNode d2 = new ListNode(4, d1);
        ListNode d3 = new ListNode(2, d2);


        ListNode e0 = new ListNode(9, null);
        ListNode e1 = new ListNode(4, e0);
        ListNode e2 = new ListNode(6, e1);
        ListNode e3 = new ListNode(5, e2);

        Solution1 sol = new Solution1();
        ListNode sum = sol.addTwoNumbers(d3, e3);
        System.out.println(sum.deserialize());
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    String deserialize() {
        String number = "";
        ListNode temp = this;
        while(temp!=null){
            number+= (temp.val+" -> ");
            temp = temp.next;
        }
        return number;
    }
}

class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode start = sum;
        while(l1!=null || l2!=null){
            int l1Val = 0;
            int l2Val = 0;
            if(l1!=null){
                l1Val = l1.val;
            }
            if(l2!=null){
                l2Val = l2.val;
            }
            int s = l1Val + l2Val + sum.val;
            sum.val = s%10;

            ListNode temp = new ListNode();
            temp.val = s/10;

            if(((l1!=null && l1.next!=null) || (l2!=null && l2.next!=null)) || temp.val>0) {
                sum.next = temp;
            }


            sum = temp;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }

        }
        return start;
    }
}
