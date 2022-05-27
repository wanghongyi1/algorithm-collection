package TestUtil.位运算;

/**
 * @author:why
 * @create: 2022-05-26 19:00
 * @Description: 位运算
 */
public class Main {

    /*
        868. 二进制间距
        给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
        n&1  判断最低位是否是1
     */
    public static  int binaryGap(int n) {
        int pre=-1;
        int res=Integer.MIN_VALUE;
        for(int i=0;n!=0;++i){
            if((n&1)==1){  //正整数
                if(pre==-1){
                    pre=i;
                }else{
                    res=Math.max(res,i-pre);
                    pre=i;
                }
            }
            n=n>>1; //正整数
        }
        return res==Integer.MIN_VALUE?0:res;
    }
    /*
        去掉末尾1  n&n-1
     */
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }
    /*
        002 剑指 Offer II 002. 二进制加法
        给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     */
    public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int carry=0;
        int m=as.length;
        int n=bs.length;
        int i=m-1;
        int j=n-1;
        int cur=0;
        StringBuilder res=new StringBuilder();
        while(i>=0||j>=0||carry>0){
            int v1=i>=0?Integer.parseInt(as[i]+""):0;
            int v2=j>=0?Integer.parseInt(bs[i]+""):0;
            cur=v1+v2+carry;
            if(cur>1){
                carry=cur/2;
                res.append(cur%2);
            }else{
                carry=0;
                res.append(cur);
            }
            --i;
            --j;
        }
        return res.reverse().toString();
    }
    /*
        剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
        给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
        x & 1得到除以2的余数
     */
    public static int[] countBits(int n) {
        int[] res=new int[n+1];
        for(int i=1;i<=n;++i){
            if((i&1)==1){
                res[i]=res[i>>1]+1;
            }else{
                res[i]=res[i>>1];
            }
        }
        return res;
    }
    /*
        面试题 05.02. 二进制数转字符串
        二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
     */
    public String printBin(double num) {
        StringBuilder sb=new StringBuilder();
        sb.append("0.");
        while(num!=0){
            num*=2;
            if(num>=1){
                sb.append(1);
                num-=1;
            }else{
                sb.append(0);
            }
            if(sb.length()>32){
                return "ERROR";
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }
    public static int reverseBits(int n) {
        int rev=0;
        for(int i=0;n!=0;++i){
            if((n&1)==1){
                rev=rev|(1<<(31-i));
            }
            n=n>>>1;
        }
        return rev;
    }
}
