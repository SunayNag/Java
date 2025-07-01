import java.util.*;
public class Chocola {
    public static void main(String[] args) {
        int n=4,m=6;
        Integer[] costVer = {2,1,3,1,4};
        Integer[] costHor = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0;
        int total=0;
        int verp=1, horp=1;
        while(v<m-1 && h<n-1){
            if(costVer[v]>=costHor[h]){
                total += costVer[v]*horp;
                verp++;
                v++;
            }
            else{
                total += costHor[h]*verp;
                horp++;
                h++;
            }
        }

        while(v<m-1){
            total += costVer[v]*horp;
            verp++;
            v++;
        }

        while(h<n-1){
            total += costHor[h]*verp;
            horp++;
            h++;
        }

        System.out.println(total);
    }    
}
