package TestUtil.二维数组排序;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] res = new int[m][5];
        for(int i=0;i<m;i++){
            String[] split = scanner.nextLine().split(",");
            res[i][0]= Integer.parseInt(split[0]);
            res[i][1]= Integer.parseInt(split[1]);
            res[i][2]= Integer.parseInt(split[2]);
            res[i][3]= Integer.parseInt(split[3]);
            res[i][4]= Integer.parseInt(split[4]);
        }
        int n = scanner.nextInt();
        int strategy = scanner.nextInt();
        int cpuCount = scanner.nextInt();
        int memSize = scanner.nextInt();
        int cpuArch = scanner.nextInt();
        int supportNP = scanner.nextInt();

        if(strategy==1){
            Arrays.sort(res,(a,b)->{
                if(Math.abs(b[1]-cpuCount)!=Math.abs(a[1]-cpuCount)){
                    return Math.abs(a[1]-cpuCount)-Math.abs(b[1]-cpuCount);
                }
                if(Math.abs(a[2]-memSize)!=Math.abs(b[2]-memSize)){
                    return Math.abs(a[2]-memSize)-Math.abs(b[2]-memSize);
                }
                return a[0]-b[0];
            });
        }else {
            Arrays.sort(res,(a,b)->{
                if(Math.abs(b[2]-memSize)!=Math.abs(a[2]-memSize)){
                    return Math.abs(a[2]-memSize)-Math.abs(b[2]-memSize);
                }
                if(Math.abs(a[1]-cpuCount)!=Math.abs(b[1]-cpuCount)){
                    return Math.abs(a[1]-cpuCount)-Math.abs(b[1]-cpuCount);
                }
                return a[0]-b[0];
            });
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] re : res) {
            if(re[1]>=cpuCount && re[2]>=memSize && (re[3]==cpuArch||cpuArch==9) && (supportNP==2 || (re[4] == supportNP))){
                ans.add(re[0]);
            }
            if(ans.size()==n)break;
        }
        Collections.sort(ans);
        System.out.print(ans.size()+" ");
        for (int i = 0; i < ans.size() && i<n; i++) {
            if(i!=0) System.out.print(" ");
            System.out.print(ans.get(i));
        }

    }
}