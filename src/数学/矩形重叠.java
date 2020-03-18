package 数学;

/**
 * @ClassName： 矩形重叠
 * @description:
 * @author: lisheng
 * @create: 2020-03-18 08:42
 **/
public class 矩形重叠 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2]<=rec2[0]||rec1[0]>=rec2[2]||rec1[1]>=rec2[3]||rec1[3]<=rec2[1]);
    }
}
