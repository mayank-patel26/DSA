import java.util.*;

class LCS{

    static void solve(String s1, String s2){
        int table[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                if(i==0 || j==0){
                    continue;
                }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    table[i][j] = 1 + table[i-1][j-1];
                }else{
                    table[i][j] = max(table[i-1][j], table[i][j-1]);
                }
            }  
        }

        System.out.println("The number of Longest Common Subsequence are: "+table[s1.length()][s2.length()]);
    }

    static int max(int a, int b){
        return ((a>b)?a:b);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String A: ");
        String s1 = sc.nextLine();
        System.out.println("Enter String B: ");
        String s2 = sc.nextLine();

        solve(s1, s2);
        sc.close();
    }
}