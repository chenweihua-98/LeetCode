package code.Stack;

import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：IsValid
 * 类 描 述：TODO 力扣题20
 * 创建时间：2022/11/25 上午10:28
 * 创 建 人：chenweihua
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        return stack.empty();
    }
}
