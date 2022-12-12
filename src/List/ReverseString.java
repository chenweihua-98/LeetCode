package List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ReverseString
 * 类 描 述：TODO 力扣题344 反转字符串
 * 创建时间：2022/11/6 下午8:57
 * 创 建 人：chenweihua
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
