import java.util.*;

public class Q17_OrderOfCompilation {

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
    }

    boolean[] visited = new boolean[vertices];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < vertices; i++) {
      if (visited[i] == false) {
        topologicalsort(graph, visited, i, st);
      }
    }

    while (st.size() > 0) {
      System.out.println(st.pop());
    }

    scn.close();
  }

  static void topologicalsort(ArrayList<Edge>[] graph, boolean[] visited, int src, Stack<Integer> st) {
    visited[src] = true;

    for (Edge e : graph[src]) {
      if (visited[e.v2] == false) {
        topologicalsort(graph, visited, e.v2, st);
      }
    }

    st.push(src);
  }
}

// input
// 7 (no. of vertices)
// 7 (edges)
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 4 5 10
// 5 6 10
// 4 6 10
//
// output
// 4
// 5
// 6
// 0
// 1
// 2
// 3

/*
 * TOPOLOGICAL SORT:
 * - Only for Directed Acyclic Graph (DAG)
 * - Linear ordering of vertices such that for every edge u->v, u appears before v
 * - DFS approach: Process all neighbors first, then push current node to stack
 * - Application: Order of compilation, course prerequisites, task scheduling
 */
