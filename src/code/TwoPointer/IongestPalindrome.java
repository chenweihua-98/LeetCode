package code.TwoPointer;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：IongestPalindrome
 * 类 描 述：TODO 力扣题409 最长回文串
 * 创建时间：2022/11/12 下午7:41
 * 创 建 人：chenweihua
 */
public class IongestPalindrome {
    public int longestPalindrome(String s) {
        // 找出可以构成最长回文串的长度 ASCII共收录了128个字符
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
