package TestUtil.贪心;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-26 12:15
 * @Description: 小于n的最大整数
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(getMax(new int[]{1,2,4,9}, 1249));
    }
    public static String getMax(int[] input,int n){
        Arrays.sort(input);
        String target=n-1+"";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<target.length();++i){
            int cur=Integer.parseInt(target.charAt(i)+"");
            int temp = search(input, cur);
            if(temp==-1){
                if(i==0){
                    if(target.length()==1){
                        return null;
                    }else{
                        return generateStr(target.length()-1,input[input.length-1]);
                    }
                }else{
                    int index=i-1;
                    while (temp==-1&&index>=0){
                        temp=search(input,Integer.parseInt(target.charAt(index)-'1'+""));
                        index--;
                    }
                    if(temp==-1){
                        return generateStr(target.length()-1,input[input.length-1]);
                    }else {
                        res.delete(index+1, res.length());
                        res.append(temp);
                        res.append(generateStr(target.length()-res.length(), input[input.length-1]));
                        return res.toString();
                    }
                }
            }else{
                if(temp==cur){
                    res.append(temp);
                    if(i==target.length()-1){
                        return res.toString();
                    }
                }else{
                    res.append(temp);
                    res.append(generateStr(target.length()-res.length(), input[input.length-1]));
                    return res.toString();
                }
            }
        }
        return null;
    }

    public static String generateStr(int count,int val){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<count;++i){
            sb.append(val);
        }
        return sb.toString();
    }
    public static int search(int[] input,int val){
        int left=0;
        int right=input.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(input[mid]==val){
                return input[mid];
            }else if(input[mid]<val){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right==-1?-1:input[right];
    }
}
