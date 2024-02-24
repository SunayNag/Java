import java.util.Scanner;

public class PatternButterfly {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length of side:");
        int n= sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=2*n;j++){
                if(j<=i||j>=(2*n-i+1)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=2*n;j>=1;j--){
                if(j<=i||j>=(2*n-i+1)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
