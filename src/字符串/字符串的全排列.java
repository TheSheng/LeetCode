package 字符串;

import java.util.*;

/**
 * @ClassName： 字符串的全排列
 * @description:
 * @author: lisheng
 * @create: 2020-04-10 20:07
 **/
public class 字符串的全排列 {
    public static String[] permutation(String s) {
        List<String> rs=new LinkedList<>();
        char[] chars=new char[s.length()];
        LinkedList<Character> list=new LinkedList<>();

       dfs(rs,chars,0,s.toCharArray());
       return rs.toArray(new String[rs.size()]);
    }
    public static void dfs(List<String> rs,char [] chars,int index,char[] canUse){
        int[] set=new int[26];
        for(int i=0;i<canUse.length;i++){
            char curr=canUse[i];
            if(curr==0)continue;
            if(set[curr-'a']==1)continue;
            chars[index]=curr;
            if(index==chars.length-1)rs.add(String.valueOf(chars));
            else {
                canUse[i]=0;
                dfs(rs,chars,index+1,canUse);
                canUse[i]=curr;
            }
            set[curr-'a']=1;
        }

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
    }
}
