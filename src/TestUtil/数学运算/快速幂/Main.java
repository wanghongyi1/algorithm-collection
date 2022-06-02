package TestUtil.数学运算.快速幂;

/**
 * @author:why
 * @create: 2022-06-01 21:12
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
    }
    public static double myPow(double x, int n) {
        return n>=0?myPow2(x,n):1.0/myPow2(x,-n);
    }
    public static double myPow2(double x, int n) {
        if(n==0){
            return 1.0;
        }
        double t=myPow2(x,n/2);
        return n%2==0?t*t:t*t*x;
    }
    public static double myPow3(double x, long n) {
        double res=1;
        while(n!=0){
            if(n%2==1){
                res*=x;
            }
            x*=x;
            n/=2;
        }
        return res;
    }
}
