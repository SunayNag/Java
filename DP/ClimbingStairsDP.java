import java.util.Arrays;

public class ClimbingStairsDP {
    static int stairsMem(int n, int[] steps){
        if(n<0){
            return 0;
        }
        if(n==0){
            steps[n]=1;
            return 1;
        }
        if(steps[n]!=0){
            return steps[n];
        }
        steps[n]= stairsMem(n-1,steps)+stairsMem(n-2, steps);
        return steps[n];
    }
    public static void main(String[] args) {
        int n=5;
        int steps[] = new int[n+1];
        System.out.println(stairsMem(n, steps));
        System.out.println(Arrays.toString(steps));
    }
}
