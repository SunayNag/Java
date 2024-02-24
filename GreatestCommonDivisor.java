import java.util.Scanner;

public class GreatestCommonDivisor {
    public static int GCD(int a, int b){
        int result,great, less;
        result=1;
        if(a>b){
            great=a;
            less=b;
        }
        else{
            great=b;
            less=a;
        }
        if(great%less==0){
            result=less;
            return result;
        }
        for(int i=less;i>1;i--){
            if((great%i==0)&&(less%i==0)){
                result=i;
                return result;
            }
        }

        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number:");
        int a= sc.nextInt();
        System.out.print("Enter the second number:");
        int b= sc.nextInt();
        int GrCoDi=GCD(a,b);
        System.out.println("The Greatest Common Divisor between "+a+" and "+b+" is "+ GrCoDi);
        sc.close();
    }
}
