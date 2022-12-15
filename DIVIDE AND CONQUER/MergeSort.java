import java.util.*;

class MergeSort{
    static void merge(int a[], int lb, int mid, int ub){
        int n1 = mid - lb + 1;
        int n2 = ub - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = a[lb+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = a[mid+i+1];
        }

        int i = 0;
        int j = 0;
        int k = lb;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }else{
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            a[k] = L[i];
            i++;
            k++;
        }
        
        while(j<n2){
            a[k] = R[j];
            j++;
            k++;
        }

    }

    static void mergesort(int a[], int lb, int ub){
        if(lb<ub){
            int mid = lb+(ub-lb)/2;
            mergesort(a, lb, mid);
            mergesort(a, mid+1, ub);
            merge(a, lb, mid, ub);
        }
    }

    static void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter numbers: ");
        for(int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }

        mergesort(a, 0, n-1);
        printArray(a);

        sc.close();
    }
}

//Time complexity: O(nlogn)