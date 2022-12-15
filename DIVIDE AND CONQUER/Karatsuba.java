import java.util.*;

public class Karatsuba {
    public static long karatsuba(long x, long y){
        int n1 = getSize(x);
        int n2 = getSize(y);
        if(x<10 || y<10){
            return x*y;
        }else{
            int N = Math.max(n1, n2);
            N = (N/2) + (N%2);
            long m = (long)Math.pow(10, N);

            long a = x / m;
            long b = x - (a*m);           
            long c = y / m;
            long d = y - (c*m);

            long ac = karatsuba(a, c);
            long bd = karatsuba(b, d);
            long adbc = karatsuba(a+b, c+d);
            return ((ac * (long)Math.pow(10, 2 * N)) + ((adbc - ac - bd) * (long)Math.pow(10, N)) + bd);
        }
    }

    public static int getSize(long n){
        int count=0;
        n = (int)n;
        while(n!=0){
            count++;
            n /= 10;
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        long x = sc.nextLong();
        long y = sc.nextLong();
        long product = karatsuba(x, y);
        System.out.println("Product: "+product);
        sc.close();
    }
}

//Complexity: n^1.58