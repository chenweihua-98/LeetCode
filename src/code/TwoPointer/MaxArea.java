package code.TwoPointer;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MaxArea
 * 类 描 述：TODO 力扣题11 盛最多水的容器
 * 创建时间：2022/12/5 下午3:15
 * 创 建 人：chenweihua
 */
public class MaxArea {
    public int maxArea(int[] height) {
        //定义双指针
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
