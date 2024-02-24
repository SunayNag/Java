import java.util.Scanner;

public class Fibonnanci {
    public static void Series(int n){
        int previous =-1;
        int current = 1;
        int next;
        if(n<=0){
            System.out.println("Please Enter a natural number!");
            return;
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        for(int i=1;i<=n;i++){
            next= previous+current;
            System.out.print(next+" ");
            previous=current;
            current=next;
        }
    }
   public static void main(String arg[]){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter how many numbers you want:");
    int n = sc.nextInt();
    sc.close();
    Series(n);
   } 
}
