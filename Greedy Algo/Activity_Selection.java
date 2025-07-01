import java.util.*;;
public class Activity_Selection {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        //sorting
        int n = start.length;
        int[][] activities = new int[n][3];
        for(int i=0;i<n;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        

        //end sorted
        int maxCount =0;
        List<Integer> act = new ArrayList<>();

        maxCount++;
        act.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                // System.out.println(i+" "+start[i]+" "+ end[i]);
                act.add(i);
                maxCount++;
                lastEnd= activities[i][2];
            }
        }

        System.out.println(maxCount+" "+act);
    }
}
