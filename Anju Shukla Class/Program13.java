import java.util.*;
public class Program13 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name:");
        
        // nextLine
        String name = sc.nextLine();
        
        //nextInt
        System.out.print("Enter your age:");
        int age = sc.nextInt();
        
        //eligible to vote
        if(age>=18){
            System.out.println(name+" is elibile to vote.");
        }
        else{
            System.out.println(name+" is not elibile to vote.");
        }
        
        //table of 2
        int num=2;
        for(int i=1;i<=10;i++){
            if(i%2==0){
                continue;
            }
            System.out.println(num+"x"+i+"="+num*i);
        }
        sc.close();
    }
}
