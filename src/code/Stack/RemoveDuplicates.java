package code.Stack;

import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：RemoveDuplicates
 * 类 描 述：TODO 力扣题1209 删除字符串相邻重复项
 * 创建时间：2022/10/25 下午3:56
 * 创 建 人：chenweihua
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();

        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int num = counts.pop() + 1;
                if (num == k) {
                    //delete()开始的数删，结束的数不删
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(num);
                }
            }
        }

        return sb.toString();


    }


}
