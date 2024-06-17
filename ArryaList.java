import java.util.*;

public class ArryaList {
    public static int max(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;
    }
    
    public static void swap(ArrayList<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    public static void main(String[] args) {
        
        // System.out.println("The largest element of array is "+max(list));
    }
}
