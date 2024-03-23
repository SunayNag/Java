public class Program21 {
    public static void main(String[] args) {
        Derived obj= new Derived();
        obj.show();
    }
}

class Base{
    int x=10;
    Base(){
        System.out.println("Base class constructor");
    }
    void show(){
        System.out.println("Base class show");
    }
}

class Derived extends Base{
    Derived(){
        super();
    }
    void show(){
        System.out.println("Derived class show");
    }
}