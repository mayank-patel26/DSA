import java.util.*;

class BinomialCoefficient{
    static int bincoef(int n, int k){
        int C[][] = new int[n+1][k+1];
    
        for(int i=0;i<=n;i++){
            for(int j=0;j<=min(i,k);j++){
                if(j==0 || j==i){
                    C[i][j] = 1;
                }else{
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
                }
            }
        }
        return C[n][k];
    }

    static int min(int a, int b){
        return ((a<b)?a:b);
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Enter k: ");
        int k = sc.nextInt();

        int ans = bincoef(n, k);
        System.out.println("Answer: "+ans);
        sc.close();
    }
}

//complexity: O(n*k)