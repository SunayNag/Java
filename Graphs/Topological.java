import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;



public class Topological {
    static void topSort(List<Edge> graph[]){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>(); 
        for(int i=0;i<n;i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    static void topSortUtil(List<Edge> graph[], int i, boolean vis[], Stack<Integer> st){
        vis[i]=true;
        for(Edge e: graph[i]){
            if(!vis[e.des])
            topSortUtil(graph, e.des, vis, st);
        }
        // System.out.println(i);
        st.push(i);

    }
    public static void main(String[] args) {
        int N=10;
        List<Edge> graph[] = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 5));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 6));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 7));

        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 6));
        graph[4].add(new Edge(4, 8));

        graph[5].add(new Edge(5, 7));

        graph[6].add(new Edge(6, 8));
        graph[6].add(new Edge(6, 9));

        graph[7].add(new Edge(7, 9));

        graph[8].add(new Edge(8, 9));

        // System.out.println(Arrays.toString(graph));
        topSort(graph);
    }
}
