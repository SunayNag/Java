import java.util.*;

public class ArryaList{ 
    public static int max(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i: list){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
    
    public static void swap(ArrayList<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
    public static void maxWater(ArrayList<Integer> container){
        int vol;
        int maxVol=Integer.MIN_VALUE;
        int firstSide=0, secondSide=0;
        for(int i=0;i<container.size();i++){
            for(int j=i+1;j<container.size();j++){
                vol=(j-i)*(Math.min(container.get(i), container.get(j)));
                if(vol>maxVol){
                    maxVol=vol;
                    firstSide=i;
                    secondSide=j;
                }
            }
        }
        System.out.println("The maximum amount of water container is "+ maxVol+" with sides numbers "+firstSide+" and "+secondSide);
    }
    
    public static void maxWaterTwoPointer(ArrayList<Integer> container){
        int i=0,j=container.size()-1,maxVol=Integer.MIN_VALUE,vol=0;
        int firstSide=0,secondSide=0;
        while(i<j){
            vol=(j-i)*Math.min(container.get(i), container.get(j));
            if(vol>maxVol){
                maxVol=vol;
                firstSide=i;
                secondSide=j;
            }
            if(container.get(i)< container.get(j)){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println("The maximum amount of water container is "+ maxVol+" with sides numbers "+firstSide+" and "+secondSide);

    }
    
    public static ArrayList<Integer[]> targetSumBrute(ArrayList<Integer> list,int target){
        ArrayList<Integer[]> pairs = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=i;j<list.size();j++){
                if((list.get(i)+list.get(j))==target){
                    pairs.add(new Integer[]{list.get(i),list.get(j)});
                }
            }
        }
        return pairs;
    }
    public static void main(String[] args) {
        // ArrayList<Integer> conatiner = new ArrayList<>(Arrays.asList(9,8,6,2,5,4,8,3,7,2,5,4,8,3,7,4,8,3,7,2,5,8,6,2,5,4,5));
        // maxWaterTwoPointer(conatiner);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(targetSumBrute(list1, 5));
        
    }
}
