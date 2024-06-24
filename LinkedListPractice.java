public class LinkedListPractice {
    public static class Linked_List{
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
            if(idx==size){
                tail=tail.next;
            }
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
            while(temp!=tail){
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

        void removeNthNode(int n){
            if(n==size){
                deleteFirst();
                return;
            }
            if(n==1){
                deleteLast();
                return;
            }
            Node prev=null;
            Node temp=head;
            int i=0;
            for(;i<size-n;i++){
                prev=temp;
                temp=temp.next;
            }
            prev.next=temp.next;
        }

        Node findMiddle(Node head){
            Node slow, fast;
            slow=fast=head;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }

        boolean isPalindrome(){
            if(head==null || head.next==null);
            
            //Step 1
            Node mid= findMiddle(head);

            //Step 2
            Node prev=null, curr=mid, next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node right= prev;
            Node left = head;

            //step 3
            while(right!=null){
                if(right.data!=left.data){
                    return false;
                }
                left=left.next;
                right=right.next;
            }

            return true;
        }

        boolean hasCycle(){
            Node slow=head,fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    return true;
                }
            }
            return false;
        }

        void removeLoop(){
            Node slow=head,fast=head, prev=null;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    slow=head;
                    break;
                }
            }
            while (slow!=fast) {
                prev=fast;
                slow=slow.next;
                fast=fast.next;
            }
            prev.next=null;
            return;
        }

        private Node merge(Node leftHead, Node rightHead){
            Node mergedLL = new Node(-1);
            Node temp = mergedLL;
            while(leftHead!=null && rightHead!=null){
                if(leftHead.data<rightHead.data){
                    temp.next = leftHead;
                    leftHead = leftHead.next;
                }
                else{
                    temp.next = rightHead;
                    rightHead = rightHead.next;
                }
                temp=temp.next;
            }

            while (leftHead!=null) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp=temp.next;
            }
            while (rightHead!=null) {
                temp.next =rightHead;
                rightHead = rightHead.next;
                temp=temp.next;
            }
            return mergedLL.next;
        }

        Node mergeSort(Node head){
            if(head==null || head.next==null){
                return head;
            }
            
            Node slow= head;
            Node fast = head.next;
            Node rightHead;
            
            //find mid
            while(fast!=null && fast.next!=null){
                slow= slow.next;
                fast = fast.next;
            }
            rightHead= slow.next;
            slow.next=null;

            //left right MS
            Node newLeft = mergeSort(head);
            Node newRight= mergeSort(rightHead);

            //merge
            return merge(newLeft, newRight);
        }

        void zigzag(){
            Node temp1=head;
            Node mid = findMiddle(head);
            Node prev=null, curr=mid, next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            while(temp1!=null&&tail.next!=null){
                System.out.println(tail.data);
                next=temp1.next;
                temp1.next=tail;
                temp1=next;
                next=tail.next;
                tail.next= temp1;
                tail=next;
            }
        }
    }

    public static void main(String[] args) {
        Linked_List ll = new Linked_List();
        ll.add(2);
        ll.add(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.printList();
        // System.out.println(ll.size);
        // ll.add(4,1);
        // ll.printList();
        // System.out.println(ll.size);
        // System.out.println(ll.itreativeSearch(5));
        // System.out.println(ll.recursiveSearch(3, ll.head));
        // ll.reverseList();
        // // ll.removeNthNode(1);
        // ll.removeNthNode(3);
        // ll.printList();
        // System.out.println(ll.isPalindrome());

        Linked_List ll2 = new Linked_List();
        ll2.add(1);
        ll2.add(2);
        ll2.add(3);
        ll2.add(4);
        ll2.add(6);
        ll2.add(7);
        // ll2.add(8);
        // ll2.tail.next = ll2.head.next;
        // System.out.println(ll2.hasCycle());
        // ll2.removeLoop();
        // ll2.printList();
        // ll2.head = ll2.mergeSort(ll2.head);
        // ll2.printList();

        ll.zigzag();
        ll.printList();
    }
}
