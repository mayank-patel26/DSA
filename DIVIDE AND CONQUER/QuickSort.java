import java.util.*;

class QuickSort {

    static void quicksort(int a[], int lb, int ub) {
        if(lb<ub){
            int pivot = pivot(a, lb, ub);
            quicksort(a, lb, pivot-1);
            quicksort(a, pivot+1, ub);
        }
    }

    static int pivot(int a[], int lb, int ub) {
        int pivot = a[ub];
        int leftPointer = lb;
        int rightPointer = ub;

        while (leftPointer < rightPointer) {
            while(a[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(a[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            int t = a[leftPointer];
            a[leftPointer] = a[rightPointer];
            a[rightPointer] = t;
        }
        int t = a[leftPointer];
        a[leftPointer] = a[ub];
        a[ub] = t; 

        return leftPointer;
    }

    static void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter numbers: ");
        for(int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }

        quicksort(a, 0, a.length-1);
        printArray(a);
        
        sc.close();
    }
}

//Time complexity: O(nlogn) 
//Worst case: O(n^2)
