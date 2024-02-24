public class Spiral2dMatrix {
    
    public static void DiagonalSum(int[][] arr){
        int Sum=0;
        for(int i=0;i<arr.length;i++){
            Sum+=arr[i][i];
            if(i==arr.length-i-1){
                continue;
            }
            Sum+=arr[arr.length-i-1][arr.length-i-1];
        }
        System.out.println(Sum);
    } 
    
    public static boolean staircaseSearch(int[][] matrix, int key){
        int row= matrix.length-1;
        int col= 0;
        while(row>=0 && col<=matrix[0].length-1){
            if(key<matrix[0][0]||key>matrix[row][matrix[0].length-1]){
                System.out.println("Out of range");
                return false;
            }
            else if(key==matrix[row][col]){
                System.out.println("Key found at ("+row+","+col+")");
                return true;
            }
            else if(key<matrix[row][col]){
                row--;
            }
            else if(key>matrix[row][col]){
                col++;
            }
            System.out.println("Current element under search is:"+row+" "+col);
        }
        System.out.println("Key not found");
        return false;
    }

    public static void SpiralPrint(int[][] arr){
        int StartRow = 0;
        int EndRow = arr.length-1;
        int StartCol = 0;
        int EndCol = arr[0].length-1;

        while(StartRow<=EndRow && StartCol<=EndCol){
            for(int j=StartCol;j<=EndCol;j++){
                System.out.print(arr[StartRow][j]+" ");
            }
            for (int i = StartRow+1; i <= EndRow; i++) {
                System.out.print(arr[i][EndCol]+" ");
            }
            for (int j = EndCol-1; j>=StartCol; j--) {
                System.out.print(arr[EndRow][j]+" ");
            }
            for(int i=EndRow-1;i>StartRow;i--){
                System.out.print(arr[i][StartCol]+" ");
            }
            StartRow++;
            StartCol++;
            EndRow--;
            EndCol--;
        }
    }
    
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static int[][] transpose(int matrix[][]){
        int[][] transpose= new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i]=matrix[i][j];
            }
        }

        return transpose;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},
                                     {5,6,7,8},
                                     {9,10,11,12}
                                     };
        printMatrix(matrix);
        System.out.println();
        printMatrix(transpose(matrix));
        
    }
}
