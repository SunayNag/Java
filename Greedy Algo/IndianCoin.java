import java.util.ArrayList;
import java.util.List;

public class IndianCoin {
    public static void main(String[] args) {
        int[] currency = {1,2,5,10,20,50,100,500,2000};
        int target = 590;
        int n = currency.length-1;
        int count =0;
        List<Integer> curr = new ArrayList<>();

        while(target>0){
            if(target<currency[n]){
                n--;
            }
            else{
                curr.add(currency[n]);
                target-=currency[n];
                count++;
            }
        }

        System.out.println(count+" "+curr);
    }
}
