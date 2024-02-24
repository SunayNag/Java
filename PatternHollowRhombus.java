import java.util.Scanner;

public class PatternHollowRhombus {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of side:");
        int n= sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<n*2;j++){
                if(i+j<=n){
                    System.out.print("  ");
                }
                else if(i==1||i==n||j==n-i+1||j==2*n-i){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                if(j>=2*n-i){
                    break;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
