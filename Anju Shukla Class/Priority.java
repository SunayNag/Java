import java.util.*;
class Processes{
    int pid=0;
    int wt=0;
    int tt=0;
    int at=0;
    int et=0;
    int zt = 0; 
}

public class Priority {
    public static void sortzt(List<Processes> p){
        p.sort((o1,o2)->o1.zt - o2.zt);
    }

    public static void sortAT(List<Processes> p){
        p.sort((o1,o2)->o1.at - o2.at);
    }

    // public static void sortP(List<Processes> p){
    //     p.sort((o1,o2)->o1.p - o2.p);
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tot_wt=0,tot_tt=0,tot_zt=0;
        float avg_wt=0,avg_tt=0;
        int n;

        System.out.print("Enter the number of processes: ");
        n=sc.nextInt();
        List<Processes> p= new ArrayList<Processes>();
        List<Processes> readyQuque = new ArrayList<Processes>();
        List<Processes> gantt = new ArrayList<Processes>();

        for(int i=0;i<n;i++){
            p.add(new Processes());
            System.out.print("Enter arrival time for process "+(i+1)+": ");
            p.get(i).at=sc.nextInt();
            p.get(i).pid=i+1;
        }
        
        for(int i=0;i<n;i++){
            System.out.print("Enter burst time for process "+(i+1)+": ");
            p.get(i).zt=sc.nextInt();
        }

        // for(int i=0;i<n;i++){
        //     System.out.print("Enter priority for process "+(i+1)+": ");
        //     p.get(i).p=sc.nextInt();
        // }

        sortAT(p);
        for(int i=0;i<n;i++){
            tot_zt+=p.get(i).zt;
        }
        int tracker=0;
        for(int i=0;i<=tot_zt;i++){
            for(int j=tracker;j<n;j++){
                if(p.get(tracker).at<=i){
                    readyQuque.add(p.get(tracker++));
                }
            }
            // sortP(readyQuque);
            if(!readyQuque.isEmpty()){
                for(int j=0;j<readyQuque.get(0).zt;j++){
                    i++;
                }
                readyQuque.get(0).et=i;
                gantt.add(readyQuque.get(0));
                readyQuque.remove(0);
                i--;
            }
            
        }

        for(int i=0;i<n;i++){
            p.get(i).tt=p.get(i).et-p.get(i).at;
            p.get(i).wt=p.get(i).tt-p.get(i).zt;
        }
        
        System.out.println("\nProcess ID\tArrival Time\tBurst time\tEnd time    Turnaround time\tWaiting time");
        for(int i=0;i<n;i++){
            System.out.println("    "+p.get(i).pid+"\t\t     "+p.get(i).at+"\t\t    "+p.get(i).zt+"\t\t   "+p.get(i).et+"\t\t  "+p.get(i).tt+"\t\t     "+p.get(i).wt);
            tot_tt+=p.get(i).tt;
            tot_wt+=p.get(i).wt;
        }
        System.out.println();

        avg_tt = (float)tot_tt/n;
        avg_wt = (float)tot_wt/n;
        System.out.println("Average waiting time: "+avg_wt);
        System.out.println("Average turnaround time: "+avg_tt);

        System.out.println("\nGantt Chart");
        int currTime=0;
        for(int i=0;i<n;i++){
            System.out.print("|:"+ currTime+" ");
            if(gantt.get(i).at>currTime){
                System.out.print("#|:");
                currTime+=gantt.get(i).at;
                System.out.print(currTime+" ");
            }
            System.out.print("P"+gantt.get(i).pid);
            for(int j=0;j<gantt.get(i).zt;j++){
                currTime++;
            }
        }
        System.out.println("|:"+currTime);
        sc.close();
    }
}