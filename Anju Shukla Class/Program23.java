public class Program23 {
    public static void main(String[] args) {
        int numer= 10;
        int denom =0;
        try{
            int result= numer/denom;
            System.out.println(result);
        } catch(ArithmeticException e){
            System.out.println("Divide by zero exception: "+ e.getMessage());
        }
    }
}