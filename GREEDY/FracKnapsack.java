import java.util.*;

public class FracKnapsack {

    public static void sortRatio(float profit[], float weight[], float ratio[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    float temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    float temp1 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp1;

                    float temp2 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp2;
                }
            }
        }
    }

    public static void kanpsack(float profit[], float weight[], float ratio[], float m, int n) {
        double x[] = new double[n];
        for(int i=0;i<n;i++){
            x[i] = 0.0;
        }

        double tp = 0;
        int i;

        for(i=0;i<n;i++){
            if(weight[i]>m){
                break;  
            }else{
                x[i] = 1.0;
                tp = tp + profit[i];
                m = m - weight[i];
            }
        }

        if(i<n){
            x[i] = m/weight[i];
            tp = tp + (x[i]*profit[i]);
        }

        System.out.println("The result vector is: ");
        for(i=0;i<n;i++){
            System.out.println(x[i]+" ");
        }
        System.out.println("Profit: "+tp);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        float profit[] = new float[n];
        float weight[] = new float[n];
        float ratio[] = new float[n];

        System.out.println("Enter the size of knapsack: ");
        float m = sc.nextFloat();

        System.out.println("Enter the profits: ");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextFloat();
        }
        System.out.println("Enter the weights: ");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextFloat();
        }

        for (int i = 0; i < n; i++) {
            ratio[i] = profit[i] / weight[i];
        }

        sortRatio(profit, weight, ratio, n);
        kanpsack(profit, weight, ratio, m, n);

        sc.close();
    }
}

//Time complexity: O(nlogn)
