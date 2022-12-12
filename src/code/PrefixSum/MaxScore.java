package code.PrefixSum;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MaxScore
 * 类 描 述：TODO 力扣题1423
 * 创建时间：2022/12/4 下午2:52
 * 创 建 人：chenweihua
 */
public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, len = n - k;
        int cur = 0, res = 0, sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        for (int i = 0; i < len; ++i) {
            cur += cardPoints[i];
        }
        int min = cur;
        for (int i = len; i < cardPoints.length; i++) {
            cur += cardPoints[i] - cardPoints[i - len];
            Math.min(min, cur);
        }
        return sum - min;
    }
}
