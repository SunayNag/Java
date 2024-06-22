import java.util.*;
public class InbuiltLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.addFirst(3);
        ll.removeLast();
        System.out.println(ll); 
    }
}
