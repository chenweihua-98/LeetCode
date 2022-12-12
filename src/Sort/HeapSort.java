package Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：HeapSort
 * 类 描 述：TODO 基于堆的堆排序 堆的结构是完全二叉树结构 堆排序在时间复杂度上具有优势O(N*logN)
 * 创建时间：2022/9/24 下午12:50
 * 创 建 人：chenweihua
 */

/**
 * 将堆构造成大根堆 在形式上父节点大于所有子节点，该节点位置i，则其父亲节点位置（i-1)/2
 * 子左孩子位置i*2+1,子右孩子i*2+2 升序用大根堆 降序用小根堆
 */


public class HeapSort {

    //O(N*logN)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //O(N*logN)
        //保证此时数组中的最大值在arr[0]位置,每一次加入数据调整堆为大根堆
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }
        //如果直接给一个数组，可使用如下代码将其变成大根堆 O(N)
        // for(int i = arr.length -1; i >=0; i--) {
        // heapify(arr, i, arr.length);
        // }
        //O(N*logN)
        //有效区为数组长度
        int heapSize = arr.length;
        //将数组最后一位与第一位[0]位置互换，即已经将该数组最大值放在最后，将有效区减一，使最大值不再进入堆,且该值位于数组最后一位
        swap(arr, 0, --heapSize);
        //有效区还存在着数,将刚刚换上来的数进行heapify，看是否能向下，即判断该值是否是当前堆中最大值
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize); // O(1)
        }
    }


    //某个数在index位置，能否往下移动，即判断index点是否是heapsize堆中数值最大的点
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; //index左孩子的位置
        while (left < heapSize) { //index下方还存在着孩子
            //index两个孩子,哪个孩子的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //index和较大的孩子之间，值大的坐标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //arr[0到index-1]都是大根堆，某个数现在处于index位置，不断向上移动，使得arr[0到index]都是大根堆
    //一个新的数加入堆后不断比较他的父节点，往上移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {//直到index来到0位置或者index小于他的父位置
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] num = {1,7,8,10,4,6,2};
        heapSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

}
