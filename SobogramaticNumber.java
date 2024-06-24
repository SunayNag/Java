import java.util.*;
public class SobogramaticNumber {
    public static boolean isStrobogramatic(String num){
        Map<Character, Character> strobo = new HashMap<>();
        strobo.put('6', '9');
        strobo.put('0', '0');
        strobo.put('8', '8');
        strobo.put('9', '6');
        strobo.put('1', '1');
        int n=num.length();
        for(int i=0,j=n-1;i<=j;i++,j--){
            char digitLeft = num.charAt(i);
            char digitRight = num.charAt(j);
            char mapping = strobo.getOrDefault(digitLeft, '-');
            if(mapping=='-'||mapping!=digitRight){
                System.out.println(digitLeft+" "+mapping);
                return false;
            }
        }
        return true;         
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        System.out.println(isStrobogramatic(num));
        sc.close();
    }
}
