package TestUtil.动态规划.回文子串.回文子序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:why
 * @create: 2022-05-29 16:58
 * @Description:
 */
public class Main {
    /*
        1930. 长度为 3 的不同回文子序列--->找规律
        给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
        即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
        回文 是正着读和反着读一样的字符串。
        子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
        例如，"ace" 是 "abcde" 的一个子序列。
     */
    public int countPalindromicSubsequence(String s) {
        int count=0;
        for(char c='a';c<='z';++c){
            int left=0;
            int right=s.length()-1;
            while(left<s.length()&&s.charAt(left)!=c){
                left++;
            }
            while(right>=0&&s.charAt(right)!=c){
                right--;
            }
            if(right-left<2){
                continue;
            }
            Set<Character> set=new HashSet();
            for(int i=left+1;i<=right-1;++i){
                set.add(s.charAt(i));
            }
            count+=set.size();
        }
        return count;
    }


}
