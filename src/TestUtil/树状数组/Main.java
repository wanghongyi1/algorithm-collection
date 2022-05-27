package TestUtil.树状数组;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:why
 * @create: 2022-05-25 20:18
 * @Description: 使用
 */
public class Main {
    public static void main(String[] args) {
    }
    /*
        1505 最多 K 次交换相邻数位后得到的最小整数
        给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
        你可以交换这个整数相邻数位的数字 最多 k 次。
     */
    public String minInteger(String num,int k){
        Queue<Integer>[] pos=new Queue[10];
        for(int i=0;i<10;++i){
            pos[i]=new LinkedList<>();
        }
        for(int i=0;i<num.length();++i){
            pos[num.charAt(i)-'0'].offer(i+1);
        }
        BIT bit=new BIT(num.length());
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=num.length();++i){
            for(int j=0;j<10;++j){
                if(!pos[j].isEmpty()){
                    int peek=pos[j].peek();
                    int diff=peek-i+bit.query(peek+1, num.length());
                    if(diff<=k){
                        int poll=pos[j].poll();
                        sb.append(j);
                        bit.update(poll, 1);
                        k-=diff;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
