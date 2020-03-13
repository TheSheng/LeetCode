package 二分查找;

import java.util.*;

/**
 * @ClassName： 两个数组的交集
 * @description:
 * @author: lisheng
 * @create: 2020-03-05 09:11
 **/
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1=new HashSet<>();
            for(int num:nums1)set1.add(num);
            Set<Integer> set2=new HashSet<>();
            for(int num:nums2)set2.add(num);
            set1.retainAll(set2);
        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int num:nums1)set1.add(num);
        Set<Integer> set2=new HashSet<>();
        for(int num:nums2)set2.add(num);
        set1.retainAll(set2);
        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }

    public static void main(String[] args) {
        Integer [] a={1,2,3,4,5};
        List<Integer> arrayList = Arrays.asList(a);
        arrayList.add(1);
    }
}
