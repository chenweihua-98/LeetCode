package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FindInMountainArray
 * 类 描 述：TODO 力扣题1095山脉数组中查找目标值
 * 创建时间：2022/11/10 上午11:00
 * 创 建 人：chenweihua
 */
public class FindInMountainArray {


    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        if (n < 3) {
            return -1;
        }
        //找到山脉山峰 分成两段，左边递增，右边递减
        int m = findPeakElement(mountainArr);
        //对左递增做二分查找
        int res1 = binary_search(mountainArr, target, m, 0);
        //对右递减做二分查找
        int res2 = binary_search2(mountainArr, target, n - 1, m + 1);

        return res1 != -1 ? res1 : res2;

    }

    public int binary_search(MountainArray mountainArr, int target, int right, int left) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else if (mountainArr.get(mid) == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    public int binary_search2(MountainArray mountainArr, int target, int right, int left) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else if (mountainArr.get(mid) == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    public int findPeakElement(MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    //为了不报错瞎写的
    class MountainArray {
        int length() {
            return 1;
        }

        int get(int a) {
            return 1;
        }
    }


}



