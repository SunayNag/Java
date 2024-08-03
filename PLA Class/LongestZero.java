// import java.util.*;
public class LongestZero {
    public static int findConsecutive(int[] arr, int k){
        int maxZero =0, numReplacements = 0, start=0;
        for(int end=0;end<arr.length;end++){
            if(arr[end]==1){
                numReplacements++;
            }
            while(numReplacements>k){
                if(arr[start]==1){
                    numReplacements--;
                }
                start++;
            }
            maxZero= Math.max(maxZero, end-start+1);
        }
        return maxZero;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,0,0,0,1,1,1,1,1,0};
        int k=1;
        System.out.println(findConsecutive(arr, k));
    }
}
