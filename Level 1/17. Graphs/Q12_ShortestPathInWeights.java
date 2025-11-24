// O(E log V) - Dijkstra with a priority queue processes each edge once.
import java.io.*;
import java.util.*;

public class Q12_ShortestPathInWeights {

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

  static class Pair implements Comparable<Pair> {
    int vtx;
    String psf;
    int wsf;

    Pair(int vtx, String psf, int wsf) {
      this.vtx = vtx;
      this.psf = psf;
      this.wsf = wsf;
    }

    public int compareTo(Pair other) {
      return this.wsf - other.wsf;
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

    int src = scn.nextInt();

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, src + "", 0));
    boolean[] visited = new boolean[vertices];

    while (pq.size() > 0) {
      Pair rem = pq.remove();

      if (visited[rem.vtx] == true) {
        continue;
      }
      visited[rem.vtx] = true;

      System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);

      for (Edge e : graph[rem.vtx]) {
        if (visited[e.v2] == false) {
          pq.add(new Pair(e.v2, rem.psf + e.v2, rem.wsf + e.wt));
        }
      }
    }

    scn.close();
  }

}

// input
// 7 (no. of vertices)
// 9 (edges)
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0 (source)
//
// output
// 0 via 0 @ 0
// 1 via 01 @ 10
// 2 via 012 @ 20
// 5 via 0125 @ 25
// 4 via 01254 @ 28
// 6 via 01256 @ 28
// 3 via 012543 @ 30

/*
 * NOTE:
 * Dijkstra -> shortest path in terms of total weight (sum of edge weights).
 * BFT (Breadth First Traversal) -> shortest path in terms of number of edges.
 * Difference:
 * - Dijkstra priority queue use karta hai because we pick minimum weight path so far.
 * - BFT queue use karta hai because har level ek extra edge represent karta hai.
 */
