import java.util.*;;
public class MapsAndSets {
    static boolean validAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int len = s.length();
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for(int i=0;i<len;i++){
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0)+1);
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0)+1);
        }
        for(char c : sCount.keySet()){
            if(!tCount.containsKey(c)){
                return false;
            }
            if(sCount.get(c)!=tCount.get(c)){
                return false;
            }
        }
        return true;
    }
    
    static int uniqueElements(Integer[] arr){
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, arr);
        return set.size();
    }

    static int largestSubArray(int[] arr){
        int res =-1;
        int sum = 0;
        Map<Integer, Integer> set = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            set.putIfAbsent(sum, i);
            if(sum==0){
                res = Math.max(res,i+1);
            }
            if(set.containsKey(sum)){
                // System.out.println("Hey"+i);
                res = Math.max(res,i - set.get(sum));
            }
        }

        return res;
    }

    static int numberOfSubarray(int arr[], int k){
        int res =0;
        int sum = 0;
        Map<Integer, Integer> set = new HashMap<>();
        set.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            set.put(sum, set.getOrDefault(sum, 0)+1);
            if(set.containsKey(sum-k)){
                res+=set.get(sum-k);
            }
        }

        if(set.containsKey(k)){
            res = set.get(k);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "race";
        String t = "care";
    	System.out.println("Valid Anagram: "+validAnagram(s, t));
        
        //Unique Elements
        Integer[] arr = {4,3,2,5,6,7,3,4,2,1};
        int[] arr2 = {1,1,2,-2,3,-1,-2};
        System.out.println("Unique Elements: "+uniqueElements(arr));
        System.out.println("Largest Subarray of Sum K: "+largestSubArray(arr2));
        System.out.println("Count of Subarray of Sum K: "+numberOfSubarray(arr2,1));
    }
}