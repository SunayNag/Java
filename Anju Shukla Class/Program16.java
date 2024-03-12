public class Program16 {
    public static void main(String[] args) {
        Vehicle v1= new Vehicle();
        TwoWheeler t1= new TwoWheeler();
        FourWheeler f1= new FourWheeler();
        v1.show();
        t1.show();
        t1.display();
        f1.show();
    }
}

class Vehicle{
    void show(){
        System.out.println("This is a vehicle class");
    }
}

class TwoWheeler extends Vehicle{
    void show(){
        System.out.println("This is a two wheeler class");
    }
    void display(){
        super.show();
    }
}
class FourWheeler extends Vehicle{
    void show(){
        System.out.println("This is a four wheeler class");
    }
}