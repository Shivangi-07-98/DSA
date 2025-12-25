import java.util.*;

// O(V!)
// Print all paths (same as Q2) but edges stored in an adjacency matrix.
public class Q18_PrintAllPathsUsingAdjacencyMatrix {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int vertices = scn.nextInt();
    Integer[][] graph = new Integer[vertices][vertices];

    int edges = scn.nextInt(); // 8
    for (int i = 0; i < edges; i++) { // 8 baar loop chlega aur 2d matrix mai 16 jagah dalega
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      int wt = scn.nextInt();

      graph[v1][v2] = wt;
      graph[v2][v1] = wt;
    }

    int src = scn.nextInt();
    int dest = scn.nextInt();

    boolean[] visited = new boolean[vertices];
    printAllPaths(graph, visited, src, dest, src + "");
    scn.close();
  }

  private static void printAllPaths(Integer[][] graph, boolean[] visited, int src, int dest, String psf) {
    if (src == dest) {
      System.out.println(psf);
      return;
    }

    visited[src] = true;
    for (int nbr = 0; nbr < graph.length; nbr++) {
      if (graph[src][nbr] != null && !visited[nbr]) {
        printAllPaths(graph, visited, nbr, dest, psf + nbr);
      }
    }
    visited[src] = false;
  }
}

// input
// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 0
// 6

// output
// 0123456
// 012346
// 03456
// 0346
