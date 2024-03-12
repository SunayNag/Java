import java.util.*;

public class OOPS {
    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.setColor("Blue");
        // p1.setTip(5);

        // Student s1= new Student("Sunay", 21);
        // s1.password = "abcd";
        // s1.marks[0]=100; s1.marks[1]=80; s1.marks[2]=90;

        // Student s2 = new Student(s1,"kyore");
        // System.out.println(Arrays.toString(s1.marks));
        // System.out.println(Arrays.toString(s2.marks));

        // s2.marks[0]=80;
        // System.out.println(Arrays.toString(s1.marks));
        // System.out.println(Arrays.toString(s2.marks));

        // Fish nemo = new Fish();
        // nemo.eat();
        // nemo.breathe();
        // nemo.swim();

        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(1, 2));
        // System.out.println(calc.sum((float)1.333, (float)2.5));
        // System.out.println(calc.sum(1, (float)2.5,2));

        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // Chicken c = new Chicken();
        // c.eat();
        // c.walk();

        // Queen q = new Queen();
        // q.moves();

        // Rook r = new Rook();
        // r.moves();

        // Pawm p = new Pawm();
        // p.moves();

        // Bear b = new Bear();
        // b.eat();

        // Deer d = new Deer();
        // d.eat();

        // Lion l = new Lion();
        // l.eat();

        Complex a = new Complex(3,4);
        Complex b = new Complex(2,3);

        Complex sum = Complex.sum(a,b);
        sum.getter();

        Complex diff = Complex.difference(a, b);
        diff.getter();

        Complex pro = Complex.product(a, b);
        pro.getter();

    }
}

// Private and Protected cannot be used as access modifiers for class

class Complex{
    int realPart;
    int imaginaryPart;

    Complex(){}

    Complex(int real, int imaginary){
        this.realPart =real;
        this.imaginaryPart = imaginary;
    }

    static Complex sum(Complex a, Complex b){
        return new Complex(a.realPart+b.realPart, a.imaginaryPart+b.imaginaryPart);
    }

    static Complex difference(Complex a, Complex b){
        return new Complex(a.realPart-b.realPart,a.imaginaryPart-b.imaginaryPart);
    }

    static Complex product(Complex a, Complex b){
        return new Complex((a.realPart*b.realPart) - (a.imaginaryPart*b.imaginaryPart),(a.realPart*b.imaginaryPart) + (a.imaginaryPart*b.realPart));
    }

    void getter(){
        System.out.println(this.realPart+" + "+this.imaginaryPart+"i");
    }
}

class Student{
    String name;
    int rollNo;
    String password;
    int marks[];

    Student(Student s1, String newPass){
        marks= new int[3];
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        this.password = newPass;
        this.marks = Arrays.copyOf(s1.marks, marks.length);
    }

    Student(){
        marks= new int[3];
    }

    Student(String name, int rollNo){
        marks= new int[3]; 
        this.name = name;
        this.rollNo = rollNo;
    }
}

class Pen{
    private String color;
    private int tip;

    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }
    void setColor(String newColor){
        color = newColor;
    }
    void setTip(int newTip){
        tip = newTip;
    }
}

class Animal{
    String color;
    void eat(){
        System.out.println("Consumed");
    }
    void breathe(){
        System.out.println("Respiration. What else do you expect? Photosynthesis?");
    }

}

class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("Its a fish. Ofcourse it swims you donut");
    }
}

class Calculator{
    int sum(int a, int b){
        return a+b;
    }
    float sum(float a, float b){
        return a+b;
    }
    float sum(float a, float b,float c){
        return c+sum(a, b);
    }
}

abstract class Animals{
    void eat(){
        System.out.println("Its an animal, ofcourse it eats");
    }

    //Abstract methods need to be defined in derived classes
    abstract 
    void walk();
}

class Horse extends Animals{
    void walk(){
        System.out.println("A horse can walk too. Its doesn't always run");
    }
}

class Chicken extends Animals{
    void walk(){
        System.out.println("Chicks don't fly, they walk");
    }
}

/*********************************************************************
* Interfaces are used to implement same methods to different classes *
* Interfaces only have abstract methods                              *
**********************************************************************/
interface ChessPiece{
    void moves();
}

class Queen implements ChessPiece{
    public void moves(){
        System.out.println("Up, Down, Left, Right, All diagonals");
    }
}

class Rook implements ChessPiece{
    public void moves(){
        System.out.println("Up, Down, Left, Right");
    }
}

class Pawm implements ChessPiece{
    public void moves(){
        System.out.println("Up, up diagonals(if elimination is possible)");
    }
}

//Use of interface to have multiple inheritance
interface Herbivore{
    void eat();

}

interface Carnivore{
    void eat();
}

class Bear implements Herbivore, Carnivore{
    public void eat(){
        System.out.println("It can eat grass or meat");
    }
}

class Lion implements Carnivore{
    public void eat(){
        System.out.println("It eats meat");
    }
}

class Deer{
    public void eat(){
        System.out.println("It can eat only grass");
    }
}