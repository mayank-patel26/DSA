import java.util.*;

public class Knapsack{
    static int maxProfit = 0;

    static boolean feasible(int currentSum, int total, int W){
        if(currentSum + total >= W){
            return true;
        }   return false;
    }

    static void knapsack(int soln[], int maxProfitSoln[], int weight[], int value[], int currentSum, int total, int W, int start, int profit){

        if(feasible(currentSum, total, W)){
            if(currentSum == W){
                printSoln(soln);
                System.out.println("Profit: "+profit);
                if(profit>maxProfit){
                    maxProfit = profit;
                    for(int i=0;i<soln.length;i++){
                        maxProfitSoln[i] = soln[i];
                    }
                }
            }else{
                if(start<weight.length){
                    soln[start] = 1;
                    knapsack(soln, maxProfitSoln, weight, value, currentSum + weight[start], total - weight[start], W, start+1, profit+value[start]);

                    soln[start] = 0;
                    knapsack(soln, maxProfitSoln, weight, value, currentSum, total-weight[start], W, start+1, profit);
                }
            }
        }
    }

    static void printSoln(int soln[]){
        for(int i=0;i<soln.length-1;i++){
            System.out.print(soln[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        
        int weight[] = new int[n];
        int value[] = new int[n];
        int soln[] = new int[n+1];

        int total=0;
        System.out.println("Enter the weight of items: ");
        for(int i=0;i<n;i++){
            weight[i] = sc.nextInt();
        }
        System.out.println("Enter the profit of items: ");
        for(int i=0;i<n;i++){
            value[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            total = total + weight[i];
        }

        System.out.println("Enter the maximum weight: ");
        int W = sc.nextInt();

        int currentSum = 0;
        int maxProfitSoln[] = new int[n+1];
        int profit=0;

        knapsack(soln, maxProfitSoln, weight, value, currentSum, total, W, 0, profit);
        System.out.print("Maximum Profit: "+maxProfit+"\nSelection of items for maximum profit: ");
        printSoln(maxProfitSoln);
        sc.close();
    }
}