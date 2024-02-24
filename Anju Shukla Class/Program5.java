public class Program5 {
    public static void main(String[] args) {
        //Before swapping
        int a=10,b=20;
        System.out.println("The numbers before swapping are a="+a+" and b="+b);

        //swapping 
        a=a+b;
        b=a-b;
        a=a-b;

        //After swapping
        System.out.println("The numbers after swapping are a="+a+" and b="+b);

    }
}
