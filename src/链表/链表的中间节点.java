package 链表;

/**
 * @ClassName： 链表的中间节点
 * @description:
 * @author: lisheng
 * @create: 2020-03-23 09:14
 **/
public class 链表的中间节点 {
    //遍历两次  计数取中位数  O(N) O(1)
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode curr=head;
        while (curr!=null){
            count++;
            curr=curr.next;
        }
        int ans=count%2==0?count/2+1:count/2;
        count=1;
        while(head!=null){
            if(count==ans)return head;
            count++;
            head=head.next;
        }
        return null;
    }

    //快满指针
    public ListNode middleNodeByFastAndSlow(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null||fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
