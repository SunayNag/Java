import java.util.*;

public class input {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum= a+b;
        System.out.print("The Sum of a and b is:");
        System.out.println(sum);

        sc.close();
    }
}
