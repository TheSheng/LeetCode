package 数组;

/**
 * @ClassName： 和相等的三个部分
 * @description:
 * @author: lisheng
 * @create: 2020-03-11 08:30
 **/
public class 和相等的三个部分 {
    public static boolean canThreePartsEqualSum(int[] A) {
        if(A.length<3)return  false;
          int pointerA=0;
          int sumA=0;
          int sumB=0;
          int sumC=0;
          for(int num:A)sumC+=num;
          while (pointerA<A.length){
              sumA=sumA+A[pointerA];
              int pointerB=pointerA+1;
              while (pointerB<A.length-1){
                  sumB=sumB+A[pointerB];
                  int thisSumC=sumC-sumA-sumB;
                  if(sumA==sumB&&sumB==thisSumC)return true;
                  pointerB++;
              }
              sumB=0;
              pointerA++;
          }
          return false;
    }

    //官方解答 先求出总和 两个指针分别使每部分的和等于sum/3
    public static boolean canThreePartsEqualSum2(int[] A) {
        if(A.length<3)return  false;
        int sum=0;
        for(int num:A)sum+=num;
        if(sum%3!=0)return false;
        int pointA=0;
        int sumA=0;
        while (pointA<A.length-2){
            sumA+=A[pointA];
            if(sumA==sum/3){
                int pointB=pointA+1;
                int sumB=0;
                while (pointB<A.length-1){
                    sumB+=A[pointB];
                    if(sumB==sum/3)return true;
                    pointB++;
                }
            }
            pointA++;
        }
        return false;
    }


    public static void main(String[] args) {
        canThreePartsEqualSum2(new int[]{3,3,6,5,-2,2,5,1,-9,4});
    }
}
