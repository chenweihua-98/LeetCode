import Sort.QuickSort;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.beans.Transient;
import java.util.Arrays;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：TestCode
 * 类 描 述：TODO
 * 创建时间：2022/9/28 上午10:10
 * 创 建 人：chenweihua
 */
public class TestCode {



    //冒泡排序
    public void BubbleSort(int[] arr){
        
    }


    //快速排序




    //归并排序



    @Test
    public void TestBubble(){
        int[] arr = new int[]{1,5,6,7,3,4,0};
        //BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void TestQuick(){
        int[] arr = new int[]{1,5,6,7,3,4,0};
        //Quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void TestMerge(){
        int[] arr = new int[]{1,5,6,7,3,4,0};
        //MergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }






    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }





}
