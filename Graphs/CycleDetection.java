import java.util.*;

public class CycleDetection {
    
    static boolean detectCycle(List<Edge> graph[]){
        int n= graph.length;
        boolean vis[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, i, -1, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycleUtil(List<Edge> graph[], int src, int par, boolean vis[]){
        vis[src]=true;
        for(Edge e: graph[src]){
            if(!vis[e.des]){
                if(detectCycleUtil(graph, e.des, e.src, vis)) return true;
            }
            else if(vis[e.des] && e.des!=par){
                return true;
            }
        }

        return false;
    }

    static boolean detectCycleDir(List<Edge> graph[]){
        int n= graph.length;
        boolean vis[] = new boolean[n];
        boolean st[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(detectCycleUtilDir(graph, i, -1, vis, st)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycleUtilDir(List<Edge> graph[], int src, int par, boolean vis[], boolean st[]){
        vis[src]=true;
        st[src]=true;
        for(Edge e: graph[src]){
            if(st[e.des]){
                return true;
            }
            if(!vis[e.des]){
                if(detectCycleUtilDir(graph, e.des, e.src, vis,st)) return true;
            }
            
        }
        st[src]=false;

        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int N = 5;
        List<Edge> graph[] = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

        int N1 = 4;
        List<Edge> graph2[] = new ArrayList[N1];
        for(int i=0;i<N1;i++){
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(new Edge(0, 1));
        graph2[0].add(new Edge(0, 2));
        
        graph2[1].add(new Edge(1, 3));

        graph2[2].add(new Edge(2, 3));

        graph2[3].add(new Edge(3, 1));

        System.out.println(detectCycle(graph));
        System.out.println(detectCycleDir(graph2));
    }
}
