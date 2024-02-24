import java.util.*;
public class Sorting {
    public static void BubbleSort(int[] array){
        int temp;
        boolean swapped;
        for(int i=0;i<array.length-1;i++){
            swapped= false;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swapped= true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void SelectionSort(int[] array){
        for(int i=0;i<array.length;i++){
            int minPos=i;
            for(int j=i+1;j<array.length;j++){
                if(array[minPos]>array[j]){
                    minPos=j;
                }
            }
            int temp=array[minPos];
            array[minPos]=array[i];
            array[i]=temp;
        }
    }

    public static void InsertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            System.out.println(i+":-");
            int curr=array[i];
            int prev= i-1;
            while (prev>=0 && array[prev]>curr) {
                for(int j=0;j<array.length;j++){
                System.out.print(array[j]+" ");
                }
                array[prev+1]=array[prev];
                prev--;
                System.out.println();
            }
            array[prev+1]=curr;
            for(int j=0;j<array.length;j++){
                System.out.print(array[j]+" ");
                }
                System.out.println();
        }    
    }
    public static void main(String[] args) {
        int[] array = new int[] {10,11,14,3,5,2,8,4,9};
        //InsertionSort(array);
        Arrays.sort(array);
        for(int j=0;j<array.length;j++){
            System.out.print(array[j]+" ");
        }
        double result = (double)5/2;
        System.out.println(result);
    }
}
