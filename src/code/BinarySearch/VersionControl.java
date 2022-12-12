package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：VersionControl
 * 类 描 述：TODO 力扣题278 第一个错误的版本
 * 创建时间：2022/11/9 下午9:18
 * 创 建 人：chenweihua
 */
public class VersionControl {
    public int firstBadVersion(int n) {
        if(n<=1){
            return n;
        }
        int l = 1,r=n;
        while(l<=r){
            int mid = l+((r-l)>>1);
            if(isBadVersion(mid)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    public boolean isBadVersion(int n){
        return true;
    }

}
