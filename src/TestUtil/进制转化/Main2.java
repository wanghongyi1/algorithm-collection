package TestUtil.进制转化;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(check("0101", 15));
    }
    //十进制转其他进制
    private static String conver10ToN(int number, int n) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            if(number % n>=10){
                sb.append((char)(65+number % n-10));
            }else{
                sb.append(number % n);
            }
            number = number / n;
        }
        return sb.reverse().toString();
    }
    //n进制转10进制
    public static int convertNTo10(String source, int n) {
        int target = 0;
        StringBuilder sb=new StringBuilder(source);
        String str=sb.reverse().toString();
        for (int i = 0; i <str.length() ; i++) {
            int mm=-1;
            if(str.charAt(i)>='A'){
                mm=str.charAt(i)-'A'+10;
            }else{
                mm = Integer.parseInt(str.charAt(i)+"");
            }
            target = target + (int)(mm*Math.pow(n,i));
        }
        return target;
    }

    public static boolean check(String input,int n){
        char[] chars = input.toCharArray();
        char max='0';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>max){
                max=chars[i];
            }
        }
        int flag=Character.digit(max, 16);
        if(n>=flag+1){
            return true;
        }else {
            return false;
        }
    }
}
