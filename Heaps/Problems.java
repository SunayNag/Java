import java.util.*;

public class Problems {
    static class Point{
        int x;
        int y;
        int distSq;

        Point(int x, int y){
            this.x=x;
            this.y=y;
            this.distSq = x*x + y*y;
        }

    }
    
    static class Row implements Comparable<Row>{
        int count;
        int idx;

        Row(int count, int idx){
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(r2.count==this.count){
                return this.idx-r2.idx;
            }
            else{
                return this.count-r2.count;
            }
        }
    }
    public static void main(String[] args) {
        
        //Nearest point
        int pts[][] = {{3,3},{5,-1},{-2,4},{1,1},{1,2}};
        int k=3;
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)-> a.distSq - b.distSq);
        for(int[] i: pts){
            pq.offer(new Point(i[0], i[1]));
        }
        for(int i=0;i<k;i++){
            Point p = pq.poll();
            System.out.println(p.x+" "+p.y);
        }

        //Connect N ropes with minimum cost
        int[] ropes = {2,3,3,4,6};
        PriorityQueue<Integer> rp = new PriorityQueue<>();
        for(int i: ropes){
            rp.add(i);
        }
        int cost=0;
        while(rp.size()!=1){
            int a = rp.poll();
            int b = rp.poll();
            cost+=(a+b);
            rp.add(a+b);
        }
        System.out.println(cost+" "+rp.poll());

        //Weakest soilder
        int[][] soilders = {{1,1,0,0},
                            {1,1,1,1},
                            {1,0,0,0},
                            {1,0,0,0}};
        
        PriorityQueue<Row> soilder = new PriorityQueue<>();
        for(int i=0;i<soilders.length;i++){
            int count=0;
            for(int j: soilders[i]){
                if(j==1){
                 count++;   
                }
                else{
                    break;
                }
            }
            soilder.add(new Row(count, i));
        }
        k=2;
        for(int i=0;i<k;i++){
            System.out.print("R"+soilder.poll().idx+" ");
        }
        System.out.println();
    }
}