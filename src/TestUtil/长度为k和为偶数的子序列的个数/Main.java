package TestUtil.长度为k和为偶数的子序列的个数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int oddNum = 0;
            int evenNum = 0;
            for (int j = 0; j < n; j++) {
                int input=sc.nextInt();
                if (input % 2 == 0) {
                    evenNum++;
                } else {
                    oddNum++;
                }
            }
            int[] CN=new int[evenNum+1];
            int[] CM=new int[oddNum+1];
            CN[0]=1;
            CM[0]=1;
            for(int j=1;j<=evenNum;++j){
                CN[j]=CN[j-1]*(evenNum-j+1)/j;
            }
            for(int j=1;j<=oddNum;++j){
                CM[j]=CM[j-1]*(oddNum-j+1)/j;
            }
            int res = 0;
            for (int j = 0; j <= k; j+=2) {
                if (j <= oddNum && k - j <= evenNum) {
                    res += CM[j] * CN[k-j];
                }
            }
            System.out.println(res);
        }
    }
}


