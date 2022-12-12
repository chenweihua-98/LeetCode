package code.Heap;

import java.util.Arrays;
import java.util.Random;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：kClosest
 * 类 描 述：TODO 力扣题973 最接近原点的第k个点 1.直接调用排序方法 2.快速排序 3.大根堆
 * 创建时间：2022/10/31 下午11:09
 * 创 建 人：chenweihua
 */
public class kClosest {
    
    Random random = new Random();

    //使用快速排序的方法
    public int[][] kClosest(int[][] points,int k ){
        int n =points.length;
        random_select(points,0,n-1,k);
        return Arrays.copyOfRange(points,0,k);
    }

    //参考快速排序
    private void random_select(int[][] points, int left, int right, int k) {
            int pivotId = left +random.nextInt(right-left+1);
            //int pivotId = (int)Math.random()*(right-left+1)+left;
            int pivot = points[pivotId][0]*points[pivotId][0]+points[pivotId][1]*points[pivotId][1];
            swap(points,right,pivotId);
            int i = left-1;
            for(int j = left;j<right;++j){
                int dist = points[j][0]*points[j][0]+points[j][1]*points[j][1];
                if (dist<=pivot){
                    swap(points,++i,j);
                }
            }
            swap(points,++i,right);
            //如果 k<i−left+1，那么说明第k个距离最小的点在pivot左侧
            if(k<i-left+1){
                random_select(points,left,i-1,k);
            }else{
                random_select(points,i+1,right,k-(i-left+1));
            }
    }

    public void swap(int[][]arr,int num1,int num2){
        int[] temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    //直接用sort排序方法
    public int[][] kClosestSort(int[][] points,int k ){
        Arrays.sort(points,(p1,p2)->{
            return p1[0]*p1[0]+p1[1]*p1[1]-p2[0]*p2[0]-p2[1]*p2[1];
        });
        return Arrays.copyOfRange(points,0,k);
    }


}
