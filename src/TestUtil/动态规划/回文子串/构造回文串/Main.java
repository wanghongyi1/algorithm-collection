package TestUtil.动态规划.回文子串.构造回文串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:why
 * @create: 2022-05-29 16:31
 * @Description: 特性：只有一个字符数量是奇数
 */
public class Main {
    public static void main(String[] args) {
        longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");

    }
    /*
        409. 最长回文串-->特性，
        给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
        在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     */
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2!=0){
                count++;
            }
        }
        return count==0?s.length():(s.length()-count+1);
    }
}
