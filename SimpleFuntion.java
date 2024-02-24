import java.util.Scanner;

public class SimpleFuntion {

    public static int sum(int a, int b){
        return a+b;
    }

    public static int product(int a, int b){
        return a*b;
    }

    public static int factorial(int a){
        if(a<0){
            System.out.println("Invalid number");
            return 0;
        }
        if(a==0){
            return 1;
        }
        return a*factorial(a-1);
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the first number:");
        int a = sc.nextInt();
        System.out.print("Enter the second number:");
        int b = sc.nextInt();
        System.out.println("The Sum of the numbers is:"+sum(a, b));
        System.out.println("The  product of the numbers is:"+product(a,b));
        System.out.println("Factorial of first number is:"+factorial(a));
        System.out.println("Factorial of second number is:"+factorial(b));
        sc.close();
    }
}
