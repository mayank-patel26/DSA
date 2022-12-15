import java.util.*;

public class NQueen{

    static boolean ifPossible(int board[][], int row, int col, int n){
        for(int i=0;i<col;i++){
            if(board[row][i]==1){
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }

        for(int i=row, j=col;i<n && j>=0;i++,j--){
            if(board[i][j]==1){
                return false;
            }
        }

        return true;
    }

    static boolean nQueen(int board[][], int col, int n){
        if(col>=n){
            printSoln(board);
            System.out.println();
            System.out.println();
        }else{
            for(int i=0;i<n;i++){
                if(ifPossible(board, i, col, n)){
                    board[i][col]=1;
                    nQueen(board, col+1, n);
                    board[i][col]=0;
                }
            }
        }
        return false;
    }

    static void printSoln(int board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        int board[][] = new int[n][n];

        nQueen(board, 0, n);
        sc.close(); 
    }
}