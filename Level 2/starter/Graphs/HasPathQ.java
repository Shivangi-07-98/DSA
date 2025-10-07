import java.io.*;
import java.util.*;

public class HasPathQ {

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

    int src = scn.nextInt();
    int dest = scn.nextInt();

    boolean[] visited = new boolean[vertices];
    boolean hasPath = hasPath(graph, visited, src, dest);
    System.out.println(hasPath);

    // scn.close();
  }

  public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest) {
    // self
    if (src == dest) {
      return true;
    }

    visited[src] = true;

    // children
    // for(Edge e : graph[src]){
    //   if(!visited[e.v2]){
    //     boolean hasNbrPath = hasPath(graph, visited, e.v2, dest);
    //     if(hasNbrPath){
    //       return true;
    //     }
    //   }
    // }

    for (int i = 0; i < graph[src].size(); i++) {
      Edge edge = graph[src].get(i);
      int nbr = edge.v2;
      if (visited[nbr] == false) {
        boolean pathExists = hasPath(graph, visited, nbr, dest);
        if (pathExists) {
          return true;
        }
      }
    }

    return false;
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
// true