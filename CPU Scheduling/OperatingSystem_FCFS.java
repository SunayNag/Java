import java.util.*;
public class OperatingSystem_FCFS {
    public static void sortAT(List<Processes> p){
        p.sort((o1,o2)->o1.at - o2.at);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tot_wt=0,tot_tt=0;
        float avg_wt=0,avg_tt=0;
        int n;
        List<Processes> readyQuque = new ArrayList<Processes>();

        System.out.print("Enter the number of processes: ");
        n=sc.nextInt();
        List<Processes> p= new ArrayList<Processes>();
        for(int i=0;i<n;i++){
            p.add(new Processes());
            System.out.print("Enter arrival time for process "+(i+1)+": ");
            p.get(i).at=sc.nextInt();
            p.get(i).pid=i+1;
        }

        for(int i=0;i<n;i++){
            System.out.print("Enter burst time for process "+(i+1)+": ");
            p.get(i).bt=sc.nextInt();
        }

        sortAT(p);

        int tot_bt=0;
        for(int i=0;i<n;i++){
            tot_bt+=p.get(i).bt;
        }
        int tracker=0;
        for(int i=0;i<=tot_bt;i++){
            for(int j=tracker;j<n;j++){
                if(p.get(tracker).at<=i){
                    readyQuque.add(p.get(tracker++));
                }
            }
            if(!readyQuque.isEmpty()){
                for(int j=0;j<readyQuque.get(0).bt;j++){
                    i++;
                }
                readyQuque.get(0).et=i;
                readyQuque.remove(0);
                i--;
            }
            
        }
        for(int i=0;i<n;i++){
            p.get(i).tt=p.get(i).et-p.get(i).at;
            p.get(i).wt=p.get(i).tt-p.get(i).bt;
        }

        System.out.println("\nProcess ID\tArrival Time\tBurst time\tEnd time    Turnaround time\tWaiting time");
        for(int i=0;i<n;i++){
            System.out.println("    "+p.get(i).pid+"\t\t     "+p.get(i).at+"\t\t    "+p.get(i).bt+"\t\t   "+p.get(i).et+"\t\t  "+p.get(i).tt+"\t\t     "+p.get(i).wt);
            tot_tt+=p.get(i).tt;
            tot_wt+=p.get(i).wt;
        }
        System.out.println();

        avg_tt = (float)tot_tt/n;
        avg_wt = (float)tot_wt/n;
        System.out.println("Average waiting time: "+avg_wt);
        System.out.println("Average turnaround time: "+avg_tt);

        int currTime=0;
        for(int i=0;i<n;i++){
            System.out.print("|:"+ currTime+" ");
            System.out.print("P"+p.get(i).pid);
            for(int j=0;j<p.get(i).bt;j++){
                currTime++;
            }
        }
        System.out.println("|:"+currTime);
        sc.close();
    }
}

class Processes{
    int pid=0, at=0, bt=0, et=0,wt=0, tt=0;
}
