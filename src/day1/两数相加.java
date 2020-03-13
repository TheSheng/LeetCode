package day1;

/**
 * @ClassName： 两数相加
 * @description:
 * @author: lisheng
 * @create: 2020-03-03 09:15
 **/
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs=new ListNode(0);
        rs=needNode(rs,l1,l2,0);
        return  rs;

    }
    public  ListNode needNode(ListNode next,ListNode left,ListNode  right,Integer sum){
        int nextVal=left.val+right.val+sum;
        sum=nextVal>9?1:0;
        nextVal=nextVal>9?nextVal-10:nextVal;
        next.val=nextVal;
        if(sum>0 || left.next !=null ||right.next!=null){
            next.next=new ListNode(0);
            next.next=needNode(next.next,left.next==null?new ListNode(0):left.next,right.next==null?new ListNode(0):right.next,sum);
        }
        return  next;
    }



}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

     @Override
     public String toString() {
         return "ListNode{" +
             "val=" + val +
             ", next=" + next +
             '}';
     }
 }
