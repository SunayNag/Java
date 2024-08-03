import java.util.*;
class Circle{
    int r;
    double area;
    double area(){
        area=MidTermPractice.pi*r*r;
        return area;
    }
    Circle(int a){
        r=a;
    }
}
class MidTermPractice{
    static final double pi = 3.14;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Circle c1[]= new Circle[5];
        // System.out.println(c1[0].area());   
        String s = sc.nextLine();
        System.out.println(s);
        int i = sc.nextInt();
        System.out.println(i);
        String n = sc.nextLine();
        System.out.println(n);
        sc.close();
    }    
}