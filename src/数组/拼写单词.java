package 数组;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName： 拼写单词
 * @description:
 * @author: lisheng
 * @create: 2020-03-17 08:57
 **/
public class 拼写单词 {
    public int countCharacters(String[] words, String chars) {
          int []asiII=new int[26];
          int rs=0;
          for(char c:chars.toCharArray()){
              asiII[c-'a']=asiII[c-'a']+1;
          }
          A:for(String word:words){
              int[] thisCount = Arrays.copyOf(asiII, 26);
              for(char c:word.toCharArray()){
                  int count = thisCount[c-'a'];
                  if(count<=0)continue A;
                  else thisCount[c-'a']=count-1;
              }
              rs+=word.length();
          }
          return rs;
     }

}
