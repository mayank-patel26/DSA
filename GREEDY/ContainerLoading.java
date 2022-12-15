import java.util.*;
class ContainerLoading{

    static void sortContainers(int arr[], int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] > arr[j]){
                    int t =arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }   

    static void solve(int arr[], int W, int n){
        sortContainers(arr, n);
        int pointer = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=W){
                pointer++;
                W = W - arr[i];
            }
        }

        System.out.println("The containers included in the ship are: ");
        for(int i=0;i<pointer;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter size of the ship: ");
        int W = sc.nextInt();

        System.out.println("Enter the containers: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        solve(arr, W, n);
        sc.close();
    }
}