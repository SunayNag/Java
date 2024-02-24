import java.util.*;

public class areaOfCircle {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        double area = 3.141*r*r;
        System.out.print("Area of circle is:");
        System.out.println(area);

        sc.close();
    }
}
