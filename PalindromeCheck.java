public class PalindromeCheck {
    public static void main(String args[]){
        int x=1463847412;
        int temp=x;
        int temp2=0;
        int check=0;
        while(temp!=0){
            temp2=temp%10;
            temp=temp/10;
            check=check*10+temp2;
            System.out.println(Boolean.toString(temp!=0)+" CHEC:"+ (double)check*10 +" "+ Boolean.toString((double)check*10<Integer.MIN_VALUE)+" "+Boolean.toString((double)check*10>Integer.MAX_VALUE));
            System.out.println("temp2:"+temp2);
        }
        if (check==x) {
            System.out.println("The number is palindrome");
        }   
    }
}
