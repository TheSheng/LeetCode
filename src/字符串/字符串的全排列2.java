package 字符串;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName： 字符串的全排列
 * @description:
 * @author: lisheng
 * @create: 2020-04-10 20:07
 **/
public class 字符串的全排列2 {
    public static boolean checkInclusion(String s1, String s2) {
        int[] db=new int[26];
        for(char cuur:s1.toCharArray())db[cuur-'a']++;
        return huachuang(0,s1.length()-1,db,s2,s1.length()-1);
    }
    public  static boolean  huachuang(int start,int end,int [] db,String s2,int length){
        if(start>=s2.length()||end>=s2.length())return false;
        int[] thisDB = Arrays.copyOf(db, db.length);
        int index=start;
        while (index<=end){
            int thisCount = thisDB[s2.charAt(index)-'a'];
            if(thisCount==0){
                if(db[s2.charAt(index)-'a']!=0)return huachuang(start+1,start+1+length,db,s2,length);
                return huachuang(index+1,index+1+length,db,s2,length);
            }
            thisDB[s2.charAt(index)-'a']--;
            index++;
        }
       return true;
    }

    public static void main(String[] args) {
        boolean b = checkInclusion("ab", "eidbaooo");
        System.out.println(b);
    }

}
