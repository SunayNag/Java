import java.util.Scanner;
public class Program11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a:");
        int a = sc.nextInt();
        System.out.print("The entered value is "+a);
        sc.nextLine();
        System.out.print("Enter your name: ");
        String str = sc.nextLine();
        System.out.println("Your name is "+str);
        sc.close();
    }
}
