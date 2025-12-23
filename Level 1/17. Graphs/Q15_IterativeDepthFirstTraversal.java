// O(V + E)
import java.io.*;
import java.util.*;

public class Q15_IterativeDepthFirstTraversal {

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

    int src = scn.nextInt();

    Stack<Pair> st = new Stack<>();
    st.push(new Pair(src, src + ""));
    boolean[] visited = new boolean[vertices];

    while (st.size() > 0) {
      Pair rem = st.pop();

      if (visited[rem.vtx] == true) {
        continue;
      }
      visited[rem.vtx] = true;

      System.out.println(rem.vtx + "@" + rem.psf);

      for (Edge e : graph[rem.vtx]) {
        if (visited[e.v2] == false) {
          st.push(new Pair(e.v2, rem.psf + e.v2));
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
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2 (starting vertex)
//
// output
// 2@2
// 3@23
// 4@234
// 6@2346
// 5@23465
// 0@230
// 1@2301
