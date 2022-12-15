import java.util.*;

public class GraphColoring {

    static boolean Feasible(int graph[][], int color[], int c, int V, int v){
        for(int i=0;i<V;i++){
            if(graph[v][i]==1 && c==color[i]){
                return false;
            }
        }
        return true;
    }

    static void graphColoring(int graph[][], int m, int color[], int v, int V){
        if(v==V){
            printSoln(color, V);
        }if(v<V){
            for(int i=1;i<=m;i++){
                if(Feasible(graph, color, i, V, v)){
                    color[v] = i;
                    graphColoring(graph, m, color, v+1, V);
                    color[v] = 0;
                }
            }
        }
    }

    static void printSoln(int color[], int V){
        System.out.println("The color of vertices are: ");
        for(int i=0;i<V;i++){
            System.out.print(color[i]+" ");

        }
        System.out.println();
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter the links: ");
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the no of colors: ");
        int m= sc.nextInt();

        int color[] = new int[graph.length];
        Arrays.fill(color, 0);

        graphColoring(graph, m, color, 0, V);

        sc.close();
    }
}
