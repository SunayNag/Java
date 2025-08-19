import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int N = 5;
        List<Edge> graph[] = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1, 5));
        
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        
        graph[4].add(new Edge(4, 2, 4));
        // System.out.println(Arrays.toString(graph));
        for(List<Edge> i : graph){
            System.out.println(i);
        }
    }
}
