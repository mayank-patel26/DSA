import java.util.*;

public class SumOfSubsets {

    static boolean feasible(int currentSum, int total, int target) {
        if (currentSum + total >= target) {
            return true;
        }
        return false;

    }

    static void sumofsubsets(int soln[], int weight[], int currentSum, int total, int start, int target) {

        if (feasible(currentSum, total, target)) {
            if (currentSum == target) {
                printSoln(soln);
                for(int i=0;i<weight.length;i++){
                    if(soln[i]==1){
                        System.out.print(weight[i]+" ");
                    }
                }
                System.out.println();
            } else {
                if (start < weight.length) {
                    soln[start] = 1;
                    sumofsubsets(soln, weight, currentSum + weight[start], total - weight[start], start + 1, target);
                    soln[start] = 0;
                    sumofsubsets(soln, weight, currentSum, total - weight[start], start + 1, target);
                }
            }
        }
    }

    static void printSoln(int soln[]) {
        for (int i = 0; i < soln.length; i++) {
            System.out.print(soln[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items: ");
        int n = sc.nextInt();
        int weight[] = new int[n];
        System.out.println("Enter the weights: ");
        int total = 0;
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            total = total + weight[i];
        }

        System.out.println("Enter target weight: ");
        int target = sc.nextInt();

        int soln[] = new int[n + 1];
        int currentSum = 0;

        sumofsubsets(soln, weight, currentSum, total, 0, target);

        sc.close();
    }
}