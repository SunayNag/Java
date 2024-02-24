import java.util.Scanner;

public class PatternPallindrome {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length of side:");
        int n= sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=n;j>=1;j--){
                if(j<=i){
                    System.out.print(j+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            for(int j=2;j<=i;j++){
                    System.out.print(j+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
