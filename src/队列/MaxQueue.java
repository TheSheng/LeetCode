package 队列;

/**
 * @ClassName： 队列的最大值
 * @description:
 * @author: lisheng
 * @create: 2020-03-07 08:33
 **/
public class MaxQueue {
    int[] quene;
    int pushIndex=0;
    int popIndex=0;
    int [] max;
    int  maxLeftIndex=0;
    int  maxRightIndex=0;
    public MaxQueue() {
        quene=new int[10000];
        max=new int[10000];
    }
    public int max_value() {
          if(maxLeftIndex==maxRightIndex)return -1;
          return max[maxLeftIndex];
    }
    public void push_back(int value) {
         quene[pushIndex++]=value;
         while (maxRightIndex>maxLeftIndex&&max[maxRightIndex-1]<value){
             maxRightIndex--;
         }
         max[maxRightIndex++]=value;
    }
    public int pop_front() {
        if(popIndex==pushIndex)return -1;
        int thisVal = quene[popIndex++];
        if(thisVal==max[maxLeftIndex])maxLeftIndex++;
        return thisVal;
    }

    public static void main(String[] args) {
        int[] nums=new int[2];
        System.out.println(nums[-1]);
    }
}
