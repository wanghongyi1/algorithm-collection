package TestUtil.哈希表.异位词;

import java.util.*;

/**
 * @author:why
 * @create: 2022-06-01 15:27
 * @Description:
 */
public class Main {
    /*
        242. 有效的字母异位词
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

        注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     */
    public boolean isAnagram(String s, String t) {
        int[] hash=new int[26];
        for (char c : s.toCharArray()) {
            hash[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            hash[c-'a']--;
        }
        for(int i=0;i<26;++i){
            if(hash[i]!=0){
                return false;
            }
        }
        return true;
    }

    /*
        383. 赎金信
        给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        如果可以，返回 true ；否则返回 false 。
        magazine 中的每个字符只能在 ransomNote 中使用一次
     */
    public boolean canConstruct(String t, String s) {
        int[] hash=new int[26];
        for (char c : s.toCharArray()) {
            hash[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            hash[c-'a']--;
        }
        for(int i=0;i<26;++i){
            if(hash[i]<0){
                return false;
            }
        }
        return true;
    }
    /*
        49. 字母异位词分组-->找相同特征做key
        给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
        字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /*
        438. 找到字符串中所有字母异位词-》滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> p_map=new HashMap<>();
        for (char c : p.toCharArray()) {
            p_map.put(c,p_map.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int valid=0;
        Map<Character,Integer> window=new HashMap<>();
        char[] ss = s.toCharArray();
        List<Integer> list=new ArrayList<>();
        while(right<s.length()){
            window.put(ss[right],window.getOrDefault(ss[right],0)+1);
            if(window.get(ss[right]).equals(p_map.get(ss[right]))){
                valid++;
            }
            while(right-left+1>=p.length()){
                if(valid==p_map.size()){
                    list.add(left);
                }
                if(window.get(ss[left]).equals(p_map.get(ss[left]))){
                    valid--;
                }
                window.put(ss[left],window.get(ss[left])-1);
                left++;
            }
            right++;
        }
        return list;
    }
    /*
        349. 两个数组的交集
        给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        return  set.stream().mapToInt(Integer::intValue).toArray();
    }
    /*
        202. 快乐数
        编写一个算法来判断一个数 n 是不是快乐数。
        「快乐数」 定义为：
        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     */
    public static void main(String[] args) {
        isHappy(19);
    }
    public static boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n=getNext(n);
        }
        return true;
    }
    public static int getNext(int n){
        int sum=0;
        while(n!=0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}
