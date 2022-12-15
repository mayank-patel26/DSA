import java.util.*;

class CoinChanging{

    static void solve(int coins[], int amt){
        int table[][] = new int[coins.length][amt+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amt+1;j++){
                if(i==0){
                    if(j!=0)
                    table[i][j] = 9999;
                }else if(coins[i] > j){
                    table[i][j] = table[i-1][j];
                }else{
                    table[i][j] = Math.min(table[i-1][j], 1 + table[i][j - coins[i]]);
                }
            }
        }
        printSoln(table);
        System.out.println("The minimum number of coins required are: "+table[coins.length-1][amt]);
    }

    static void printSoln(int table[][]){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[i].length;j++){
                System.out.print(table[i][j]+"\t\t");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of coins: ");
        int n = sc.nextInt();
        
        System.out.println("Enter the amount: ");
        int amt = sc.nextInt();

        
        int coins[] = new int[n+1];
        coins[0] = 0;
        System.out.println("Enter the coins: ");
        for(int i=1;i<n+1;i++){
            coins[i] = sc.nextInt();
        }

        solve(coins, amt);

        sc.close();
    }
}