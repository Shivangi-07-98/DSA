import java.io.*;
import java.util.*;

public class GetConnectedComponentsQ { 

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
    int edges = scn.nextInt(); // no. of edges

    ArrayList<Edge>[] graph = new ArrayList[vertices]; // not understood
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>(); // not understood
    }

    for (int i = 0; i < edges; i++) {
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      int wt = scn.nextInt();

      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean[] visited = new boolean[vertices]; 
    
    // find all connected components
    for (int i = 0; i < vertices; i++) {
      if (visited[i] == false) {
        ArrayList<Integer> comp = new ArrayList<>();
        getConnectedComponents(graph, visited, comp, i);
        comps.add(comp);
      }
    }

    System.out.println(comps);
    scn.close();
  }

  // DFS to find all vertices in a connected component
  public static void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] visited, ArrayList<Integer> comp, int src) {
    
    visited[src] = true;
    comp.add(src);
    
    // explore all neighbors
    for (Edge e : graph[src]) {
      if (visited[e.v2] == false) {
        getConnectedComponents(graph, visited, comp, e.v2);
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
// 0
// 6

// output
// [[0, 1, 2, 3], [4, 5, 6]]