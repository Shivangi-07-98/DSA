// O(V + E) - build components via DFS and combine counts.
import java.io.*;
import java.util.*;

public class Q6_PerfectFriends {

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
      graph[v2].add(new Edge(v2, v1, wt));
    }

    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean[] visited = new boolean[vertices];
    
    for (int i = 0; i < vertices; i++) {
      if (visited[i] == false) {
        ArrayList<Integer> comp = new ArrayList<>();
        fillComp(graph, visited, comp, i);
        comps.add(comp);
      }
    }

    int count = 0;
    for (int i = 0; i < comps.size(); i++) {
      for (int j = i + 1; j < comps.size(); j++) {
        int si = comps.get(i).size();
        int sj = comps.get(j).size();
        int pairs = si * sj;
        count += pairs;
      }
    }

    System.out.println(count);
    scn.close();
  }

  public static void fillComp(ArrayList<Edge>[] graph, boolean[] visited, ArrayList<Integer> comp, int src) {
    
    visited[src] = true;
    comp.add(src);
    
    for (Edge e : graph[src]) {
      if (visited[e.v2] == false) {
        fillComp(graph, visited, comp, e.v2);
      }
    }
  }

}

// input
// 7 (no. of vertices)
// 5 (edges)
// 0 1 10
// 2 3 10
// 4 5 10
// 4 6 10
// 5 6 10
//
// output
// 16
