package 链表;

/**
 * @ClassName： 链表反转
 * @description:
 * @author: lisheng
 * @create: 2020-03-18 16:21
 **/
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class 链表反转 {
    public ListNode reverseList(ListNode head) {
        ListNode last=null;
        while (head!=null){
            ListNode thisNext=head.next;
            head.next=last;
            last=head;
            head=thisNext;
        }
        return last;
    }
    //这个地方有点怪  其实listNode引用的就是head.next部分
    //之所以不是lsitNode.next.ext=head 是因为listNode.next指向的并不是反转部分的末尾
    //指向反转部分的末尾的是head.next
    public ListNode reverseListByStack(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode listNode = reverseListByStack(head.next);
        head.next.next=head;
        head.next=null;
        return listNode;
    }


}
