// O(V + E)
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
          return; // niche false print na ho issiliye
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

      // pehle se mark hai mtlb yha pauchne ke 2 raste hai mtlb cycle hai
      if (visited[rem.vtx] == true) { // khud ko check krta hai visited hai ya nhi
        return true; // ek hi jagah pr do baar pauch gye mtlb cycle hai
      }
      visited[rem.vtx] = true;

      // System.out.println(rem.vtx + "@" + rem.psf);

      for (Edge e : graph[rem.vtx]) {
        if (visited[e.v2] == false) { // nbr ko check krta hai visited hai ya nhi fir unvisited nbr ko add krega
          queue.add(new Pair(e.v2, rem.psf + e.v2));
        }
      }
    }

    return false; // agar yha tk koi cycle nhi mili toh return false
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

// CYCLIC GRAPH DEFINITION:
// A cycle is a path where the start and end are the same.
// A graph is cyclic if it contains at least one cycle.
// Connected graph: Agar cycle hai toh cyclic hai.
// In disconnected graphs, if any component contains a cycle, the whole graph is cyclic.
// Example: 3 disconnected components mein se 2 acyclic hain aur 1 cyclic hai, toh poora graph cyclic hai.
