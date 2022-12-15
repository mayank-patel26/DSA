import java.util.*;
public class Knapsack{

    static void solve(int P[], int W[], int m, int n){
        int table[][] = new int[n+1][m+1];
        int i, j;
        for(i=0;i<n+1;i++){
            for(j=0;j<m+1;j++){
                if(j==0 || i==0){
                    table[i][j] = 0;
                }else if(W[i] <= j){
                    table[i][j] = max(table[i-1][j], P[i] + table[i-1][j-W[i]]);
                }else{
                    table[i][j] = table[i-1][j];
                }
            }
        }

        System.out.println("Maximum Profit: "+table[n][m]);
    }

    static int max(int a, int b){
        return ((a>b)?a:b);
    }



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.println("Enter the maximum weight of knapsack: ");
        int m = sc.nextInt();

        int P[] = new int[n+1];
        int W[] = new int[n+1];
        P[0] = 0;
        W[0] = 0;
        System.out.println("Enter the profit of items: ");
        for(int i=1;i<n+1;i++){
            P[i] = sc.nextInt();
        }
        System.out.println("Enter the weight of items: ");
        for(int i=1;i<n+1;i++){
            W[i] = sc.nextInt();
        }

        solve(P, W, m, n);

        sc.close();

    }
}