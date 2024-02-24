import java.util.Scanner;

public class ArraySearch {
    public static void main(String args[]){
        int x = 30;
        Scanner sc= new Scanner(System.in);
        int size =sc.nextInt();
        int arr[] = new int[size];
        
        for(int i=0;i<size;i++){
            System.out.print("Enter the number:");
            arr[i]=sc.nextInt();
            
        }
        sc.close();

        for(int i=0;i<size;i++){
            if(arr[i]==x){
                System.out.println("The number "+x+" is found in the array at index "+i);
                return;
            }
        }
        System.out.println("The number not found in array");
    }
}
