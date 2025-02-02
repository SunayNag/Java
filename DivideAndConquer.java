import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DivideAndConquer {
    public static void mergeSortString(String[] arr,int si,int ei){
        if(si>=ei){
            return;
        }

        int mid = si+(ei-si)/2;
        mergeSortString(arr, si, mid);
        mergeSortString(arr, mid+1, ei);
        mergeString(arr,si,mid,ei);
    }

    public static void mergeString(String[] arr, int si, int mid, int ei){
        String[] temp = new String[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while (i<=mid && j<=ei) {
            if(arr[i].compareTo(arr[j])<0){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=ei) {
            temp[k++]=arr[j++];
        }

        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void mergeSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        
        int mid = si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si+1];
        int i= si;
        int j = mid+1;
        int k =0;
        
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0, i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]= temp;
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int piv = arr[ei];
        int i = si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=piv){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, ei);
        quickSort(arr, si, i-1);
        quickSort(arr, i+1, ei);
    }
    
    public static int rotatedAndSorted(int[] arr, int n,int si, int ei){
        if(si>ei){
            return -1;
        }
        int mid = si +(ei-si)/2;
        if(arr[mid]==n){
            return mid;
        }
        if(arr[si]<=arr[mid]){
            if(arr[si]<=n && n<= arr[mid]){
                return rotatedAndSorted(arr, n, si, mid-1);
            }
            else{
                return rotatedAndSorted(arr, n, mid+1, ei);
            }
        }
        else if(arr[mid]<=arr[ei]){
            if(arr[mid]<=n&&n<=arr[ei]){
                return rotatedAndSorted(arr, n, mid+1, ei);
            }
            else{
                return rotatedAndSorted(arr, n, si, mid-1);
            }
        }
        return -1;
    }
    
    public static int rotatedAndSortedIteration(int[] arr, int n){
        int si=0;
        int ei=arr.length-1;
        int mid;
        while(si<=ei){
            mid= si + (ei-si)/2;
            if(arr[mid]==n){
                return mid;
            }
            if(arr[si]<=arr[mid]){
                if(arr[si]<=n && n<=arr[mid]){
                    ei=mid-1;
                }
                else{
                    si=mid+1;
                }
            }
            else if(arr[mid]<=arr[ei]){
                if(arr[mid]<=n && n<=arr[ei]){
                    si=mid+1;
                }
                else{
                    ei=mid-1;
                }
            }
        }
        return -1;
    }
    
    public static int countElemnt(int arr[], int n, int si, int ei){
        if(si==ei){
            return arr[si]==n ? n:-1; 
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                count++;
            }
        }
        return count;
    }
    
    public static int majority(int[] arr, int si, int ei){
        if(si>=ei){
            return arr[si];
        }

        int mid = si +(ei-si)/2;
        int left = majority(arr, si, mid);
        int right = majority(arr,mid+1, ei);
        if(left==right){
            return left;
        }

        int leftCount = countElemnt(arr, left, si, mid);
        int rightCount = countElemnt(arr, right, mid+1, ei);

        if(leftCount==rightCount){System.out.println(left+" & "+right+" are in equal numbers with count of "+leftCount);}
        return leftCount>rightCount ? left:right;
    }
    
    public static int binarysearch(int[] arr, int k) {
        int n = arr.length-1;
        int start = 0;
        int end = n;
        int mid = (n/2)+1;
        if(arr[0]>k || arr[n]<k) return -1;
        while(arr[mid]!=k){
            System.out.println("Before:"+start+" "+end);
            if(arr[mid]<k){
                start=mid+1;
                mid=start+(end-start)/2;
            }
            else if(arr[mid]>k){
                end=mid-1;
                mid=start+(end - start)/2;
            }
            System.out.println("After:"+start+" "+end);
            if(arr[mid]!=k && start>=end){
                return -1;
            }
        }
        while(mid!=0 && arr[mid-1]==arr[mid]){
            mid--;
        }
        return mid;
    }
    public static void main(String[] args) {
        int[] arr = {1,9,5,6,3,7,2,8,4};
        mergeSort(arr, 0, arr.length-1);

        // quickSort(arr, 0, arr.length-1);
        // System.out.println(Arrays.toString(arr));
        // int[] arr2 ={4,5,6,7,1,2,3};
        // System.out.println(rotatedAndSortedIteration(arr2, 2));

        // String[] arr1 = {"sun", "earth", "mercury", "mars","venus","jupiter","saturn","uranus","neptune"};
        // mergeSortString(arr1, 0, arr1.length-1);
        // System.out.println(Arrays.toString(arr1));
        int[] arr3= {5,7,3,6,1,10,5,14};

        // System.out.println("Final result:"+majority(arr3, 0,arr3.length-1));

        int[] arr4 = {1,2,5,6,8,9};
        // System.out.println(binarysearch(arr4, 1));
        int a1 = arr3.length;
        int b1 = arr4.length;
        int[] c = new int[a1+b1];
        System.arraycopy(arr3,0,c,0,a1);
        System.arraycopy(arr4,0,c,a1,b1);
        Set<Integer> s = new HashSet<Integer>();
        for(int i: arr4){
            s.add(i);
        }
        for(int i: arr3){
            s.add(i);
        }
        System.out.println(s);
        ArrayList<Integer> a = new ArrayList<>(s);
        System.out.println(a);
        a.sort(null); 
        
    }
}
