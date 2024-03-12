public class Program17 {
    public static void main(String[] args) {
        Circle c1= new Circle();
        Rectangle r1 = new Rectangle();
        c1.draw();
        r1.draw();
    }
}

abstract class Shape{
    abstract void draw();
}

class Circle extends Shape{
    void draw(){
        System.out.println("Draw a circle");
    }
}

class Rectangle extends Shape{
    void draw(){
        System.out.println("Draw a rectangle");
    }
}