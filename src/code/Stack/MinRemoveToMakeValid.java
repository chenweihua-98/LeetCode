package code.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MinRemoveToMakeValid
 * 类 描 述：TODO 力扣题1249 移除无效的括号
 * 创建时间：2022/10/25 下午4:47
 * 创 建 人：chenweihua
 */
public class MinRemoveToMakeValid {


    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        //去掉多余的')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                sb.append(c);
            } else if (c == ')') {
                if (count < 1) {
                    count = 0;
                } else {
                    count--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        //去掉多余的'('
        int num = sb.length() - 1;
        while (count != 0) {
            if (sb.charAt(num)=='('){
                count--;
                sb.deleteCharAt(num);
            }
            num--;
        }
        return sb.toString();
    }
}
