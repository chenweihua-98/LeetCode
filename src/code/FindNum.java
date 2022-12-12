package code;

import java.util.Scanner;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FindNum
 * 类 描 述：TODO 需要输入一个n，一个数k，然后输入一个长度为n个大小的数组arr，然后你需要在arr上找满足>=K的最左位置，并且输出这个位置，如果不存在这个位置就输出-1。
 * 创建时间：2022/9/22 下午3:58
 * 创 建 人：chenweihua
 */
public class FindNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int num = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findNum(arr,num)) ;
    }





    //利用二分的思想
    public static int  findNum(int[] arr , int num){

        int R = arr.length;
        int L = 0;

        while (L<R){

            int mid =L+((R-L)>>1);
            if (num<=arr[mid]){
                if ((mid-1)>=0&&arr[mid-1]>=num) {
                    R = mid;
                }else{
                    return arr[mid] ==num? mid:-1;
                }
            }else{
                L = mid+1;
            }




        }

        return -1;


    }






}
