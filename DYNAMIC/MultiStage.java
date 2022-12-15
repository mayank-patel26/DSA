import java.util.*;

public class Multi {
    static int INF = Integer.MAX_VALUE;

    static int multi(int graph[][], int N){
        int dist[] = new int[N];
        dist[N-1] = 0;

        for(int i=N-2;i>=0;i--){
            dist[i] = INF;

            for(int j=i;j<N;j++){
                if(graph[i][j] == INF){
                    continue;
                }else{
                    dist[i] = Math.min(dist[i], dist[j]+graph[i][j]);
                }
            }
        }

        return dist[0];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int N = sc.nextInt();

        int[][] graph = new int[][] { { INF, 1, 2, 5, INF, INF, INF, INF },
                { INF, INF, INF, INF, 4, 11, INF, INF },
                { INF, INF, INF, INF, 9, 5, 16, INF },
                { INF, INF, INF, INF, INF, INF, 2, INF },
                { INF, INF, INF, INF, INF, INF, INF, 18 },
                { INF, INF, INF, INF, INF, INF, INF, 13 },
                { INF, INF, INF, INF, INF, INF, INF, 2 } };

        System.out.println(multi(graph, N));

        sc.close();
    }
}