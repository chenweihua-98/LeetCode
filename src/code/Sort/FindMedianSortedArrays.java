package code.Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FindMedianSortedArrays
 * 类 描 述：TODO 力扣题4 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。算法的时间复杂度应该为 O(log (m+n)
 * 创建时间：2022/10/14 上午10:54
 * 创 建 人：chenweihua
 */
public class FindMedianSortedArrays {

    //不是很懂   ？？？
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int leftMiddle = (num1.length + num2.length + 1) / 2;
        int rightMiddle = (num1.length + num2.length + 2) / 2;
        double left = getKth(num1, num2, 0, 0, leftMiddle);
        double right = getKth(num1, num2, 0, 0, rightMiddle);
        return (left + right) / 2;
    }

    public double getKth(int[] num1, int[] num2, int left1, int left2, int k) {
        if (left1 >= num1.length) {
            return num2[left2 + k - 1];
        }
        if (left2 >= num2.length) {
            return num1[left1 + k - 1];
        }

        if (k == 1) {
            int nums1 = num1[left1 + k - 1];
            int nums2 = num2[left2 + k - 1];
            return Math.min(nums1, nums2);
        }

        int elementNum = k / 2;
        int loc1 = left1 + elementNum - 1;
        int loc2 = left2 + elementNum - 1;

        if (loc1>=num1.length){
            loc1 = num1.length-1;
        }
        if (loc2>=num2.length){
            loc2 = num2.length-1;
        }

        if (num1[loc1]<num2[loc2]){
            return getKth(num1,num2,loc1+1,left2,k-(loc1-left1+1));
        }
        return getKth(num1,num2,left1,loc2+1,k-(loc2-left2+1));
    }


}
