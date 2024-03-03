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
    
    public static int gridSolve(int si, int sj,int ei, int ej){
        //base case
        if(si==ei-1&&sj==ej-1){
            return 1;
        }
        else if(si>=ei||sj>=ej){
            return 0;
        }
        
        //right
        int w1=gridSolve(si+1, sj, ei, ej);

        //down
        int w2=gridSolve(si, sj+1, ei, ej);
        return w1+w2;
    }

    public static int fact(int i){
        if(i<=0){
            return 1;
        }
        else{
            return i*fact(i-1);
        }
    }

    public static int gridSolveOpti(int si,int sj,int ei, int ej){
        int ans = (fact(ei+ej-2-si-sj))/(fact(ei-1-si)*fact(ej-1-sj));
        return ans;
    }

    public static void main(String[] args) {
        // int arr[]= new int[5];
        // arrBack(arr, 0);
        // System.out.println(Arrays.toString(arr));
        // subset("abc", new StringBuilder(), 0);
        // permutations("abc", new StringBuilder());

        System.out.println(gridSolve(0, 0, 10, 2));
        System.out.println(gridSolveOpti(0, 0, 10, 0));
    }
}