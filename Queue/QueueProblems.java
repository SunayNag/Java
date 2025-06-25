import java.util.*;

public class QueueProblems {
    public static void firstNonRepeating(String s){
        Queue<Character> q = new ArrayDeque<>();
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)+1);
            if(mp.get(c)==1){
                q.add(c);
            }

            while(!q.isEmpty() && mp.get(q.peek())>1){
                q.poll();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    
    public static void interWeave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i=0;i<size/2;i++){
            q2.add(q.poll());
        }
        for(int i=0;i<size;i++){
            if(i%2==0){
                q.add(q2.poll());
            }
            else{
                q.add(q.remove());
            }
        }
    }
    public static void main(String[] args) {
        firstNonRepeating("aabcdefgbdcefg");
        Queue<Integer> q = new ArrayDeque<>();
        int n=10;
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        System.out.println(q.toString());
        interWeave(q);
        System.out.println(q.toString());
    }
}
