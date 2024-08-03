import java.util.*;

public class ArrayListPractice{ 
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
    
    public static void targetSumBrute(ArrayList<Integer> list,int target){
        // ArrayList<Integer[]> pairs = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=i;j<list.size();j++){
                if((list.get(i)+list.get(j))==target){
                    // pairs.add(new Integer[]{list.get(i),list.get(j)});
                    System.out.println(list.get(i)+","+list.get(j));
                }
            }
        }
    }
    
    public static boolean targetSumTwoPointer(ArrayList<Integer> list, int target){
        int lp=0,rp=list.size()-1;
        while(lp<rp){
            if((list.get(lp)+list.get(rp))==target){
                return true;
            }
            else if((list.get(lp)+list.get(rp))<target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }
    
    public static boolean targetSumRotated(ArrayList<Integer> list, int target){
        int lp=0,rp=list.size()-1, n=list.size();
        for(int i=1;i<list.size();i++){
            if(list.get(i-1)>list.get(i)){
                lp=i;
                rp=i-1;
                break;
            }
        }
        while(lp!=rp){
            if((list.get(lp)+list.get(rp))==target){
                return true;
            }
            else if((list.get(lp)+list.get(rp))<target){
                lp=(lp+1)%n;
            }
            else{
                rp=(n+rp-1)%n;
            }

        }
        return false;
    }
    
    public static ArrayList<Integer> isLonely(ArrayList<Integer> list){
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            boolean check = true;
            int a = list.get(i);
            for(int j=1;j<list.size();j++){
                if(j==i){
                    continue;
                }
                int b = list.get(j);
                if(a==b||a==b-1||a-1==b){
                    check=false;
                    break;
                }
            }
            if(check){
                num.add(a);
            }
        }
        return num;
    }
    public static void main(String[] args) {
        // ArrayList<Integer> conatiner = new ArrayList<>(Arrays.asList(9,8,6,2,5,4,8,3,7,2,5,4,8,3,7,4,8,3,7,2,5,8,6,2,5,4,5));
        // maxWaterTwoPointer(conatiner);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10,11,6,7,8,9));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(10,12,6,5,8)); 
        targetSumBrute(list1, 6);
        // System.out.println(targetSumTwoPointer(list1, 5));
        System.out.println(targetSumRotated(list2, 20));
        System.out.println(isLonely(list3));
        
    }
}
