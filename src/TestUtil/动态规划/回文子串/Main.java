package TestUtil.动态规划.回文子串;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:why
 * @create: 2022-05-28 21:59
 * @Description: 回文
 * 动态规划-》子序列
 * 中心扩展-》双指针
 * 回溯-》回文串分割
 * 回文字符串特性-》偶数，奇数
 * 回文跟构建回文串
 */
public class Main {

    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        int flag=0;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return valid(s,left,right-1)||valid(s,left+1,right);
            }
        }
        return true;
    }
    public boolean valid(String s,int left,int right){
        while(left<right&&s.charAt(left)==s.charAt(right)){
            left++;
            right--;
        }
        return true;
    }

    /*
        剑指 Offer II 018. 有效的回文
        给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
        本题中，将空字符串定义为有效的 回文串 。
    */
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(!(s.charAt(left)>='0'&&s.charAt(left)<='9'||s.charAt(left)>='a'&&s.charAt(left)<='z')){
                left++;
                continue;
            }
            if(!(s.charAt(right)>='0'&&s.charAt(right)<='9'||s.charAt(right)>='a'&&s.charAt(right)<='z')){
                right--;
                continue;
            }
            if(left<right&&s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        StringBuilder sb=new StringBuilder();

        return true;
    }
    public static boolean isPalindrome2(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            while(left<right&& !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right&& !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left<right){
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }

        }
        return true;
    }

    /*
        647. 回文子串
        给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
        回文字符串 是正着读和倒过来读一样的字符串。
        子字符串 是字符串中的由连续字符组成的一个序列。
        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();++i){
            count+=countSubstrings(s,i,i);
            count+=countSubstrings(s,i,i+1);
        }
        return count;
    }

    private int countSubstrings(String s, int l, int r) {
        int left=l;
        int right=r;
        int count=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }

    /*
        5. 最长回文子串
        给你一个字符串 s，找到 s 中最长的回文子串。
     */
    public String longestPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();++i){
            String s1=countSubstrings2(s,i,i);
            String s2=countSubstrings2(s,i,i+1);
            if(s1.length()>res.length()){
                res=s1;
            }
            if(s2.length()>res.length()){
                res=s2;
            }
        }
        return res;
    }
    private String countSubstrings2(String s, int l, int r) {
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            --l;
            ++r;
        }
        return s.substring(l+1,r);
    }

    /*
        516.最长回文子序列--》简单方法（字符串反转，再最长公共子序列）
        给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
        子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     */
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        int[][] dp=new int[m][m];
        for(int i=0;i<m;++i){
            dp[i][i]=1;
        }
        for(int i=m-1;i>=0;--i){
            for(int j=i+1;j<m;++j){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][m-1];

    }
    public int longestPalindromeSubseq2(String s) {
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        int len=s.length();
        int[][] dp=new int[len+1][len+1];
        for(int i=1;i<=len;++i){
            for(int j=1;j<=len;++j){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*
        剑指 Offer II 027. 回文链表
        给定一个链表的 头节点 head ，请判断其是否为回文链表。
        如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode halfSecond=reverseList(slow.next);
        ListNode q=halfSecond;
        ListNode p=head;
        boolean result=true;
        while(q!=null&&p!=null){
            if(p.val!=q.val){
                result=false;
                break;
            }
            q=q.next;
            p=p.next;
        }
        slow.next=reverseList(halfSecond);
        return result;
    }

    private ListNode reverseList(ListNode slow) {
        ListNode pre=null;
        ListNode p=slow;
        ListNode temp;
        while(p!=null){
            temp=p;
            p=p.next;
            temp.next=pre;
            pre=temp;
        }
        return pre;
    }
    /*
        面试题 01.04. 回文排列
        给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
        回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
        回文串不一定是字典当中的单词。
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2!=0){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
    /*
        剑指 Offer II 086. 分割回文子字符串--->字符串的所有分割方案
        给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
        回文串 是正着读和反着读都一样的字符串。
     */
    List<List<String>> res=new ArrayList<>();
    List<String> path=new ArrayList<>();
    public String[][] partition(String s) {
        backtrack(s,0);
        String[][] ret = new String[res.size()][];
        for (int i = 0; i <res.size(); ++i) {
            int cols = res.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = res.get(i).get(j);
            }
        }
        return ret;
    }
    private void backtrack(String s, int startIndex) {
        if(startIndex==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();++i){
            if(!check(s,startIndex, i)){
                continue;
            }
            path.add(s.substring(startIndex,i+1));
            backtrack(s,i+1);
            path.remove(path.size()-1);
        }
    }
    private boolean check(String substring, int left, int right) {
        while (left<right&&substring.charAt(left)==substring.charAt(right)) {
            left++;
            right--;
        }
        return left<right?false:true;
    }

    /*
        866. 回文素数
        求出大于或等于 N 的最小回文素数。
        回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
        例如，2，3，5，7，11 以及 13 是素数。
        回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
        例如，12321 是回文数。
     */
    public static int primePalindrome(int n) {
        while(true){
            n=nextPalindrome(n);
            if(isPrime(n)){
                return n;
            }
            n++;
        }
    }
    public static int nextPalindrome(int n) {
        char[] input=(n + "").toCharArray();
        int mid=input.length/2-1;
        int m=input.length;
        while(true){
            for(int i=0;i<=mid;++i){
                input[m-1-i]=input[i];
            }
            int cur=Integer.parseInt(String.valueOf(input));
            if(cur>=n){
                return cur;
            }else{
                int j=m%2==0?mid:mid+1;
                while(input[j]=='9'){
                    input[j--]='0';
                }
                input[j]++;
            }
        }
    }
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i<=(int)Math.sqrt(n);++i){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    /*
        2217. 找到指定长度的回文数-->回文根--》枚举
        给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，
        其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
        回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
     */
    public static long[] kthPalindrome(int[] queries, int intLength) {

        int right=intLength/2+intLength%2;
        long l=(long)Math.pow(10, right-1);
        long r=(long)Math.pow(10,right);
        long[] res=new long[queries.length];
        if(intLength%2==0){
            for(int i=0;i<queries.length;++i){
                long temp=l+queries[i]-1;
                if(temp>=r){
                    res[i]=-1;
                }else{
                    String s=Long.toString(temp);
                    s=s+new StringBuilder(s).reverse().toString();
                    res[i]=Long.valueOf(s);
                }
            }
        }else{
            for(int i=0;i<queries.length;++i){
                long temp=l+queries[i]-1;
                if(temp>=r){
                    res[i]=-1;
                }else{
                    String s=Long.toString(temp);
                    s=s+new StringBuilder(s).deleteCharAt(s.length()-1).reverse().toString();
                    res[i]=Long.valueOf(s);
                }
            }
        }
        return res;
    }
}
