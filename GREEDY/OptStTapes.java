import java.util.*;

public class OptStTapes{

    public static double tapes(int a[], int n){
        Arrays.sort(a);
        System.out.println("Optimal order in which programs are to be stored is: ");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
            System.out.println();
        }
        double mrt = 0;
        for(int i =0;i<n;i++){
            int sum = 0;
            for(int j =0;j<=i;j++){
                sum+=a[j];
            }
            mrt+=sum;
        }
        
        mrt /= n;
        return mrt;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Mean Retrieval Time is: "+tapes(a, n));

        sc.close();
    }
}