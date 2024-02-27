import java.util.*;

public class Test {
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> finalList= new ArrayList<List<Integer>>();
        List<Integer> checker2= new ArrayList<Integer>();
        List<Integer> initial = new ArrayList<Integer>();
        List<Integer> checker = new ArrayList<Integer>();
        int maxRepeat =0;
        int counter =0;
        for(int i: nums){
            if(initial.contains(i)){
                checker.add(i);
            }
            else{
                initial.add(i);
            }
        }
        System.out.println("Initial:"+Arrays.toString(initial.toArray()));
        Arrays.sort(nums);
        int j=1;
        while(j<nums.length){
            
            if(nums[j]==nums[j-1]){
                counter++;
            }
            else{counter=0;}
            if(counter>maxRepeat){
                maxRepeat=counter;
            }
            j++;
        }

        for(int i=0;i<=maxRepeat;i++) {
            System.out.println("Checker:"+Arrays.toString(checker.toArray()));
            System.out.println("Initial:"+Arrays.toString(initial.toArray()));
            System.out.println("Final:"+Arrays.toString(finalList.toArray()));
            System.out.println("Checker2:"+Arrays.toString(checker2.toArray()));
            finalList.add(new ArrayList<Integer>(initial));
            initial.clear();
            System.out.println(checker==checker2);
            for(Integer k: checker){
                if(!(initial.contains(k))){
                    initial.add(k);
                }
                else{
                    checker2.add(k);
                }
            }
            
            checker=new ArrayList<>(checker2);
            checker2.clear();
        }

        
        return finalList;
    }

    public static boolean isMatch(String s, String p) {
        int pCounter=0;
        for(int i=0;i<s.length();){
            if(i==0&&p.charAt(pCounter+1)=='*'){
                pCounter+=2;
            }
            if(pCounter==p.length()){
                return false;
            }
            
            System.out.println("s:"+s.charAt(i)+" p:"+p.charAt(pCounter)+" i:"+i+" pCounter:"+pCounter);
            if(s.charAt(i)==p.charAt(pCounter)){
                System.out.println(1);
                i++;
                pCounter++;
            }
            else if(p.charAt(pCounter)=='*'){
                System.out.println(2);
                if((s.charAt(i)==p.charAt(pCounter-1))){
                    while((i+1<=s.length())&&(s.charAt(i)==p.charAt(pCounter-1))){
                        i++;
                        System.out.println("While executed");
                    }
                    pCounter++;
                }
                else{pCounter++;}
                
            }
            else if(p.charAt(pCounter)=='.'){
                System.out.println(3);
                i++;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch2(String s, String p) {
        int pCounter=0;
        for(int i=0;i<s.length();){
            if(pCounter==p.length()){return false;}
            if(s.charAt(i)==p.charAt(pCounter)){
                i++;
                pCounter++;
            }
            else if(p.charAt(pCounter)=='*'){
                if(p.charAt(pCounter-1)=='.'){
                    i++;
                    pCounter++;
                }
                if(s.charAt(i)==p.charAt(pCounter-1)){
                    while(i+1<=s.length()&&s.charAt(i)==p.charAt(pCounter-1)){
                        i++;
                    }
                    pCounter++;
                }
                else{
                    pCounter++;
                }
            }
            else if(p.charAt(pCounter)=='.'){
                i++;
                continue;
            }
            else if(p.charAt(pCounter+1)=='*'){
                pCounter++;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        else if(s.length()==1){
            return 1;
        }
        StringBuilder checker = new StringBuilder();
        int maxLength=1;
        for(int i=0;i<s.length();i++){
            checker.setLength(0);
            checker.append(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if((checker.indexOf((Character.toString(s.charAt(j))))==-1)){
                    checker = checker.append(s.charAt(j));
                    if(checker.length()>maxLength){
                        System.out.println(checker.toString());
                        maxLength=checker.length();
                    }
                }
                else{
                    break;
                }

            }
        }
        
        return maxLength;
    }
    
    public static void scholarship(){
        Scanner sc = new Scanner(System.in);
        int age, pass, inc, arr;
        float mark, atten;
        age= sc.nextInt();
        pass= sc.nextInt();
        inc = sc.nextInt();
        arr = sc.nextInt();
        mark = sc.nextFloat();
        atten = sc.nextFloat();
        if(pass>=2021 && arr<=2 && inc<=200000 && (age<21 && age>=18) && mark>=60 && atten>=80){
            System.out.println("Eligible");
        }
        else if(arr>2 &&  mark>=80 && (inc>200000 && inc<250000)){
            System.out.println("Partially Eligible");
        }
        else{
            System.out.println("Not Eligible");
        }
        sc.close();
    }
    public static void  main(String Args[]){
        // int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        // int count=1;
        //     for(int j=1;j<nums.length;j++){
        //         System.out.println(j+","+count);
        //         if(nums[j]>nums[j-1]){
        //             nums[count]=nums[j];
        //             count++;
        //         }
        //     }
            
        // System.out.println(count);
        // int[] nums = {9,8,8,4,9,8,8,3,9};
        // System.out.println(findMatrix(nums));
        // System.out.println(Arrays.toString(nums));
        // List<String> combos = new ArrayList<>();
        // System.out.println(Arrays.toString(combos.toArray()));
        // System.out.println(isMatch("aab", "c*a*b"));
        // System.out.println(isMatch2("mississippi", "mis*is*p*."));
        // System.out.println(lengthOfLongestSubstring("pwwkew"));

        Scanner sc = new Scanner(System.in);
        int b = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }   
        int space = m;
        for (int i=0; i<n; i++){
            space = m - arr[i];
            if(i==n-1){
                break;
            }
            if(space<arr[i+1]){
                space = m;
                b++;
            }     
        }
        System.out.print(b);
        sc.close();
    }
}
