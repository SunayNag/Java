import java.util.*;

public class NormalQ {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        int n = 5;
        for(int i=1;i<=n;i++){
            q.add(i);
        }

        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.poll());
        }
    }
}
