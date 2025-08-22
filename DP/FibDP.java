import java.util.Arrays;

public class FibDP {
    static long fib(int n, long f[]){
        if(n==0||n==1){
            f[n]=n;
            return f[n];
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = fib(n-1,f) + fib(n-2,f);
        // System.out.print(f[n]+" ");
        return f[n];
    }
    public static void main(String[] args) {
        int n =92;
        long f[] = new long[n+1];
        fib(n, f);
        System.out.println(Arrays.toString(f));
    }
}
