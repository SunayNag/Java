import java.util.Arrays;

public class ArrayQueue {
    static class AQueue{
        static int arr[];
        static int size;
        static int rear;

        AQueue(int n){
            arr = new int[n];
            size = n;
            rear =-1;
        }

        //isEmpty function
        boolean isEmpty(){
            return rear==-1;
        }

        //Add finction
        void add(int data){
            if(rear==size-1){
                System.err.println("Queue is full");
                return;
            }
            rear++;
            arr[rear]=data;
            return;
        }

        //Remove function
        int remove(){
            if(isEmpty()){
                System.err.println("Empty queue");
                return -1;
            }

            int front=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }

        

        //Peek function
        int peek(){
            if(isEmpty()){
                System.err.println("Empty queue");
                return -1;
            }

            return arr[0];
        }
    }

    static class ACQueue{
        int arr[];
        int size;
        int rear;
        int front;

        ACQueue(int n){
            arr = new int[n];
            size = n;
            front =-1;
            rear=-1;
        }

        //isEmpty function
        boolean isEmpty(){
            return (front==-1 && rear==-1);
        }

        boolean isFull(){
            return ((rear+1)%size==front);
        }

        //Add finction
        void add(int data){
            if(isFull()){
                System.err.println("Queue is full");
                return;
            }

            if(front==-1){
                front++;
            }
            rear=(rear+1)%size;
            arr[data]=data;
            return;
        }

        //Remove function
        int remove(){
            if(isEmpty()){
                System.err.println("Empty queue");
                return -1;
            }

            int frontE=arr[front];

            if(rear==front){
                front=rear=-1;
            }
            else{
                front=(front+1)%size;
            }
            return frontE;
        }

        //Peek function
        int peek(){
            if(isEmpty()){
                System.err.println("Empty queue");
                return -1;
            }

            return arr[front];
        }

        void printQ(){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int n =5;
        ACQueue q = new ACQueue(n);
        for(int i=0;i<n;i++){
            q.add(i);
        }

        // q.printQ();
        while(!q.isEmpty()){
            q.printQ();
            System.out.println(q.peek());
            q.remove();
        }
    }
}
