import java.util.*;
public class StackImple {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp = s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder strb = new StringBuilder("");
        while(!s.isEmpty()){
            // System.out.println(s.peek());
            strb.append(s.pop());
        }
        return strb.toString();
    }
    
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
        return;
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    public static void stockSpan(int[] stock, int span[]){
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<stock.length;i++){
            if(s.isEmpty()){
                span[i]=i+1;
                s.push(null);
            }
            while(stock[i]>=stock[s.peek()]){
                s.pop();
            }
            if(stock[i]<stock[s.peek()]){
                span[i]=i-s.peek();
                s.push(i);
            }
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        // System.out.println(s.isEmpty());
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // reverseStack(s);
        // printStack(s);
        // String str = "Sunay";
        // System.out.print(reverseString(str));
        int[] stock = {100,80,60,70,60,85,100};
        int[] span = new int[stock.length];
        stockSpan(stock, span);
        System.out.println(span);
    }
}