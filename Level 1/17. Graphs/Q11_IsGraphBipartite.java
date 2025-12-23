// O(V + E)
import java.io.*;
import java.util.*;

public class Q11_IsGraphBipartite {

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
    int level;

    Pair(int vtx, int level) {
      this.vtx = vtx;
      this.level = level;
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

    Integer[] visited = new Integer[vertices];
    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == null) {
        boolean isBipartite = isBipartite(graph, visited, i);
        if (isBipartite == false) {
          System.out.println(false);
          scn.close();
          return;
        }
      }
    }
    System.out.println(true);
    scn.close();
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph, Integer[] visited, int src) {
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, 1));

    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited[rem.vtx] != null) {
        if (visited[rem.vtx] != rem.level % 2) { // old number != new number
          return false;
        }
      } else {
        visited[rem.vtx] = rem.level % 2; // 0 for even, 1 for odd
      }

      for (Edge e : graph[rem.vtx]) {
        if (visited[e.v2] == null) {
          queue.add(new Pair(e.v2, rem.level + 1));
        }
      }
    }

    return true;
  }

}
/*
 * BIPARTITE GRAPH DEFINITION:
 * 
 * Bipartite graph woh graph hota hai jisme hum vertices ko 2 groups mein divide
 * kar sakte hain such that ek group ki koi bhi vertex dusre group ki vertex se
 * connect ho, but same group ki vertices aapas mein connect nahi honi chahiye.
 * 
 * SIMPLE RULES:
 * 1. Acyclic graphs (trees, etc.) - Ye sab bipartite hote hain kyunki unme
 * cycle hi nahi hoti
 * 
 * 2. Cycles mein:
 * - Even length cycle -> BIPARTITE hai
 * - Odd length cycle -> NON-BIPARTITE hai
 * 
 * 3. Disconnected graph mein:
 * - Agar koi bhi ek component non-bipartite hai, toh poora graph non-bipartite
 * hai
 * - Saare components bipartite hone chahiye tabhi graph bipartite hoga
 * 
 * Example:
 * - Tree (no cycle) -> Bipartite ✓
 * - Even cycle -> Bipartite ✓
 * - Odd cycle -> Non-bipartite ✗
 * 
 */

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
// true

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
// false

// input
// 3 (no. of vertices)
// 3 (edges)
// 0 1 10
// 1 2 10
// 2 0 10
//
// output
// false
