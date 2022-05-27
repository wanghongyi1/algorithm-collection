package TestUtil.贪心;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-25 16:40
 * @Description: 贪心
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getMax(new int[]{1,2,4,9}, 1000));
    }
    public static String getMax(int[] input,int n){
        Arrays.sort(input);
        String nStr=n+"";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<nStr.length();++i){
            int cur = Integer.parseInt(nStr.charAt(i) + "");
            int index = getIndex(input, cur);
            if(index==-1){
                //return getMax(input, n);
            } else if(input[index]==cur){
                res.append(input[index]);
            }else{
                res.append(input[index]);
                return fillDefault(res.toString(), input[input.length - 1], nStr.length() - res.length());
            }
        }
        return null;
    }
    public static String fillDefault(String input,int max,int count){
        for(int i=0;i<count;++i){
            input+=max;
        }
        return input;
    }
    public static int getIndex(int[] input,int val){
        int left=0;
        int right=input.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(input[mid]==val){
                return mid;
            }else if(input[mid]<val){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
}
