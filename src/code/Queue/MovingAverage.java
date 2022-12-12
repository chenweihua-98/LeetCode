package code.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MovingAverage
 * 类 描 述：TODO 346数据流中的移动平均值
 * 创建时间：2022/11/22 下午9:50
 * 创 建 人：chenweihua
 */
public class MovingAverage {

    Queue<Integer> queue;
    double sum;
    int size;

    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
        sum=0;
    }

    public double next(int val) {
        if(queue.size()==size){
            sum-=queue.poll();
        }
        queue.offer(val);
        sum+=val;
        return sum/queue.size();
    }






}
