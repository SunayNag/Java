import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Stack{
    Node top;
    Stack(){
        this.top=null;
    }
    public void push(int data){
        Node temp= new Node(data);
        temp.next=top;
        top=temp;
    }
    void pop(){
        if(top==null){
            System.out.println("Stack empty");
            return;
        }
        System.out.println(top.data);
        top=top.next;
    }
    public void traverse(){
        if (top==null) {
            System.out.println("Stack empty");
            return;
        }
        Node temp=top;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();

    }
}

public class StackImple{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        while(true){
            int choice = Integer.parseInt(sc.next().trim());
            switch (choice) {
                case 1:
                    s.push(Integer.parseInt(sc.next().trim()));
                    break;
                
                case 2:
                    s.pop();
                    break;
    
                case 3:
                    s.traverse();
                    break;
                case 4:
                    System.out.println("Exiting program");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        
    }
}