interface Operation{
    int add(int a, int b);
    int substract(int a, int b);
}

class A implements Operation{
    public
    int add(int a, int b){
        return a+b;
    }
    public
    int substract(int a, int b){
        return a-b;
    }
}

class Interpolation{
    public static void main(String[] args){
        A test= new A();
        System.out.println(test.add(1,4));
        System.out.println(test.add(3,1));
    }
}