import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val  = {60,120,100};
        int[] weight = {10,30,20};
        int cap = 50;
        int n = val.length;
        
        int[][] ratio = new int[n][3];
        for(int i=0;i<n;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i];
            ratio[i][2]=weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o-> o[1]/o[2]));
        
        int pro = 0;
        for(int i=n-1;i>=0;i--){
            if(ratio[i][2]<=cap){
                pro+=ratio[i][1];
                cap-=ratio[i][2];
            }
            else{
                pro+= (ratio[i][1]/ratio[i][2])*cap;
                cap=0;
            }
            if(cap==0){
                break;
            }
        }

        System.out.println(pro);
    }  
}
