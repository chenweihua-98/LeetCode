package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SearchMatrix
 * 类 描 述：TODO 力扣题74 搜索二维矩阵
 * 创建时间：2022/11/9 下午8:06
 * 创 建 人：chenweihua
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int temp = 0;
        for (int i = 0; i < m; ++i) {
            temp = search(matrix[i], target);
            if (temp != -1) break;
        }
        return temp != -1 ? true : false;
    }


    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

}
