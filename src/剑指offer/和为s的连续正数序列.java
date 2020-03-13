package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName： 和为s的连续数组
 * @description:
 * @author: lisheng
 * @create: 2020-03-06 16:43
 **/
public class 和为s的连续正数序列 {
    public static int[][] findContinuousSequence(int target) {
            List<int[]> rs=new ArrayList<>();
            if(target<3)return null;
            int start=1;
            while (start<target){
                // x=b^2-4ac a=1 b=1
                if(start>target/2)break;
                double c =1-4*Double.valueOf((-Math.pow(start,2)+start-2*target));
                double sqrt = Math.sqrt(c);
                if(Double.valueOf(sqrt).intValue()!=sqrt){
                    //开更号不是整数 肯定不行
                    start++;
                    continue;
                }
                double y=(sqrt-1)/2;
                if(Double.valueOf(y).intValue()!=y){
                    //求得的边界不是整数跳过
                    start++;
                    continue;
                }
                int end = Double.valueOf(y).intValue();
                int[] thisInts = new int[end-start+1];
                int thisIndex=end-start;
                while (thisIndex>=0){
                    thisInts[thisIndex]=end;
                    end--;
                    thisIndex--;
                }
                rs.add(thisInts);
                start++;
            }
            int[][] result = new int[rs.size()][];
            for(int i=0;i<rs.size();i++){
                result[i]=rs.get(i);
            }
            return result;
        }


    public static void main(String[] args) {


    }
}
