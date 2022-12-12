package util;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：OddTimesNum
 * 类 描 述：TODO
 * 创建时间：2022/9/20 下午8:55
 * 创 建 人：chenweihua
 */
public class OddTimesNum {

    //两个数异或 即在2进制下不进位相加 0与其他数相加均为其他数 多个数异或则看该位置上有奇数个1还是偶数个1 自己与自己异或为0

    //假设现在存在一个数组，只有一种数出现了奇数次，其他数都出现了偶数次，找出那个数，可利用异或性质，将所有数进行异或，最后留下的即为所求值
    public static int OddTimesNum1(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^=arr[i];
        }
        return res;
    }

    public void da(){
        System.out.println("commit");
    }

    //假设现在存在一个数组，有两种数出现了奇数次，找出那两个数,将所有数相加得到的数为a^b,且因为ab不相同，所以将这个数用2二进制表示必有至少一个位置上是1
    public static void  OddTimesNum2(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^=arr[i]; //res = a ^ b
        }
        //提取出res这个数二进制最右侧的1，其他位置全为0 一个数与上自己的取反加一就是将二进制后的自己的最右侧的1提取出来
        int rightOne = res &(~res+1);
        int res2 = 0;
        for (int i : arr) {
            //将该位上为1的数从数组中全部找出来，因为偶数个自己异或为0，该位为1，异或后偶数的其他数消去，剩下的就是a或者b
            if ((i&rightOne)!=0){
                res2 ^= i; // res2 为 a 或 b
            }
        }

        System.out.println(res2 +" "+(res2^res));





    }

    public static void main(String[] args) {

        int[] arr = {1,1,1,3,3,6,6,8,8,9,9,2,2,2};

        OddTimesNum2(arr);



    }





}
