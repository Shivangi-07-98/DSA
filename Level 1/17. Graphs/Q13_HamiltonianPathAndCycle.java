import java.io.*;
import java.util.*;

public class Q13_HamiltonianPathAndCycle {

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

    int src = scn.nextInt();

    boolean[] visited = new boolean[vertices];
    travelAround(graph, visited, src, 1, src + "", src);

    scn.close();
  }

  static void travelAround(ArrayList<Edge>[] graph, boolean[] visited, int src, int csf, String psf, int orig) {
    if (csf == graph.length) {
      System.out.print(psf);

      boolean closingEdgeFound = false;
      for (Edge e : graph[src]) {
        if (e.v2 == orig) {
          closingEdgeFound = true;
          break;
        }
      }

      if (closingEdgeFound == true) {
        System.out.println("* = cycle");
      } else {
        System.out.println(". = path");
      }
      return;
    }

    visited[src] = true;

    for (Edge e : graph[src]) {
      if (visited[e.v2] == false) {
        travelAround(graph, visited, e.v2, csf + 1, psf + e.v2, orig);
      }
    }

    visited[src] = false;
  }

}
// backtracking ka ques hai, backtrack krte tym saare remaining childrens visit
// ho jayenge isse saare possible paths mil jate hain.

/*
 * Hamiltonian Path ek aisa path jo graph ke SARE vertices ko exactly ek baar
 * visit kare
 * (koi vertex repeat nahi honi chahiye). Last vertex se starting vertex tak
 * edge nahi hai aur hai toh Hamiltonian Cycle
 * 
 */

// input
// 7 (no. of vertices)
// 9 (edges)
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2 5 10
// 0 (source)
//
// output
// 0123456. = path
// 0123465. = path
// 0125643* = cycle
// 0346521* = cycle
