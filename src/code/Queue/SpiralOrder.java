package code.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SpiralOrder
 * 类 描 述：TODO 力扣题54 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 * 创建时间：2022/10/17 下午8:02
 * 创 建 人：chenweihua
 */
public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0) return result;
        //左边界
        int left = 0;
        //右边界 即列数
        int right = matrix[0].length - 1;
        //上边界
        int top = 0;
        //下边界，即行数
        int bottom = matrix.length - 1;
        //矩阵内元素个数
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            //将第一行全部加入到集合中
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            //到第二行
            top++;
            //从第二行最后一列元素开始一直到最后一行
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            //最后一行倒数第二列
            right--;
            //最后一行倒数第二列到最后一行第一列
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            //倒数第二行第一列
            bottom--;
            //倒数第二行第一列到第二行第一列
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            //第一轮循环将最外层全部消除
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] num = {{1,2,3},{4,5,6},{7,8,9}};
        ;
        for (int i = 0; i < 9 ; i++) {
            System.out.println(spiralOrder(num).get(i));
        }

    }


}
