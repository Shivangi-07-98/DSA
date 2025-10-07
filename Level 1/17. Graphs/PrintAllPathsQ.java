import java.io.*;
import java.util.*;

public class PrintAllPathsQ {

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
    printAllPaths(graph, visited, src, dest, src + "");

    // scn.close();
  }

  public static void printAllPaths(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, String psf) {
    // self
    if (src == dest) {
      System.out.println(psf);
      return;
    }

    visited[src] = true;

    // children
    // for (Edge e : graph[src]) {
    //   if (!visited[e.v2]) {
    //     printAllPaths(graph, visited, e.v2, dest, psf + e.v2 + "");
    //   }
    // }

    for (int i = 0; i < graph[src].size(); i++) {
      Edge edge = graph[src].get(i);
      int nbr = edge.v2;

      if (visited[nbr] == false) {
        printAllPaths(graph, visited, nbr, dest, psf + nbr + "");
      }
    }

    visited[src] = false;
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
// 0123456
// 012346
// 03456
// 0346
