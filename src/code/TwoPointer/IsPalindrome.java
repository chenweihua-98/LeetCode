package code.TwoPointer;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：IsPalindrome
 * 类 描 述：TODO 力扣题125 验证回文串
 * 创建时间：2022/11/11 下午2:21
 * 创 建 人：chenweihua
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        //将字符串全部小写 放到char数组中
        char[] c = s.toLowerCase().toCharArray();
        int i =0, j=c.length-1;
        while(i<=j){
            //检查是否数字字母
            while(!isValid(c[i])&&i<j){
                ++i;
            }
            //检查是否数字字母
            while(!isValid(c[j])&&i<j){
                --j;
            }
            if(c[i]!=c[j]){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    //验证是否是数字或者字母
    private boolean isValid(char c){
        return (c>='a'&&c<='z')||(c>='0'&&c<='9');
    }

}
