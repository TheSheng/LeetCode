package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName： 反转链表
 * @description:
 * @author: lisheng
 * @create: 2020-03-03 15:15
 **/
public class 反转链表 {
//    public ListNode reverseList(ListNode head) {
//        //用于存储下一节点指向
//        List<ListNode> list=new ArrayList<>();
//        while (head!=null){
//           list.add(new ListNode(head.val));
//           head=head.next;
//        }
//
//        return  getNext(list,list.size()-1);
//    }
//    public  ListNode getNext(List<ListNode> list,Integer index){
//        ListNode rs;
//        if(index>0){
//            rs=list.get(index);
//            index--;
//            rs.next=getNext(list,index);
//        }
//        rs=list.get(0);
//        return  rs;
//    }
   // 头插法
   public static ListNode reverseList(ListNode head) {
       ListNode pre=null;
       ListNode curr=head;
       while (curr!=null){
           ListNode next=curr.next;
           curr.next=pre;
           pre=curr;
           curr=next;
       }
       return  pre;
   }
//
//   //用递归实现头插法
//    public static ListNode reverseList(ListNode head){
//         if(head==null|| head.next==null){
//             return head;
//         }
//         ListNode allPrev=reverseList(head.next);
//         //现在正在反转k,那么k+1应指向k
//         head.next.next=head;
//
//         return  allPrev;
//    }
    //尾插法
    public static void main(String[] args) {
        int[] num=new int[]{1,2,3,4,5};
        ListNode listNode=new ListNode(num[0]);
        listNode.next=init(listNode.next,num,1);
        System.out.println(reverseList(listNode));

    }
    public static ListNode init(ListNode listNode,int[] num,int index){
        listNode=new ListNode(num[index]);
        if(index<num.length-1){
            index=index+1;
            listNode.next=init(listNode.next,num,index);
        }else {
            listNode.next=new ListNode(num[index]);
        }
        return  listNode;

    }
}
