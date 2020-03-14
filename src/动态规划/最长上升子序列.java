package 动态规划;

/**
 * @ClassName： 最长上升子序列
 * @description:
 * @author: lisheng
 * @create: 2020-03-14 10:12
 **/
public class 最长上升子序列 {
    static int sum=1;
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        int [] beiwang=new int[nums.length];
        lengthOfthisStart(nums,beiwang,0);
        return sum;
    }
    public static int lengthOfthisStart(int[] nums,int [] beiwang,int start){
        if(start==nums.length-1)return 1;
        if(beiwang[start]!=0)return beiwang[start];
        int end=start+1;
        int thisSum=1;
        while (end<nums.length){
            int thisEndSum = lengthOfthisStart(nums, beiwang, end);
           if(nums[end]>nums[start]){
               thisSum=Math.max(thisSum,1+thisEndSum);
           }
            end++;
        }
        beiwang[start]=thisSum;
        sum=Math.max(sum,thisSum);
        return thisSum;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
