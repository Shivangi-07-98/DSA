// O(V + E) - single DFS/BFS spans all vertices to check connectivity.
import java.io.*;
import java.util.*;

public class Q5_IsGraphConnected {

  static class Edge {
    int v1;
    int v2;
    int wt;

    Edge(int v1, int v2, int wt) {
      this.v1 = v1;
      this.v2 = v2;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int vertices = scn.nextInt(); // no. of vertices

    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = scn.nextInt(); // no. of edges

    for (int i = 0; i < edges; i++) {
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      int wt = scn.nextInt();

      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    boolean[] visited = new boolean[vertices];
    
    getConnectedComponents(graph, visited, 0);
    
    boolean isConnected = true;
    for (int i = 0; i < vertices; i++) {
      if (visited[i] == false) {
        isConnected = false;
        break;
      }
    }
    
    System.out.println(isConnected);
    scn.close();
  }

  public static void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] visited, int src) {
    
    visited[src] = true;
    
    for (Edge e : graph[src]) {
      if (visited[e.v2] == false) {
        getConnectedComponents(graph, visited, e.v2);
      }
    }
  }

}

// input
// 7 (no. of vertices)
// 8 (edges)
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
//
// output
// true

// input
// 7 (no. of vertices)
// 5 (edges)
// 0 1 10
// 2 3 10
// 4 5 10
// 4 6 10
// 5 6 10
//
// output
// false

// break vs continue vs return:
// break: Exits the loop immediately, remaining iterations won't run
// continue: Skips current iteration, continues with next iteration of same loop
// return: Exits the entire function/method immediately, no code below runs
