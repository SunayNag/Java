public class Edge{
        int src;
        int des;

        Edge(int s, int d){
            this.src=s;
            this.des=d;
        }
        
        @Override
        public String toString(){
            return "{Src:"+src+" Des:"+des+"}";
        }
    }
