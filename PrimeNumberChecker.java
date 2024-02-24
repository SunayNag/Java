import java.util.Scanner;

public class PrimeNumberChecker {
    public static void check(int a){
        if(a%2==0){
            System.out.println("Not a prime");
        }
        else{
            for(int i=3;i<=a/2;i++){
                if(a%i==0){
                    System.out.println("Not a prime number as its divisible by "+i);
                    return;
                }
            }
            System.out.println(a+" is a prime number");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be checked:");
        int n= sc.nextInt();
        check(n);
        sc.close();
    }
}
