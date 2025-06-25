import java.util.Stack;

public class StackQueue {
    public static class QueueUsingStack1 {
        Stack<Integer> s1;
        Stack<Integer> s2;
        
        QueueUsingStack1(){
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        boolean isEmpty(){
            return s1.isEmpty();
        }

        void shift(Stack<Integer> s1, Stack<Integer> s2){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        void enque(int data){
            shift(s1, s2);
            s1.push(data);
            shift(s2, s1);
        }

        int deque(){
            if(s1.isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            else{
                return s1.pop();
            }
        }

        int peek(){
            if(s1.isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            else{
                return s1.peek();
            }
        }

    }

    public static class QueueUsingStack2 {
        Stack<Integer> s1;
        Stack<Integer> s2;
        
        QueueUsingStack2(){
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }

        void shift(Stack<Integer> s1, Stack<Integer> s2){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        void enque(int data){
            s1.push(data);

        }

        int deque(){
            if(s1.isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            else{
                shift(s1,s2);
                int temp = s2.pop();
                shift(s2, s1);
                return temp;
            }
        }

        int peek(){
            if(s1.isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            else{
                shift(s1,s2);
                int temp = s2.peek();
                shift(s2, s1);
                return temp;
            }
        }

    }
    
    public static void main(String[] args) {
        QueueUsingStack2 q1 = new QueueUsingStack2();
        q1.enque(0);
        q1.enque(1);
        q1.enque(2);
        q1.enque(3);
        q1.enque(4);
        q1.enque(5);

        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.deque();
        }

    }
}
