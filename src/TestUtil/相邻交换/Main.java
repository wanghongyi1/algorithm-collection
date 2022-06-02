package TestUtil.相邻交换;

import java.util.*;

/**
 * @author:why
 * @create: 2022-05-24 16:39
 * @Description: 相邻交换
 */
public class Main {
    /*
        考试座位
        现在有n个人坐成一排进行上机考试。但他们有的使用C语言，用C表示；而有的使用Java，用J表示。为了防止他们“友好交流”，
        小美老师要求任意座位相邻的两人之间使用的语言是不同的。
        小美每次可以交换相邻两人的位置，现在她想知道最少交换多少次可以满足要求？
     */
    public static int exchange(String input){
        char[] chars = input.toCharArray();
        int C_num=0;
        int J_num=0;
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for (int i=0;i<chars.length;++i) {
            if(input.charAt(i)=='C'){
                C_num++;
                list1.add(i-list1.size()*2);
            }else{
                J_num++;
                list2.add(i-list2.size()*2);
            }
        }
        if(Math.abs(C_num-J_num)>1){
            return -1;
        }
        int res = -1;
        if(C_num<=J_num){
            res=getRes(list2);
        }else{
            res=getRes(list1);
        }
        return res;
    }
    //绝对值的和的最小值就是中位数
    private static int getRes(List<Integer> list) {
        int res=0;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });
        int mid=list.size()/2;
        for (int i = 0; i < list.size(); i++) {
            res+=Math.abs(list.get(i)-list.get(mid));
        }
        return res;
    }


    /*
       777 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
       转换不变性和可达性
     */
    public boolean canTransform(String start, String end) {
        //start = "RXXLRXRXL", end = "XRLXXRRLX"
        //转换不变性
        if(!start.replace("X", "").equals(end.replace("X", ""))){
            return false;
        }
        //可达性
        int i=0;
        int j=0;
        while(i<start.length()&&j<end.length()){
            while(i<start.length()&&start.charAt(i)!='L'){
                ++i;
            }
            while(j<end.length()&&end.charAt(j)!='L'){
                ++j;
            }
            if(i<j){
                return false;
            }else {
                ++i;
                ++j;
            }
        }

        i=0;
        j=0;
        while(i<start.length()&&j<end.length()){
            while(i<start.length()&&start.charAt(i)!='R'){
                ++i;
            }
            while(j<end.length()&&end.charAt(j)!='R'){
                ++j;
            }
            if(i>j){
                return false;
            }else {
                ++i;
                ++j;
            }
        }
        return true;
    }
    public boolean canTransform2(String start, String end) {
        //start = "RXXLRXRXL", end = "XRLXXRRLX"
        if(start.length()!=end.length()){
            return false;
        }
        int len=start.length();
        int i=0;
        int j=0;
        while(i<len&&j<len){
            while(i<len&&start.charAt(i)=='X'){
                ++i;
            }
            while(j<len&&end.charAt(j)=='X'){
                ++j;
            }
            if(i==len&&j==len){
                return true;
            }else if(i==len||j==len){
                return false;
            }
            if(start.charAt(i)!=end.charAt(j)){
                return false;
            }

            if(start.charAt(i)=='L'&&i<j){
                return false;
            }
            if(start.charAt(i)=='R'&&i>j){
                return false;
            }
            ++i;
            ++j;
        }
        while(i<len){
            if(start.charAt(i)!='X'){
                return false;
            }
            ++i;
        }
        while(j<len){
            if(end.charAt(j)!='X'){
                return false;
            }
            ++j;
        }
        return true;
    }
    /*
        1743 从相邻元素对还原数组
        存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
        给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
        题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
        返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int a=adjacentPairs[i][0];
            int b=adjacentPairs[i][1];
            map.putIfAbsent(a,new ArrayList<>());
            map.putIfAbsent(b,new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] res=new int[adjacentPairs.length+1];
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            if(entry.getValue().size()==1){
                res[0]=entry.getKey();
                res[1]=entry.getValue().get(0);
                map.get(res[0]).remove(0);
                map.get(res[1]).remove(res[0]);
                break;
            }
        }
        for(int i=2;i<res.length;++i){
            res[i]=map.get(res[i-1]).get(0);
            map.get(res[i]).remove(res[i-1]);
        }
        return res;
    }
    /*
        1209. 删除字符串中的所有相邻重复项 II
        给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
    你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
    在执行完所有删除操作后，返回最终得到的字符串。
     */
    public static String removeDuplicates(String s, int k) {
        int[] count=new int[s.length()];
        StringBuilder sb=new StringBuilder(s);
        count[0]=1;
        for(int i=1;i<sb.length();++i){
            if(sb.charAt(i)==sb.charAt(i-1)){
                count[i]=count[i-1]+1;
                if(count[i]==k){
                    sb.delete(i-k+1,i+1);
                    i=i-k;
                }
            }else{
                count[i]=1;
            }
        }
        return sb.toString();
    }
    /*
        767 重构字符串
        给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
        返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
     */
    public String reorganizeString(String s) {
        return "";
    }

    /*
        1703. 得到连续 K 个 1 的最少相邻交换次数
        给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
        输入：nums = [1,0,0,1,0,1], k = 2
        输出：1
        解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
     */
    public int minMoves(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                list.add(i-list.size());
            }
        }
        int[] preSum=new int[list.size()+1];
        for (int i = 1; i <= list.size(); i++) {
            preSum[i]+=preSum[i-1]+list.get(i-1);
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i+k-1 < list.size(); i++) {
            int left=i;
            int right=i+k-1;
            int mid=(left+right)/2;
            int leftSum=(mid-left)*list.get(mid)-(preSum[mid]-preSum[left]);
            int rightSum=-(right-mid+1)*list.get(mid)+preSum[right+1]-preSum[mid];
            res=Math.min(res,leftSum+rightSum);
        }
        return res;
    }
    /*
        1758. 生成交替二进制字符串的最少操作数
        给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
        交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
        返回使 s 变成 交替字符串 所需的 最少 操作数。
     */
    public int minOperations(String s) {
        int step1=0;
        int step2=0;
        for(int i=0;i<s.length();++i){
            if((s.charAt(i)-'0')%2==i%2){
                step1++;
            }else {
                step2++;
            }
        }
        return Math.min(step1, step2);
    }
    /*
        2170 使数组变成交替数组的最少操作数
        给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
        如果满足下述条件，则数组 nums 是一个 交替数组 ：
        nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
        nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
        在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
        返回使数组变成交替数组的 最少操作数 。
     */

    public static int minimumOperations(int[] nums) {
        Map<Integer,Integer> odd=new HashMap<>();
        Map<Integer,Integer> even=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(i%2!=0){
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            }else{
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            }
        }
        int[][] first=getMaxTwo(odd);
        int[][] two=getMaxTwo(even);
        if(first[0][0]!=two[0][0]){
            return nums.length-first[0][1]-two[0][1];
        }
        return nums.length-Math.max(first[0][1]+two[1][1],first[1][1]+two[0][1]);
    }

    private static int[][] getMaxTwo(Map<Integer, Integer> map) {
        int[][] res=new int[2][2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>res[0][1]){
                res[1][0]=res[0][0];
                res[1][1]=res[0][1];
                res[0][0]=entry.getKey();
                res[0][1]=entry.getValue();
            }else if(entry.getValue()>res[1][1]){
                res[1][0]=entry.getKey();
                res[1][1]=entry.getValue();
            }
        }
        return res;
    }
    public static int wiggleMaxLength(int[] nums) {
        int up=1;
        int down=1;
        for(int i=1;i<nums.length;++i){
            if(nums[i]>nums[i-1]){
                up=down+1;
            }
            if(nums[i]<nums[i-1]){
                down=up+1;
            }
        }
        return nums.length==0?0:Math.max(down,up);
    }

    /*
        剑指 Offer II 096. 字符串交织
        给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。
        两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
        s = s1 + s2 + ... + sn
        t = t1 + t2 + ... + tm
        |n - m| <= 1
        交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
        提示：a + b 意味着字符串 a 和 b 连接。
     */
    public static void main(String[] args) {
        isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac");
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        return true;
    }
}
