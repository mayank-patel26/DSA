import java.util.*;

class MinMax{

    static int max(int a[], int low, int high){
        if(low==high){
            return a[low];
        }else{
            int mid = (low+high)/2;
            int val1 = max(a, low, mid);
            int val2 = max(a, mid+1, high);
            if(val1>val2){
                return val1;
            }else{
                return val2;
            }
        }

    }
    
    static int min(int a[], int low, int high){
        if(low==high){
            return a[low];
        }else{
            int mid = (low+high)/2;
            int val1 = min(a, low, mid);
            int val2 = min(a, mid+1, high);
            if(val1<val2){
                return val1;
            }else{
                return val2;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        
        System.out.println("Enter the numbers: ");
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int min = min(a, 0, n-1);
        int max = max(a, 0, n-1);
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        sc.close();
    }   
}


//Complexity: O(n)