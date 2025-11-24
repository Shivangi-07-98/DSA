// O(V + E) - BFS queue simulates infection across each edge once.
import java.io.*;
import java.util.*;

public class Q9_SpreadOfInfection {

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
    int time;

    Pair(int vtx, int time) {
      this.vtx = vtx;
      this.time = time;
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
    int t = scn.nextInt(); // time limit

    int count = 0;
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, 1));
    boolean[] visited = new boolean[vertices];

    while (queue.size() > 0) {
      // remove, mark*, work, add*
      Pair rem = queue.remove();

      if (visited[rem.vtx] == true) {
        continue;
      }
      visited[rem.vtx] = true;

      if (rem.time > t) {
        break;
      }
      count++;

      for (Edge e : graph[rem.vtx]) {
        if (visited[e.v2] == false) {
          queue.add(new Pair(e.v2, rem.time + 1));
        }
      }
    }

    System.out.println(count);
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
// 6 (starting vertex)
// 3 (time limit)
//
// output
// 4
