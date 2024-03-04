import java.util.Arrays;

public class Backtracking{
    public static void arrBack(int[] arr, int i){
        if(i==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[i]=i+1;
        arrBack(arr, i+1);
        arr[i]=arr[i]-2;
        return;
    }

    public static void subset(String str, StringBuilder ans, int i){
        if(i==str.length()){
            System.out.println(ans.toString());
            return;
        }
        subset(str, ans.append(str.charAt(i)), i+1);
        ans.deleteCharAt(ans.length()-1);
        subset(str, ans, i+1);
    }

    public static void permutations(String str, StringBuilder ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String NewStr = str.substring(0, i) + str.substring(i+1);
            permutations(NewStr, ans.append(curr));
            ans.deleteCharAt(ans.length()-1);
        }
        
    }
    
    public static int gridSolve(int si, int sj,int ei, int ej){
        //base case
        if(si==ei-1&&sj==ej-1){
            return 1;
        }
        else if(si>=ei||sj>=ej){
            return 0;
        }
        
        //right
        int w1=gridSolve(si+1, sj, ei, ej);

        //down
        int w2=gridSolve(si, sj+1, ei, ej);
        return w1+w2;
    }

    public static int fact(int i){
        if(i<=0){
            return 1;
        }
        else{
            return i*fact(i-1);
        }
    }

    public static int gridSolveOpti(int si,int sj,int ei, int ej){
        int ans = (fact(ei+ej-2-si-sj))/(fact(ei-1-si)*fact(ej-1-sj));
        return ans;
    }

    public static boolean sudokuSolver(int[][] sudoku,int row,int col){
        //base
        if(row==9 ){
            return true;
        }
        //recursion
        int nextRow=row, nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit){
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i]==digit){
                return false;
            }
        }

        //grid
        int startRow= row-row%3, startCol= col-col%3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            } 
        }

        return true;
    }

    public static void printSudoku(int[][] sudoku){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku.length;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int arr[]= new int[5];
        // arrBack(arr, 0);
        // System.out.println(Arrays.toString(arr));
        // subset("abc", new StringBuilder(), 0);
        // permutations("abc", new StringBuilder());

        // System.out.println(gridSolve(0, 0, 10, 2));
        // System.out.println(gridSolveOpti(0, 0, 10, 0));

        int sudoku[][]= {
        {0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}
        };

        if(sudokuSolver(sudoku, 0, 0)){
            printSudoku(sudoku);
        }
    }
}