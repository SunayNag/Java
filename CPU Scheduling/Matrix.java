import java.util.*;
public class Matrix {
    public static void printArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,n;
        System.out.print("Enter the number of rows:");
        m=sc.nextInt();
        System.out.print("Enter the number of columns:");
        n=sc.nextInt();
        int count=1;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=count++;
            }
        }
        printArray(arr);
        
        int[] prodArr= new int[n];
        for(int j = 0; j < n; j++){
            prodArr[j]=1;
            for (int i=0;i<m;i++){
                prodArr[j]*=arr[i][j];
            }
        }
        System.out.println();
        for(int i=0; i<n ;i++){
            System.out.print(prodArr[i]+"\t");
        }
        sc.close();
    }
}
