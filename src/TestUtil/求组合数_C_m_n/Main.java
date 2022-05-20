package TestUtil.求组合数_C_m_n;

public class Main {
    public static void main(String[] args) {
        System.out.println((int)1e8+7);   //100000007
    }
    public static long getC_n_m(int n, int m) {
        long res=1;
        for(int x=n-m+1,y=1;y<=m;++x,++y){
            res=res*x/y;
        }
        return res;
    }
}
