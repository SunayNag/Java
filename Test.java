import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Test {
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> finalList= new ArrayList<List<Integer>>();
        List<Integer> checker2= new ArrayList<Integer>();
        List<Integer> initial = new ArrayList<Integer>();
        List<Integer> checker = new ArrayList<Integer>();
        int maxRepeat =0;
        int counter =0;
        for(int i: nums){
            if(initial.contains(i)){
                checker.add(i);
            }
            else{
                initial.add(i);
            }
        }
        System.out.println("Initial:"+Arrays.toString(initial.toArray()));
        Arrays.sort(nums);
        int j=1;
        while(j<nums.length){
            
            if(nums[j]==nums[j-1]){
                counter++;
            }
            else{counter=0;}
            if(counter>maxRepeat){
                maxRepeat=counter;
            }
            j++;
        }

        for(int i=0;i<=maxRepeat;i++) {
            System.out.println("Checker:"+Arrays.toString(checker.toArray()));
            System.out.println("Initial:"+Arrays.toString(initial.toArray()));
            System.out.println("Final:"+Arrays.toString(finalList.toArray()));
            System.out.println("Checker2:"+Arrays.toString(checker2.toArray()));
            finalList.add(new ArrayList<Integer>(initial));
            initial.clear();
            System.out.println(checker==checker2);
            for(Integer k: checker){
                if(!(initial.contains(k))){
                    initial.add(k);
                }
                else{
                    checker2.add(k);
                }
            }
            
            checker=new ArrayList<>(checker2);
            checker2.clear();
        }

        
        return finalList;
    }

    public static boolean isMatch(String s, String p) {
        int pCounter=0;
        for(int i=0;i<s.length();){
            if(i==0&&p.charAt(pCounter+1)=='*'){
                pCounter+=2;
            }
            if(pCounter==p.length()){
                return false;
            }
            
            System.out.println("s:"+s.charAt(i)+" p:"+p.charAt(pCounter)+" i:"+i+" pCounter:"+pCounter);
            if(s.charAt(i)==p.charAt(pCounter)){
                System.out.println(1);
                i++;
                pCounter++;
            }
            else if(p.charAt(pCounter)=='*'){
                System.out.println(2);
                if((s.charAt(i)==p.charAt(pCounter-1))){
                    while((i+1<=s.length())&&(s.charAt(i)==p.charAt(pCounter-1))){
                        i++;
                        System.out.println("While executed");
                    }
                    pCounter++;
                }
                else{pCounter++;}
                
            }
            else if(p.charAt(pCounter)=='.'){
                System.out.println(3);
                i++;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch2(String s, String p) {
        int pCounter=0;
        for(int i=0;i<s.length();){
            if(pCounter==p.length()){return false;}
            if(s.charAt(i)==p.charAt(pCounter)){
                i++;
                pCounter++;
            }
            else if(p.charAt(pCounter)=='*'){
                if(p.charAt(pCounter-1)=='.'){
                    i++;
                    pCounter++;
                }
                if(s.charAt(i)==p.charAt(pCounter-1)){
                    while(i+1<=s.length()&&s.charAt(i)==p.charAt(pCounter-1)){
                        i++;
                    }
                    pCounter++;
                }
                else{
                    pCounter++;
                }
            }
            else if(p.charAt(pCounter)=='.'){
                i++;
                continue;
            }
            else if(p.charAt(pCounter+1)=='*'){
                pCounter++;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        else if(s.length()==1){
            return 1;
        }
        StringBuilder checker = new StringBuilder();
        int maxLength=1;
        for(int i=0;i<s.length();i++){
            checker.setLength(0);
            checker.append(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if((checker.indexOf((Character.toString(s.charAt(j))))==-1)){
                    checker = checker.append(s.charAt(j));
                    if(checker.length()>maxLength){
                        System.out.println(checker.toString());
                        maxLength=checker.length();
                    }
                }
                else{
                    break;
                }

            }
        }
        
        return maxLength;
    }
    
    public static void scholarship(){
        Scanner sc = new Scanner(System.in);
        int age, pass, inc, arr;
        float mark, atten;
        age= sc.nextInt();
        pass= sc.nextInt();
        inc = sc.nextInt();
        arr = sc.nextInt();
        mark = sc.nextFloat();
        atten = sc.nextFloat();
        if(pass>=2021 && arr<=2 && inc<=200000 && (age<21 && age>=18) && mark>=60 && atten>=80){
            System.out.println("Eligible");
        }
        else if(arr>2 &&  mark>=80 && (inc>200000 && inc<250000)){
            System.out.println("Partially Eligible");
        }
        else{
            System.out.println("Not Eligible");
        }
        sc.close();
    }
    
    static ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        
        long s = (long)(n*(n+1))/2;
        long ssq = (long)(n*(n+1)*(2*n+1))/6;
        
        for(int i: arr){
            s-=i;
            ssq-=(long)i*i;
        }
        System.out.println(s+" "+ssq);
        
        long missing = (s+ssq/s)/2;
        long repeating = missing - s;
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int)repeating);
        result.add((int)missing);
        
        return result;
    }

    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        int currWt=0;
        int currVal=0;
        
        for(int i=0;i<n;i++){
            System.out.println(i+" "+currVal);
            if(wt[i]<=capacity){
                if(wt[i]<currWt && val[i]>currVal){
                    System.out.println("1:"+currVal);
                    currWt=wt[i];
                    currVal=val[i];
                    i++;
                }
                int newWt = currWt+wt[i];
                int newVal = currVal+val[i];
                if(newWt<=capacity && newVal>currVal){
                    System.out.println("2:"+newVal);
                    currWt=newWt;
                    currVal=newVal;
                }
            }
        }
        return currVal;
    }
    
    static Node reverse(Node head){
        Node prev=null, curr=head, next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    static int countNode(Node head){
        int count=0;
        Node ptr=head;
        while(ptr!=null){
            count++;
            ptr=ptr.next;
        }
        return count;
    }
    static Node eliminateZero(Node head){
        while(head.data==0){
            head=head.next;
        }
        return head;
    }
    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
    }

    static Node addTwoLists(Node num1, Node num2) {
        num1=eliminateZero(num1);
        num2=eliminateZero(num2);
        int count1=countNode(num1);
        int count2=countNode(num2);
        
        if(count1<count2){
            return addTwoLists(num2,num1);
        }
        
        num1=reverse(num1);
        num2=reverse(num2);
        printList(num2);
        
        int carry=0;
        Node sum = num1;
        while(num2 != null || carry != 0){
            num1.data+=carry;
            if(num2!=null){
                System.out.println(num1.data+" "+num2.data+" "+carry);
                num1.data+=num2.data;
                num2=num2.next;
                
            }
            carry=num1.data/10;
            num1.data%=10;
            if(num1.next==null && carry!=0){
                num1.next=new Node(0);
            }
            num1=num1.next;
        }
        
        sum=reverse(sum);
        
        return sum;
        
    }
    
    static int maximumProfit(int prices[]) {
        int n = prices.length;
        int total = 0;
        int buy=prices[0];
        int sell=0;
        for(int i=0;i<n-1;i++){
            System.out.println(buy+" "+prices[i]);
            if(buy>=prices[i+1]){
                sell=prices[i];
                total+=(sell-buy);
                buy=prices[i+1];
            }
        }
        if(prices[n-1]>buy){
            sell=prices[n-1];
            total+=(sell-buy);
        }
        return total;
    }

    static int countNodes(Node head){
        int count=0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    
    static int intersect(int d, Node head1, Node head2){
        Node curr1=head1;
        Node curr2=head2;
        for(int i=0;i<d;i++){
            if(curr1==null){
                return -1;
            }
            curr1=curr1.next;
        }
        while(curr1!=curr2){
            curr1=curr1.next;
            curr2=curr2.next;
            if(curr1==null || curr2==null){
                return -1;
            }
        }
        return curr1.data;
    }
    
    static int intersectPoint(Node head1, Node head2) {
        int n = countNodes(head1);
        int m = countNodes(head2);
        if(n>m){
            return intersect(n,head1,head2);
        }else{
            return intersect(n,head2,head1);
        }
    }
    public static void  main(String args[]){
    /*    // int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        // int count=1;
        //     for(int j=1;j<nums.length;j++){
        //         System.out.println(j+","+count);
        //         if(nums[j]>nums[j-1]){
        //             nums[count]=nums[j];
        //             count++;
        //         }
        //     }
            
        // System.out.println(count);
        // int[] nums = {9,8,8,4,9,8,8,3,9};
        // System.out.println(findMatrix(nums));
        // System.out.println(Arrays.toString(nums));
        // List<String> combos = new ArrayList<>();
        // System.out.println(Arrays.toString(combos.toArray()));
        // System.out.println(isMatch("aab", "c*a*b"));
        // System.out.println(isMatch2("mississippi", "mis*is*p*."));
        // System.out.println(lengthOfLongestSubstring("pwwkew"));

        // Scanner sc = new Scanner(System.in);
        // int b = 1;
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i] = sc.nextInt();
        // }   
        // int space = m;
        // for (int i=0; i<n; i++){
        //     space = m - arr[i];
        //     if(i==n-1){
        //         break;
        //     }
        //     if(space<arr[i+1]){
        //         space = m;
        //         b++;
        //     }     
        // }
        // System.out.print(b);

        // // sc.close();
        // int[] arr1 = {6,3,8,6,9,8,2,4,10,9};
        // int[] arr2 = {2,1,3,1,4,1,2,2,5,7};
        // System.out.println(8^0);

        // Node num1 = new Node(0);
        // num1.next= new Node(2);
        // num1.next.next= new Node(5);

        // Node num2 = new Node(4);
        // num2.next = new Node(5);

        // Node res = addTwoLists(num1, num2);
        // printList(res);

        // int[] stock = {86, 92, 24, 5, 34, 72, 68, 52, 27, 95, 41, 28 ,35};
        // System.out.println(maximumProfit(stock)); */

        
    }
}
