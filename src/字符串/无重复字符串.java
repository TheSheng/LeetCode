package 字符串;

/**
 * @ClassName： 无重复字符串
 * @description:
 * @author: lisheng
 * @create: 2020-03-03 10:15
 **/
public class 无重复字符串 {
    public static int lengthOfLongestSubstring(String s) {
        int sum=0;
        int [] ascII=new int[128];
        for(int index=0,left=0;index<s.length();index++){
            left=Math.max(left,ascII[s.charAt(index)]);
            sum=Math.max(index-left+1,sum);
            ascII[s.charAt(index)]=index+1;
        }
        return  sum;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bacabcbb"));
    }

}
