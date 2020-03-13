import java.util.Arrays;

/**
 * @ClassName： KMP算法
 * @description:
 * @author: lisheng
 * @create: 2020-03-07 14:17
 **/
public class KMP算法 {
    public  int strStrByKMP(String haystack, String needle){
        if(needle.length()==0)return 0;
        if(needle.length()>haystack.length())return -1;
        int[] next=new int[needle.length()];
        getNext(next,needle);
        int i=0;
        int pIndex=0;
        //从第0位开始与p串的第0位开始比
        //如果相同  如果已经满了  返回这个i 如果没满 各+1位继续比较
        //如果不同
        //   j==0的话i++退出二次循环
        //     else i不变 j取next对应值，重新比较
        B:while (pIndex<needle.length()&&i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(pIndex)){
                if(pIndex+1==needle.length())return i-pIndex;
                i++;pIndex++;
            }else{
                if(pIndex==0){i++;}
                else{pIndex=next[pIndex-1];};
            }
        }

        return -1;
    }
    //next算法 求最大公共长度
    public void getNext(int []next,String p){
        for(int i=0;i<next.length;i++){
            int start=i-1;
            int end=i;
            while(start>=0){
                if(p.charAt(end)==p.charAt(start)){
                    start--;
                    end--;
                }else{
                    if(end!=i){
                        end=i;
                    }else {
                        start--;
                    }
                }
            }
            next[i]=i-end;
        }
    }
    public int strStr(String haystack, String needle) {

        if(needle.length()<1)return 0;
        if(needle.length()>haystack.length())return -1;
        int i=0;
        A:while (i<haystack.length()){
            int j=0;
            needle:while (j<needle.length()&&i<haystack.length()){
                if(haystack.charAt(i)==needle.charAt(j)){
                    if(j==needle.length()-1)return i-needle.length()+1;
                    i++;j++;continue;
                }
                //不回退这么几步 由于退出的错误是重复needle的一部分会导致结果出错
                //mississisp issisp
                i=i-j;
                break needle;
            }
            i++;
        }
        return -1;
    }


    public static void main(String[] args) {
        KMP算法 kmp=new KMP算法();

        String issip = "ABABAA";
        int i = kmp.strStrByKMP("mississisp", "issisp");
        System.out.println(i);
    }

}
