interface Shape{
    void draw();
}
class Circle{
    void draw(){
        System.out.println("Circle is drawn");
    }
}
class Rectangle{
    void draw(){
        System.out.println("Rectangle is drawn");
    }
}

public class Program22 {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();
        c1.draw();
        r1.draw();
    }
}

