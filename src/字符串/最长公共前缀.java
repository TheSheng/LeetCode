package 字符串;

/**
 * @ClassName： 最长公共前缀
 * @description:
 * @author: lisheng
 * @create: 2020-04-10 19:41
 **/
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        int max=strs[0].length();
        for(int i=1;i<strs.length;i++){
            int currMax=0;
            int maxIndex=Math.min(strs[i].length(),strs[i-1].length());
            int index=0;
            while(currMax<max&&index<maxIndex){
                if(strs[i].charAt(index)!=strs[i-1].charAt(index))break;
                else currMax++;
                index++;
            }
            if(currMax==0) return "";
            max=Math.min(currMax,max);
        }
        return strs[0].substring(0,max);
    }
}
