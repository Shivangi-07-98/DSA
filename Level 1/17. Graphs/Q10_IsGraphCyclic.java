import java.io.*;
import java.util.*;

public class Q10_IsGraphCyclic {

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

  static class Pair {
    int vtx;
    String psf;

    Pair(int vtx, String psf) {
      this.vtx = vtx;
      this.psf = psf;
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
    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == false) {
        boolean isCyclic = isCyclic(graph, visited, i);
        if (isCyclic == true) {
          System.out.println(true);
          scn.close();
          return;
        }
      }
    }
    System.out.println(false);
    scn.close();
  }

  public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, src + ""));

    while (queue.size() > 0) {
      // remove, mark*, work, add*
      Pair rem = queue.remove();

      if (visited[rem.vtx] == true) {
        return true;
      }
      visited[rem.vtx] = true;

      // System.out.println(rem.vtx + "@" + rem.psf);

      for (int i = 0; i < graph[rem.vtx].size(); i++) {
        Edge e = graph[rem.vtx].get(i);
        if (visited[e.v2] == false) {
          queue.add(new Pair(e.v2, rem.psf + e.v2));
        }
      }
    }

    return false;
  }

}

// input
// 7 (no. of vertices)
// 6 (edges)
// 0 1 10
// 1 2 10
// 2 3 10
// 3 4 10
// 4 5 10
// 5 6 10
//
// output
// false

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
