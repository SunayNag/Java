import java.util.Scanner;

public class SwitchCase {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number:");
        int a = sc.nextInt();

        System.out.print("Enter the second number:");
        int b = sc.nextInt();

        System.out.println("Enter 1 to add\n2 to substract\n3 to multiply\n4 to divide\n5 to modulo");
        int result;

        int key = sc.nextInt();
        switch (key) {
            case 1:
                result= a+b;
                System.out.println(result);
                break;
            
            case 2:
                result = a-b;
                System.out.println(result);
                break;
            case 3:
                result = a*b;
                System.out.println(result);
                break;
            case 4:
                result = a/b;
                System.out.println(result);
                break;
            case 5:
                result = a%b;
                System.out.println(result);
                break;
        
            default:
                System.out.println("Inavlid key");
                break;
        }

        sc.close();
    } 
}
