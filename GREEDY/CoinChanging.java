import java.util.*;

class CoinChanging {

    static void sortDeno(int deno[], int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(deno[i]>deno[j]){
                    int t = deno[i];
                    deno[i] = deno[j];
                    deno[j] = t;
                }
            }
        }
    }

    static void solve(int amt, int deno[], int n){
        sortDeno(deno, n);
        Vector<Integer> ans = new Vector<>();
        for(int i=n-1;i>=0;i--){
            while(amt>=deno[i]){
                ans.add(deno[i]);
                amt = amt - deno[i];
            }
        }

        System.out.println("The denominations are: ");
        for(int i=0;i<ans.size();i++){
                System.out.print(ans.elementAt(i)+" ");
        }
        System.out.println();
    }




    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        int amt = sc.nextInt();

        System.out.println("Enter the number of denominations: ");
        int n = sc.nextInt();

        int deno[] = new int[n];
        System.out.println("Enter all the denominations: ");
        for(int i=0;i<n;i++){
            deno[i] = sc.nextInt();
        }
        
        solve(amt, deno, n);
        sc.close();
    }
}
