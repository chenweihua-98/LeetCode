package code.Sort;

import java.util.Arrays;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Merge
 * 类 描 述：TODO 力扣题56 合并区间
 * 创建时间：2022/11/19 下午2:38
 * 创 建 人：chenweihua
 */
public class Merge {

    public int[][] merge(int[][] intervals){
        //按照区间起始位置排序
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        //遍历区间
        int [][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            //如果结果数组是空的或者当前区间的起始位置>结果数组中最后区间的终止位置
            //不合并，直接将当前区间加入结果数组
            if(idx==-1||interval[0]>res[idx][1]){
                res[++idx] = interval;
            }else{
                //反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,idx+1);
    }

}
