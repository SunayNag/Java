public class nQueens {
    public static boolean nQueens(char board[][], int row){
        if(row==board.length){
            printBoard(board);
            count++;
            return true;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(row, i, board)){
                board[row][i]='Q';
                if(nQueens(board, row+1)){
                    return true;
                }
                board[row][i]='x';
            }
        }
        return false;
    }

    public static void nKnights(char board[][], int row){
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isSafeKnight(row, i, board)){
                board[row][i]='K';
                nKnights(board, row+1);
                
            }
        }
    }

    public static boolean isSafe(int row, int col, char board[][]){
        for(int i=row-1;i>=0;i--){
            if (board[i][col]=='Q') {
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static boolean isSafeKnight(int row,int col,char board[][]){
        if(row>=2 && col>=1){
            if(board[row-2][col-1]=='K'){
                return false;
            }
        }
        if(row>=1 && col>=2){
            if(board[row-1][col-2]=='K'){
                return false;
            }
        }
        if(row>=2 && col<board.length-1){
            if(board[row-2][col+1]=='K'){
                return false;
            }
        }
        if(row>=1 && col<board.length-2){
            if(board[row-1][col+2]=='K'){
                return false;
            }
        }
        if(row<board.length-1 && col<board.length-2){
            if(board[row+1][col+2]=='K'){
                return false;
            }
        }
        if(row<board.length-1 && col>=2){
            if(board[row+1][col-2]=='K'){
                return false;
            }
        }
        if(row<board.length-2 && col<board.length-1){
            if(board[row+2][col+1]=='K'){
                return false;
            }
        }
        if(row<board.length-2 && col>=1){
            if(board[row+2][col-1]=='K'){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]){
        System.out.println("------Chess Board-------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int count=0;
    public static void main(String[] args) {
        int n=5;
        char board[][]= new char[n][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        // nQueens(board, 0);
        // System.out.println(count);
        nKnights(board, 0);
        System.out.println(count);
    }
    
}
