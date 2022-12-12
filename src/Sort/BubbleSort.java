package Sort;

/**
        时            空       稳定
 选择   O(N平方)       O(1)     否
 冒泡   O(N平方)       O(1)     是
 插入   O(N平方)       O(1)     是
 归并   O(N*logN)     O(N)     是
 堆     O(N*logN)     O(1)     否
 快速   O(N*logN)     O(logN)  否
 桶系列   O(N)         O(N)     是

 不追求稳定，追求时间，选快排，常数时间最短
 不追求稳定，追求空间，选堆排序
 追求稳定，选归并

*/
/**
 * 项目名称：leetcodeDemo
 * 类 名 称：BubbleSort
 * 类 描 述：TODO 冒泡排序 从小到大排序
 * 创建时间：2022/9/19 下午8:52
 * 创 建 人：chenweihua
 *
 */
public class BubbleSort {



    public static int[] bubbleSort(int[] num){
        if(num.length<2||num==null){
            return num;
        }
        for (int i = 0; i <num.length-1 ; i++) {
            for (int j = 0; j < num.length-1-i; j++) {
                //01 12 23 ... 比较 一直把一行中最大的放到集合最后
                if (num[j]>num[j+1]){
                    swap(j,j+1,num);
                }
            }
        }
        return num;
    }

    private static void swap(int i, int j, int[] num) {
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }

    public static void main(String[] args) {
        int [] num = {1,4,6,2,8,9,18,13,20};
        bubbleSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }


}
