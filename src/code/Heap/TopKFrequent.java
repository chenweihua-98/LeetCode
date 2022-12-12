package code.Heap;

import java.util.*;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：TopKFrequent
 * 类 描 述：TODO 力扣题347 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 *          你可以按 任意顺序 返回答案。1.快排 2.堆
 * 创建时间：2022/11/1 下午5:04
 * 创 建 人：chenweihua
 */
public class TopKFrequent {


    public static int[] topKFrequentHeap(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((num1,num2)->{
            return num1[1]-num2[1];
        });

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey(),count = entry.getValue();
            if(queue.size()==k){
                if (queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }

        int[] res = new int[k];
        int index = -1;
        while (!queue.isEmpty()){
            res[++index] = queue.poll()[0];
        }

        return res;


    }

    public static int[] topKFrequentQuickSort(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    //快速排序算法
    public static void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }


}
