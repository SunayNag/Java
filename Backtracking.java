import java.util.Arrays;

public class Backtracking{
    public static void arrBack(int[] arr, int i){
        if(i==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[i]=i+1;
        arrBack(arr, i+1);
        arr[i]=arr[i]-2;
        return;
    }

    public static void subset(String str, StringBuilder ans, int i){
        if(i==str.length()){
            System.out.println(ans.toString());
            return;
        }
        subset(str, ans.append(str.charAt(i)), i+1);
        ans.deleteCharAt(ans.length()-1);
        subset(str, ans, i+1);
    }

    public static void permutations(String str, StringBuilder ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String NewStr = str.substring(0, i) + str.substring(i+1);
            permutations(NewStr, ans.append(curr));
            ans.deleteCharAt(ans.length()-1);
        }
        
    }
    
    
    public static void main(String[] args) {
        // int arr[]= new int[5];
        // arrBack(arr, 0);
        // System.out.println(Arrays.toString(arr));
        // subset("abc", new StringBuilder(), 0);
        // permutations("abc", new StringBuilder());

        
    }
}