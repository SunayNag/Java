import java.util.Scanner;

public class Program19{
    public static void main(String[] args) {
        TwoWheeler t1 = new TwoWheeler();
        FourWheeler f1 = new FourWheeler();
        t1.model();
        f1.model();
        t1.display();
        f1.display();
    }
}

abstract class Vehicle{
    String model;
    int price;
    abstract void model();
    void display(){
        System.out.println("The model of the vehicle is "+ model+" and its proce is "+price);
    }
}

class TwoWheeler extends Vehicle{
    void model(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the model:");
        this.model= sc.next();
        sc.close();
    }
}

class FourWheeler extends Vehicle{
    void model(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the model:");
        this.model= sc.next();
        sc.close();
    }
}