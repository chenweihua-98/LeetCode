package code.Heap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ReorganizeString
 * 类 描 述：TODO 力扣题767 重构字符串
 * 创建时间：2022/11/30 上午11:18
 * 创 建 人：chenweihua
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] alphabetCount = new int[26];
        char[] alphabetArray = s.toCharArray();
        int length = s.length(),max=0,threshold=(length+1)>>1,alphabet=0;
        for(int i = 0;i<length;++i){
            alphabetCount[alphabetArray[i]-'a']++;
            if (alphabetCount[alphabetArray[i]-'a']>max){
                max = alphabetCount[alphabetArray[i]-'a'];
                alphabet = alphabetArray[i]-'a';
                if (max>threshold){
                    return "";
                }
            }
        }
        int index = 0;
        char[] res = new char[length];
        while (alphabetCount[alphabet]-->0){
            res[index] = (char)(alphabet+'a');
            index+=2;
        }

        for(int i = 0;i<alphabetCount.length;++i){
            while (alphabetCount[i]-->0){
                if (index>=res.length){
                    index = 1;
                }
                res[index] = (char)(i+'a');
                index+=2;
            }
        }
        return new String(res);
    }
}
