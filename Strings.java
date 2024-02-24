import java.util.*;

public class Strings {
    //Printing all letter in a string
    public static void printingLetters(String name){
        for(int i=0;i<name.length();i++){
            System.out.println(name.charAt(i));
        }
    }
    
    public static boolean palindromeCheck(String name){
        int len = name.length();
        for(int i=0; i<len/2;i++){
            if(name.charAt(i)!=name.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String directions){
        float path;
        int x=0;
        int y=0;
        for(int i=0;i<directions.length();i++){
            if(directions.charAt(i)=='E'){
                x++;
            }
            else if(directions.charAt(i)=='W'){
                x--;
            }
            else if(directions.charAt(i)=='N'){
                y++;
            }
            else if(directions.charAt(i)=='S'){
                y--;
            }
        }
        path= (float)Math.sqrt(x*x+y*y);
        return path;
    }

    public static String getSubstring(String str,int si,int ei){
        String subs="";
        for(int i=si;i<ei;i++){
            subs=subs+str.charAt(i);
        }
        return subs;
    }

    public static String longetString(String arr[]){
        String result=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(result.compareToIgnoreCase(arr[i])<0){
                result=arr[i];
            }
        }
        return result;
    }

    public static String letterToUpper(String str){
        StringBuilder result= new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if(i==0||str.charAt(i-1)==' '){
                result.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }

    public static String compressor(String str){
        StringBuilder result= new StringBuilder();
        int count=1;
        for(int i=0; i<str.length();i++){
            if(i==str.length()-1){
                result.append(str.charAt(i));
                result.append(count);
            }
            else if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }
            else{
                result.append(str.charAt(i));
                if(count!=1){result.append(count);}
                count=1;
            }
        }
        return result.toString();
    }

    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val ){
                if(i==nums.length-1){
                    continue;
                }
                nums[i]=nums[i+1];
                continue;
            }
            count++;
        }
        return count;
    }

    public static double strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            System.out.println(haystack.substring(i,i+needle.length()));
            if(haystack.length()-i<needle.length()){
                return -1;
            }
            if(haystack.charAt(i)==needle.charAt(0) && haystack.substring(i,i+needle.length()).compareTo(needle)==0){
                return i;
            }
        }
        return -1;
    }
    
    public static int vowelCounter(String caseCounter){
        int result=0;
        Character[] arr = {'a','e','i','o','u'};
        for(int i=0;i<caseCounter.length();i++){
            if(Arrays.asList(arr).contains(caseCounter.charAt(i))){
                System.out.println(caseCounter.charAt(i));
                result++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return result;
    }

    public static boolean anagram(String word1, String word2){
        
        if(word1.length()!=word2.length()){
            return false;
        }
        else{
            char[] arr1 = word1.toCharArray();
            char[] arr2 = word2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if(arr1==arr2){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        //name=sc.nextLine();
        String fruits[]= {"apple","mango","banana"};
        name= "Sunay Nagpure";
        //String directions= "WNEENESENNN";
        Character.toUpperCase(name.charAt(2));
        System.out.println(name);
        //System.out.println(shortestPath(directions));
        
        System.out.println(palindromeCheck(name));
        // System.out.println(getSubstring(name, 3, 7));
        System.out.println(name.substring(3,7));
        System.out.println(longetString(fruits));

        // String upperCaseTest= "hello, i am optimus prime";
        // System.out.println(letterToUpper(upperCaseTest));

        // String compressTest= "aaabbcccddefgg";
        // System.out.println(compressor(compressTest));
        
        // int nums[]={3,2,2,3};
        // System.out.println(removeElement(nums, 2));
        
        // System.out.println(strStr("mississippi","issippi"));
        System.out.print("Enter the string:");
        // String caseCounter = sc.nextLine();
        // System.out.println(vowelCounter(caseCounter));

        String str = "ShradhaDidi";
        String str1 = "ApnaCollege";
        String str2 = "ShradhaDidi";
        System.out.println(str.equals(str1) + " " + str.equals(str2));
        System.out.println(anagram("carre", "racce"));
        sc.close();
    }
}