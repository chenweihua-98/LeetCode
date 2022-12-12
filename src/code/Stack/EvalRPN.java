package code.Stack;

import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：evalRPN
 * 类 描 述：TODO 力扣题150逆波兰表达式求值
 * 创建时间：2022/10/19 下午3:03
 * 创 建 人：chenweihua
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String item : tokens) {
            if ("+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item)) {
                int p1 = stack.pop();
                int p2 = stack.pop();
                if ("+".equals(item)) stack.push(p2+p1);
                else if ("-".equals(item)) stack.push(p2-p1);
                else if ("*".equals(item)) stack.push(p2*p1);
                else if ("/".equals(item)) stack.push(p2/p1);
            } else {
                stack.push(Integer.valueOf(item));
            }
        }
        return stack.peek();
    }

}
