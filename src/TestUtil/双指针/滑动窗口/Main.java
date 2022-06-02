package TestUtil.双指针.滑动窗口;

import java.util.*;

/**
 * @author:why
 * @create: 2022-05-31 11:09
 * @Description: 滑动窗口
 * 特征，right++保证最终值增大，left++能保证目标值减小
 */
public class Main {
    /*
            76最小覆盖子串
            给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     */
    public String minWindow(String s, String t) {
        Map<Character,Integer> t_map=new HashMap<>();
        for (char c : t.toCharArray()) {
            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }
        char[] ss = s.toCharArray();
        int left=0;
        int right=0;
        Map<Character,Integer> window=new HashMap<>();
        int valid=0;
        int leftMin= Integer.MAX_VALUE;
        int minLen=Integer.MAX_VALUE;
        while(right<ss.length){
            window.put(ss[right],window.getOrDefault(ss[right],0)+1);
            if(window.get(ss[right]).equals(t_map.get(ss[right]))){
                valid++;
            }
            while(valid==t_map.size()) {
                System.out.println(left+":"+right);
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    leftMin=left;
                }
                if(window.get(ss[left]).equals(t_map.get(ss[left]))){
                    valid--;
                }
                window.put(ss[left],window.get(ss[left])-1);
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(leftMin,leftMin+minLen);
    }

    /*
        567 字符串的排列
        给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
        换句话说，s1 的排列之一是 s2 的 子串 。
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> s1_map=new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1_map.put(c, s1_map.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window=new HashMap<>();
        int left=0;
        int right=0;
        char[] ss2 = s2.toCharArray();
        int valid=0;
        while(right<s2.length()){
            window.put(ss2[right],window.getOrDefault(ss2[right],0)+1);
            if(window.get(ss2[right]).equals(s1_map.get(ss2[right]))){
                valid++;
            }
            while(right-left+1>s1.length()){
                if(window.get(ss2[left]).equals(s1_map.get(ss2[left]))){
                    valid--;
                }
                window.put(ss2[left],window.get(ss2[left])-1);
                left++;
            }
            if(valid==s1_map.size()){
                return true;
            }
            right++;
        }
        return false;
    }

    /*
        438. 找到字符串中所有字母异位词
        给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> s1_map=new HashMap<>();
        for (char c : p.toCharArray()) {
            s1_map.put(c, s1_map.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window=new HashMap<>();
        int left=0;
        int right=0;
        char[] ss2 = s.toCharArray();
        int valid=0;
        while(right<s.length()){
            window.put(ss2[right],window.getOrDefault(ss2[right],0)+1);
            if(window.get(ss2[right]).equals(s1_map.get(ss2[right]))){
                valid++;
            }
            while(right-left+1>=p.length()){
                if(valid==s1_map.size()){
                    res.add(left);
                }
                if(window.get(ss2[left]).equals(s1_map.get(ss2[left]))){
                    valid--;
                }
                window.put(ss2[left],window.get(ss2[left])-1);
                left++;
            }
            right++;
        }
        return res;
    }

    /*
        3.无重复字符的最长字串
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        int left=0;
        int right=0;
        int len=Integer.MIN_VALUE;
        HashMap<Character,Integer> window=new HashMap<>();
        while(right<ss.length){
            window.put(ss[right],window.getOrDefault(ss[right],0)+1);
            while(window.get(ss[right])>1){
                window.put(ss[left],window.get(ss[left])-1);
                left++;
            }
            len=Math.max(len,right-left+1);
            ++right;
        }
        return len==Integer.MIN_VALUE?0:len;
    }
}
