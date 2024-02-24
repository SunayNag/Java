import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Array2d {
    
    public static void setZeroes(int[][] matrix) {
        List<Integer> listRow = new ArrayList<Integer>();
        List<Integer> listColumn = new ArrayList<Integer>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    listRow.add(i);
                    listColumn.add(j);
                }
            }
        }
        for (int i : listRow) {
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=0;
            }
        }

        for (int i : listColumn) {
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }
    }
    public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number of rows:");
        // int rows = sc.nextInt();
        // System.out.print("Enter the number of columns:");
        // int columns = sc.nextInt();
        // int[][] numbers= new int[rows][columns];
        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<columns;j++){
        //         numbers[i][j]=10*i+j;
        //     }
        // }

        // int sear = sc.nextInt();
        // boolean found = false;

        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<columns;j++){
        //         if(numbers[i][j]==sear){
        //             System.out.println("The given element found at index ("+i+","+j+")");
        //             found = true;
        //         }
        //     }
        // }
        // if (!found) {
        //     System.out.println("Element not found in the array");
        // }
        
        int[][] matrix= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        sc.close();
        System.out.println(Arrays.deepToString(matrix));
    }
}
