public class LinkedListPractice {
    public static class LinkedList{
        public static class Node{
            private
            int data;
            Node next;
            public 
            Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        public Node head;
        public Node tail;
        public int size;
        
        void add(int data){
            Node newNode = new Node(data);
            size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
    
            newNode.next=head;
            head=newNode;
        }
    
        void addLast(int data){
            size++;
            Node newNode = new Node(data);
            tail.next=newNode;
            tail=newNode;
        }
    
        void printList(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+"-> ");
                temp=temp.next;
            }
            System.out.println("null");
        }
        
        void add(int idx, int data){
            if(idx==0){
                add(data);
                return;
            }
            size++;
            Node temp=head;
            for(int i=1;i<idx;i++){
                if(temp.next==null){
                    System.err.println("Out of Bounds");
                    return;
                }
                temp=temp.next;
            }
            Node newNode= new Node(data);
            newNode.next=temp.next;
            temp.next = newNode;
        }
        
        void deleteFirst(){
            if(size==0){
                System.out.println("Linked List is Empty");
                return;
            }
            if(size==1){
                size--;
                head=tail=null;
                return;
            }
            size--;
            Node temp = head;
            head= head.next;
            temp.next=null;
        }

        void deleteLast(){
            Node temp=head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
            size--;
        }

        void delete(int idx){
            if(idx==0){
                deleteFirst();
                return;
            }
            if(idx==size-1){
                deleteLast();
                return;
            }
            size--;
            Node temp=head;
            for(int i=0;i<idx-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        int itreativeSearch(int key){
            if(size==0){
                return -1;
            }
            Node temp = head;
            for(int i=0;i<size;i++){
                if(temp.data==key){
                    return i;
                }
                else{
                    temp=temp.next;
                }
            }
            return -1;
        }
    
        int recursiveSearch(int key, Node lead){
            if(lead==null){
                return-1;
            }
            if(lead.data==key){
                return 0;
            }
            int i = recursiveSearch(key, lead.next);
            if(i==-1){
                return -1;
            }
            
            return i+1;
        }
    
        void reverseList(){
            Node prev=null,curr=head;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                if(next!=null);
            }
            tail=head;
            head=prev;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println(ll.size);
        ll.add(2);
        ll.printList();
        System.out.println(ll.size);
        ll.add(1);
        ll.printList();
        System.out.println(ll.size);
        ll.addLast(3);
        ll.printList();
        System.out.println(ll.size);
        ll.addLast(4);
        ll.printList();
        System.out.println(ll.size);
        ll.add(4,5);
        ll.printList();
        System.out.println(ll.size);
        System.out.println(ll.itreativeSearch(5));
        System.out.println(ll.recursiveSearch(3, ll.head));
        ll.reverseList();
        ll.printList();

    }
}
