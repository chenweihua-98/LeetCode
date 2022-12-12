package code.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FreqStack
 * 类 描 述：TODO 力扣题895 最大频率栈
 * 创建时间：2022/12/1 下午9:55
 * 创 建 人：chenweihua
 */
public class FreqStack {
    HashMap<Integer,Integer> map;
    PriorityQueue<int[]> queue;
    int idx=0;
    public FreqStack() {
        map = new HashMap<>();
        queue = new PriorityQueue<>((a,b)->{
           return a[2]==b[2]?b[1]-a[1]:b[2]-a[2];
        });
    }

    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        queue.offer(new int[]{val,idx++,map.get(val)});
    }

    public int pop() {
        int res =queue.poll()[0];
        map.put(res,map.get(res)-1);
        return res;
    }
}
