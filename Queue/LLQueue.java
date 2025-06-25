public class LLQueue {
    static class Node{
        int data;
        Node next;

        Node(int n){
            this.data=n;
            this.next=null;
        }
    }
    static class LinkedQueue{
        Node head=null;
        Node tail=null;

        //IsEmpty function
        boolean isEmpty(){
            return head==null && tail==null;
        }

        //Add Function
        void add(int data){
            if(head==null){
                head = new Node(data);
                tail = head;
                return;
            }

            tail.next = new Node(data);
            tail=tail.next;
        }

        //Remove function
        int remove(){
            if(isEmpty()){
                System.err.println("Queue is empty");
            }

            int result = head.data;
            head=head.next;
            if(head==null){
                tail=null;
            }
            return result; 
        }

        //Peek function
        int peek(){
            return head.data;
        }

        //Print Queue
        void printQ(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

    }        
    public static void main(String[] args) {
        int n =5;
        LinkedQueue q = new LinkedQueue();
        for(int i=0;i<n;i++){
            q.add(i);
        }

        q.printQ();
        while(!q.isEmpty()){
            // q.printQ();
            System.out.println(q.remove());
            // q.remove();
        }
        q.printQ();
    }

}