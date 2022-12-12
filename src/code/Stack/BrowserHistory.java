package code.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：BrowserHistory
 * 类 描 述：TODO 力扣题1472 设计浏览器历史记录
 * 创建时间：2022/10/25 下午2:44
 * 创 建 人：chenweihua
 */
public class BrowserHistory {

    Stack<String> stack;
    Stack<String> history;
    public BrowserHistory(String homepage) {
        stack = new Stack<String> ();
        history = new Stack<String> ();
        stack.push(homepage);
    }

    public void visit(String url) {
        stack.push(url);
        while(!history.empty()){
            history.pop();
        }
    }

    public String back(int steps) {
        for(int i =0;i<steps&&stack.size()>1;++i){
            history.push(stack.pop());
        }
        return stack.peek();
    }

    public String forward(int steps) {
        for(int i =0;i<steps&&!history.empty();++i){
            stack.push(history.pop());
        }
        return stack.peek();
    }


}
