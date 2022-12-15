import java.util.*;
class MatrixChain{
    static void solve(int matrixSize[]){
        int n = matrixSize.length;
        int dp[][] = new int[n][n];
        int i, j ,k;
        for(int d=1;d<n-1;d++){
            for(i=1;i<n-d;i++){
                j = i+d;
                int min = Integer.MAX_VALUE;
                for(k=i;k<j;k++){
                    int q = dp[i][k] + dp[k+1][j] + (matrixSize[i-1]*matrixSize[k]*matrixSize[j]); 
                    if(q<min){
                        min=q;
                    }
                }
                dp[i][j] = min;

            }
        }
        printSoln(dp, n);
    }

    static void printSoln(int dp[][], int n){
        System.out.println("DP Matrix is: ");
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                System.out.print(dp[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("Minimum number of multiplications is: "+dp[1][n-1]);
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of matrices: ");
        int n = sc.nextInt();
        int matrixSize[] = new int[n+1];
        System.out.println("Enter the matrix size: ");
        for(int i=0;i<n+1;i++){
            matrixSize[i] = sc.nextInt();
        }
        solve(matrixSize);

        sc.close();
    }
}

//Time complexity: O(n^3)
//Space: O(n^2)