import java.util.Scanner;

public class Array {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the size of Array:");
        int size = sc.nextInt(); 
        int marks[]= new int[size];
        for(int i=0;i<size;i++){
            System.out.print((i+1)+".)Enter the number:");
            marks[i]=sc.nextInt();
        }

        for(int i=0;i<size;i++){
            System.out.println(marks[i]);
        }
        sc.close();
    }
}
