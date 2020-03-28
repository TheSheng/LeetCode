import 广度优先搜索.对称二叉树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName： 单词的压缩编码
 * @description:
 * @author: lisheng
 * @create: 2020-03-28 10:54
 **/
public class 单词的压缩编码 {
    //KMP是错误的  这道题只能算后缀  如果在中间部分出现是不算的
//    public int minimumLengthEncoding(String[] words) {
//        Arrays.sort(words, (o1, o2) -> o2.length()-o1.length());
//        StringBuilder rs=new StringBuilder();
//        for(String str:words){
//            int i = strStrByKMP(rs.toString(), str);
//            if(i==-1)rs.append(str).append("#");
//        }
//        return rs.length();
//    }
//    public  int strStrByKMP(String haystack, String needle){
//        if(needle.length()==0)return 0;
//        if(needle.length()>haystack.length())return -1;
//        int[] next=new int[needle.length()];
//        getNext(next,needle);
//        int i=0;
//        int pIndex=0;
//        //从第0位开始与p串的第0位开始比
//        //如果相同  如果已经满了  返回这个i 如果没满 各+1位继续比较
//        //如果不同
//        //   j==0的话i++退出二次循环
//        //     else i不变 j取next对应值，重新比较
//        B:while (pIndex<needle.length()&&i<haystack.length()){
//            if(haystack.charAt(i)==needle.charAt(pIndex)){
//                if(pIndex+1==needle.length())return i-pIndex;
//                i++;pIndex++;
//            }else{
//                if(pIndex==0){i++;}
//                else{pIndex=next[pIndex-1];};
//            }
//        }
//
//        return -1;
//    }
//    //next算法 求最大公共长度
//    public void getNext(int []next,String p){
//        for(int i=0;i<next.length;i++){
//            int start=i-1;
//            int end=i;
//            while(start>=0){
//                if(p.charAt(end)==p.charAt(start)){
//                    start--;
//                    end--;
//                }else{
//                    if(end!=i){
//                        end=i;
//                    }else {
//                        start--;
//                    }
//                }
//            }
//            next[i]=i-end;
//        }
//    }
    //反转 排序
    public int minimumLengthEncoding(String[] words) {

        words = Arrays.stream(words).map(s -> new StringBuilder(s).reverse().toString()).sorted().toArray(String[]::new);
        int sum=0;
        for(int i=0;i<words.length;i++){
            if(i<words.length-1&&words[i+1].startsWith(words[i]));
            else sum+=words[i].length()+1;
        }
        return sum;
    }
    //根据尾部来排序
    public int minimumLengthEncodingDontReverse(String[] words) {

        Arrays.sort(words, (s1, s2) -> {
            int N1 = s1.length();
            int N2 = s2.length();
            for (int i = 0; i < Math.min(N1, N2); i++) {
                char c1 = s1.charAt(N1 - 1 - i);
                char c2 = s2.charAt(N2 - 1 - i);
                int c = Character.compare(c1, c2);
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(N1, N2);
        });
        int sum=0;
        for(int i=0;i<words.length;i++){
            if(i<words.length-1&&words[i+1].endsWith(words[i]));
            else sum+=words[i].length()+1;
        }
        return sum;
    }

    public int minimumLengthEncodingByTrie(String[] words) {
        int length=0;
        Trie trie=new Trie();
        Arrays.sort(words,((o1, o2) -> o2.length()-o1.length()));
        for(String word:words){
            if(!trie.findIn(word)){
                trie.insert(word);
                length+=word.length()+1;
            }
        }
        return  length;
    }
    class Trie{
        char val;
        Trie[] childrens=new Trie[26];
        public void insert(String words){
            Trie curr=this;
            char[] chars = words.toCharArray();
            for(int i=chars.length-1;i>-1;i--){
                 if(curr.childrens[chars[i]-'a']==null){
                     Trie trie=new Trie();
                     curr.childrens[chars[i]-'a']=trie;
                 }
                 curr=curr.childrens[chars[i]-'a'];
            }
        }
        public boolean findIn(String words){
            Trie curr=this;
            char[] chars = words.toCharArray();
            for(int i=chars.length-1;i>-1;i--){
                if(curr.childrens[chars[i]-'a']==null){
                    return false;
                }
                curr=curr.childrens[chars[i]-'a'];
            }
            return true;
        }
    }
}
