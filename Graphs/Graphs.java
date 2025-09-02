import java.util.*;

public class Graphs {
    static class Edge{
        int src;
        int des;
        int wt;

        Edge(int s, int d, int w){
            this.src=s;
            this.des=d;
            this.wt=w;
        }
        
        @Override
        public String toString(){
            return "{Src:"+src+" Des:"+des+" Wt:"+wt+"}";
        }
    }

    static void bfs(List<Edge> graph[], int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(n);

        while (!q.isEmpty()) {
            int i= q.poll();
            if(!vis[i]){
                System.out.print(i+" ");
                vis[i]=true;
                for(Edge e: graph[i]){
                    q.add(e.des);
                }
            }
        }
        System.out.println();
    }

    static void bfsUtil(List<Edge> graph[], boolean[] vis, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int i= q.poll();
            if(!vis[i]){
                System.out.print(i+" ");
                vis[i]=true;
                for(Edge e: graph[i]){
                    q.add(e.des);
                }
            }
        }
        System.out.println();
    }

    static void bfsAll(List<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph, vis, i);
            }
        }
    }

    static void dfs(List<Edge> graph[], int n){
        Stack<Integer> q = new Stack<>();
        boolean[] vis = new boolean[graph.length];
        q.push(n);

        while (!q.isEmpty()) {
            int i= q.pop();
            if(!vis[i]){
                System.out.print(i+" ");
                vis[i]=true;
                for(Edge e: graph[i]){
                    q.push(e.des);
                }
            }
        }
        System.out.println();
    }

    static void dfsRec(List<Edge> graph[], int n, boolean vis[]){
        Stack<Integer> q = new Stack<>();
        q.push(n);

        while (!q.isEmpty()) {
            int i= q.pop();
            if(!vis[i]){
                System.out.print(i+" ");
                vis[i]=true;
                for(Edge e: graph[i]){
                    dfsRec(graph, e.des, vis);
                }
            }
        }
    }

    static void dfsFull(List<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }
    }

    static void dfsUtil(List<Edge> graph[], int n, boolean vis[]){
        Stack<Integer> q = new Stack<>();
        q.push(n);

        while (!q.isEmpty()) {
            int i= q.pop();
            if(!vis[i]){
                System.out.print(i+" ");
                vis[i]=true;
                for(Edge e: graph[i]){
                    dfsUtil(graph, e.des, vis);
                }
            }
        }
    }

    static boolean hasPath(List<Edge> graph[], int s, int e, boolean vis[]){
        if(s==e){
            return true;
        }
        vis[s]=true;
        for(Edge i: graph[s]){
            if(!vis[i.des] && hasPath(graph, i.des, e, vis)){
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int N = 9;
        List<Edge> graph[] = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }

        
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 5));
        
        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 0, 5));
        graph[2].add(new Edge(2, 4, 10));
        
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 6));
        graph[3].add(new Edge(3, 5, 7));
        
        graph[4].add(new Edge(4, 2, 10));
        graph[4].add(new Edge(4, 3, 6));
        graph[4].add(new Edge(4, 5, 3));
        
        graph[5].add(new Edge(5, 3, 6));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 4));
        
        graph[6].add(new Edge(6, 5, 4));
        
        graph[7].add(new Edge(7, 8, 8));
        graph[8].add(new Edge(8, 7, 8));
        
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)-> o1.wt - o2.wt);
        for(List<Edge> i : graph){
            Collections.sort(i, (a,b)-> a.wt-b.wt);
            for(Edge e: i){
                pq.offer(e);
            }
        }
        
        bfsAll(graph);
        dfs(graph, 0);
        dfsRec(graph, 0, new boolean[N]);
        System.out.println();
        dfsFull(graph);
        System.out.println();
        System.out.println(hasPath(graph, 0, 7, new boolean[N]));
    }
}
