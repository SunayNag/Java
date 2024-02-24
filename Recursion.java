public class Recursion {
    public static int first = -1;
    public static int last = -1;
    public static String[] digits ={"zero ","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
    public static void decreasing(int n){
        System.out.print(n+" ");
        if(n==1){
            return;
        }
        decreasing(n-1);
    }

    public static void printIncr(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        else{
            printIncr(n-1);
            System.out.print(n+" ");
        }
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            System.out.println("Invaild");
            return 0;
        }
        return n*factorial(n-1);
    }

    public static int sumOfNatural(int n){
        if(n==1){
            return 1;
        }
        if(n<1){
            System.out.println("Invaild");
            return 0;
        }
        return n+sumOfNatural(n-1);
    }

    public static int fibbonanci(int n){
        if(n==2){
            return 1;
        }
        if(n==1){
            return 0;
        }
        if(n<1){
            System.out.println("Error");
            return 0;
        }
        return fibbonanci(n-1)+fibbonanci(n-2);
    }

    public static void sort(int[] arr, int i){
        if(i==arr.length-1 && arr[i]>arr[i-1]){
            System.out.println("Array is sorted");
            return;
        }
        if(arr[i]>arr[i-1]){
            sort(arr, i+1);
        }
        else{
            System.out.println("Array isn't sorted");
        }
    }

    public static void firstOccurence(int[] arr, int n, int i){
        if(i==arr.length){
            System.out.println("Element is not present in list");
            return;
        }
        if(arr[i]==n){
            System.out.println("Element is present in the index "+i);
            return;
        }
        else{
            firstOccurence(arr,n,i+1);
        }
        return;
    }

    public static void lastOccurence(int[] arr, int n, int i){
        if(i==-1){
            System.out.println("Element is not present in list");
            return;
        }
        if(arr[i]==n){
            System.out.println("Element is present in the index "+i);
            return;
        }
        else{
            lastOccurence(arr,n,i-1);
        }
        return;
    }
    
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        return x*power(x, n-1);
    }
    
    public static int powerOpti(int x, int n){
        if(n==0){
            return 1;
        }
        int halfPower = powerOpti(x, n/2);
        if(n%2==0){
        return halfPower*halfPower;
        }
        else{
            return halfPower*halfPower*x;
        }
    }

    public static int tileWay(int n){
        if(n==0 || n==1){
            return 1;
        }
        int vertical = tileWay(n-1);
        int horizontal = tileWay(n-2);
        return vertical+horizontal;
    }

    public static void removeDuplicate(String str, int i, StringBuilder stb, boolean[] map){
        if(i==str.length()){
            System.out.println(stb.toString());
            return;
        }
        if(map[str.charAt(i)-'a']){
            removeDuplicate(str, i+1, stb, map);
        }
        else{
            map[str.charAt(i)-'a']=true;
            removeDuplicate(str, i+1, stb.append(str.charAt(i)), map);
        }
    }
    
    public static int pairingProblem(int n){
        if(n==2|| n==1){
            return n;
        }
        return pairingProblem(n-1)+(n-1)*pairingProblem(n-2);
    }

    public static void binaryString(int n,int i, String stb){
        if(n==0){
            System.out.println(stb);
            return;
        }
        binaryString(n-1, 0, stb+"0");
        if(i==0){
        binaryString(n-1, 1, stb+"1");
        }
        StringBuilder sb=new StringBuilder("");
        sb.append(i);

    }
    
    public static void indices(int[] arr, int key,int n){
        if(arr[n]==key){
            System.out.println(n);
        }
        if(n==arr.length-1){
            return;
        }indices(arr, key, n+1);
    }

    public static void yearToWords(int n){
        if(n==0){
            return;
        }
        int lastDigit = n%10;
        yearToWords(n/10);
        System.out.print(digits[lastDigit]);

    }
    
    public static void towerOfHanoi(int n,String src,String help, String des){
        if(n==1){
            System.out.println("Transfer "+n+" from "+src+" to "+des);
            return;
        }
        towerOfHanoi(n-1, src, des, help);
        System.out.println("Transfer "+n+" from "+src+" to "+des);
        towerOfHanoi(n-1, help, src, des);
    }

    public static void stringReverse(int n, String str){
        if(n==0){
            System.out.print(str.charAt(n));
            return;
        }
        System.out.print(str.charAt(n));
        stringReverse(n-1, str);
        return;
    }
    
    public static void firstAndLast(String str, char ele, int inx){
        if(ele==str.charAt(inx)){
            if(first==-1){
                first=inx;
                last=inx;
            }
            else{
                last=inx;
            }
        }
        if(inx==str.length()-1){
            return;
        }
        firstAndLast(str, ele, inx+1);
    }
    
    public static boolean sortedCheck(int[] arr, int idx){
        if(idx>=arr.length||idx<0){
            System.err.println("Enter a valid index");
            return false;
        }
        if(idx==arr.length-1){
            if(arr[idx]>arr[idx-1]){
                return true;
            }
            else return false;
        }
        if(sortedCheck(arr, idx+1)){
            return true;
        }
        else{return false;}
    }
    public static void main(String[] args) {
        // printIncr(5);
        // System.out.println();
        // System.out.println(factorial(5));
        // System.out.println(sumOfNatural(5));
        // System.out.println(fibbonanci(9));
        // int[] arr = {1,2,3,4,5,7,10};
        // sort(arr, 1);
        // int[] arr1 = {8,3,6,9,5,10,2,5,3,6,4};
        // firstOccurence(arr1, 6, 0);
        // lastOccurence(arr1, 6, arr1.length-1);
        // System.out.println(power(-2, 10));
        // System.err.println(powerOpti(2, 10));
        // System.out.println(tileWay(6));
        // removeDuplicate("apnacollege", 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(pairingProblem(5));
        // binaryString(3, 0, "");
        // indices(new int[] {3, 2, 4, 5, 6, 2, 7, 2, 2}, 2, 0);
        // yearToWords(2019);
        // towerOfHanoi(4, "Source", "Helper", "Destination");
        // stringReverse(3,"abcd");
        firstAndLast("bcdeafgt", 'a', 0);
        System.out.println(first+" "+last);
        System.out.println(sortedCheck(new int[] {1,2,3,4,5,10,12,13,15}, 1));
    }
}
