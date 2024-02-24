import java.util.Scanner;

public class CountOfNumbersFromUser {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        counter();
        sc.close();
    }

    public static void counter(){
        Scanner sc = new Scanner(System.in);
        int posCount=0;
        int negCount=0;
        int zeroCount=0;
        char choice='y';
        while(choice=='y'|choice=='Y'){
            System.out.print("Enter the number:");
            int a= sc.nextInt();
            if(a>0){
                posCount++;
            }
            else if(a<0){
                negCount++;
            }
            else{
                zeroCount++;
            }
            System.out.print("Do you want to continue(Y/n):");
            choice= sc.next().charAt(0);
        }
        System.out.println("Total Positive Numbers are:"+posCount);
        System.out.println("Total Negative Numbers are:"+negCount);
        System.out.println("Total Zero Numbers are:"+zeroCount);
        sc.close();
    }
}
