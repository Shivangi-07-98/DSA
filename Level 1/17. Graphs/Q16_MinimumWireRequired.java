// Prim's Algorithm
// O(E log V)
import java.io.*;
import java.util.*;

public class Q16_MinimumWireRequired {

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
    int par; // parent
    int cost;

    Pair(int vtx, int par, int cost) {
      this.vtx = vtx;
      this.par = par;
      this.cost = cost;
    }

    public int compareTo(Pair other) {
      return this.cost - other.cost;
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

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, -1, 0));
    boolean[] visited = new boolean[vertices];

    while (pq.size() > 0) {
      Pair rem = pq.remove();

      if (visited[rem.vtx] == true) {
        continue;
      }
      visited[rem.vtx] = true;

      if (rem.par != -1) { // pehla wala print nhi krna
        System.out.println("[" + rem.vtx + "-" + rem.par + "@" + rem.cost + "]");
      }

      for (Edge e : graph[rem.vtx]) {
        if (visited[e.v2] == false) {
          pq.add(new Pair(e.v2, rem.vtx, e.wt));
        }
      }
    }
    scn.close();
  }

}

// input
// 7 (no. of vertices)
// 8 (edges)
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
//
// output
// [1-0@10]
// [2-1@10]
// [3-2@10]
// [4-3@2]
// [5-4@3]
// [6-5@3]

// prim's algorithm mai jb hum next vertex pr move krenge tbh last vertex and dono ke beech ki weight, note - only last vertex and last weight not all vertex like psf and not all weight like wsf will be used

/*
 * MINIMUM SPANNING TREE (MST):
 * - Connected + Acyclic (Tree)
 * - Subset of a graph which includes all vertices, but not all edges
 * - Minimum total weight among all spanning trees
 */
