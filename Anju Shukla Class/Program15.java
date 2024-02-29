public class Program15 {
    public static void main(String[] args) {
        Person p1 = new Person(18, "Sunay");
        p1.display();
        Person p2 = new Person(p1);
        p2.display();
    }
}

class Person{
    int age;
    String name;
    
    void display(){
        System.out.println("Name of person is "+name);
        System.out.println("Age of "+name+" is "+age);
    }

    Person(int age,String name){
        this.age=age;
        this.name=name;
    }

    //copy constructor
    Person(Person p){
        this(p.age, p.name);
    }
}

class Hello{
    int id;
    String name;
    Hello(int i, String s){
        id=i;
        name=s;
    }
    void display(){
        System.out.println("Id is "+id);
        System.out.println("Name is "+name);
    }
}
