public class Bitwise {
    public static void oddEven(int numbers){
        if((numbers&1)==0){
            System.out.println("The number is even");
        }
        else{
            System.out.println("The number is odd");
        }
    }

    public static void get(int n, int i){
        if((n&(1<<i))==0){
            System.out.println("The bit at index "+i+" is 0");
        }
        else{
            System.err.println("The bit at index "+i+" is 1");
        }
    }

    public static int setBit(int n, int i){
        return n|(1<<i);
    }

    public static int clearIthBit(int n, int i){
        return n&~(1<<i);
    }

    public static int clearLastIthBit(int n, int i){
        return n&((~0)<<i);
    }

    public static int clearRange(int n, int i, int j){
        int bitMask = (-1)<<(j-i+1);
        bitMask= ~bitMask;
        bitMask<<=i;
        return n&(~bitMask);
    }

    public static int updateBit(int n, int i, int j){
        int bitMask=1<<i;
        if(j==0){
            n&=(~bitMask);
        }
        else if(j==1){
            n|=bitMask;
        }
        return n;
    }
    
    public static int countSetBits(int n){
        int count =0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }

    public static boolean PowerOfTwo(int n){
        if(n<=0){
            return false;
        }
        return (n & (n-1))==0;
    }

    public static int fastExponentiation(int n,int e){
        int ans=1;
        while(e!=0){
            if((e&1)==1){
                ans*=n;
            }
            n*=n;
            e>>=1;
        }
        return ans;
    }

    public static void swapVariables(int x, int y){
        x= x^y;
        y =x^y;
        x= x^y;
        System.out.println(x+" "+y);
    }

    public static void main(String[] args) {
        oddEven(999);
        get(15, 0);
        System.out.println(setBit(16, 1));
        System.out.println(clearIthBit(10, 3));
        System.out.println(clearLastIthBit(15,2));
        System.out.println(clearRange(2515, 2, 5));
        System.out.println(countSetBits(7));
        System.out.println(PowerOfTwo(0));
        System.out.println(updateBit(10, 3, 1));
        System.out.println(fastExponentiation(6, 5));
        swapVariables(12, 18);

    }
}
