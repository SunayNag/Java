public class Program3 {
    public static void main(String[] args) {
        int a=Integer.MAX_VALUE/10,b=0;
        int temp=a;
        while(temp!=0){
            b*=10;
            b+=temp%10;
            temp/=10;
        }
        System.out.println("The reverse of "+a+" is "+b);
    }
}
