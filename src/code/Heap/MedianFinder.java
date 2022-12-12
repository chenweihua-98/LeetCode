package code.Heap;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.PriorityQueue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MedianFinder
 * 类 描 述：TODO 力扣题295 数据流的中位数
 * 创建时间：2022/11/5 下午4:39
 * 创 建 人：chenweihua
 */
public class MedianFinder {
     static PriorityQueue<Integer> l;
     static PriorityQueue<Integer> r;

    public static void MedianFinder() {
        //左半边大根堆
        l = new PriorityQueue<Integer>((a, b) -> (b - a));
        //右半边小根堆
        r = new PriorityQueue<Integer>((a, b) -> (a - b));
        // 传入的数目为奇数时 保证左半边根堆数比右半边多1 返回左半边的peek值 当传入的数目是偶数时 左右半边数目相等 返回左右半边peek值的平均数
    }

    public static void addNum(int num) {
        //此时左右半边数目相等 加入一个数后需要保证左半边数目比右半边数目多1
        if(l.size()==r.size()){
            if(l.isEmpty()||num<r.peek()){
                l.offer(num);
            }else{
                l.offer(r.poll());
                r.offer(num);
            }
        }else{
            //此时左半边数目比右半边多一个 加入一个数 使左右两边相等
            if(num>l.peek()){
                r.offer(num);
            }else{
                r.offer(l.poll());
                l.offer(num);
            }
        }
    }

    public static double findMedian() {
        if (l.size() > r.size()) {
            return l.peek();
        }
        return (l.peek() + r.peek()) / 2.0;
    }



}
