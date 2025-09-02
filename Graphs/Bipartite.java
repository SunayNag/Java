import java.util.*;

public class Bipartite {
    
    static boolean isBipart(List<Edge> graph[]){
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!isBipartUtil(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isBipartUtil(List<Edge>[] graph, int src, int color[]){
        color[src]= 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        while(!q.isEmpty()){
            int n = q.poll();
            for(Edge e: graph[n]){
                if(color[e.des]==-1){
                    color[e.des] = color[e.src]==0?1:0;
                    q.offer(e.des);
                    
                }
                else if(color[e.des]==color[n]){
                    return false;
                }
                
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int N=5;
        List<Edge> graph[] = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 0));
        
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 0));

        System.out.println(isBipart(graph));
    }
}
