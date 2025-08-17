import java.io.*;
import java.util.*;

public class MultisolverQ {

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
    int wsf;
    String psf;

    Pair(int wsf, String psf) {
      this.wsf = wsf;
      this.psf = psf;
    }

    public int compareTo(Pair o) {
      return this.wsf - o.wsf;
    }
  }

  static String spath = "";
  static Integer spathwt = Integer.MAX_VALUE;
  static String lpath = "";
  static Integer lpathwt = Integer.MIN_VALUE;
  static String cpath = "";
  static Integer cpathwt = Integer.MAX_VALUE;
  static String fpath = "";
  static Integer fpathwt = Integer.MIN_VALUE;

  static PriorityQueue<Pair> pq = new PriorityQueue<>();

  public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
    if (src == dest) {
      if (psf.length() > 0) {
        // Update smallest path
        if (wsf < spathwt) {
          spathwt = wsf;
          spath = psf;
        }
        
        // Update largest path
        if (wsf > lpathwt) {
          lpathwt = wsf;
          lpath = psf;
        }
        
        // Update just larger path than criteria
        if (wsf > criteria && wsf < cpathwt) {
          cpathwt = wsf;
          cpath = psf;
        }
        
        // Update just smaller path than criteria
        if (wsf < criteria && wsf > fpathwt) {
          fpathwt = wsf;
          fpath = psf;
        }
        
        // Update kth largest path using min heap
        if (pq.size() < k) {
          pq.add(new Pair(wsf, psf));
        } else {
          if (wsf > pq.peek().wsf) {
            pq.remove();
            pq.add(new Pair(wsf, psf));
          }
        }
      }
      return;
    }

    visited[src] = true;
    for (Edge e : graph[src]) {
      if (!visited[e.v2]) {
        multisolver(graph, e.v2, dest, visited, criteria, k, psf + e.v2, wsf + e.wt);
      }
    }
    visited[src] = false;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int vertices = scn.nextInt(); // no. of vertices
    int edges = scn.nextInt(); // no. of edges

    ArrayList<Edge>[] graph = new ArrayList[vertices]; // not understood
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>(); // not understood
    }

    for (int i = 0; i < edges; i++) {
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      int wt = scn.nextInt();

      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = scn.nextInt();
    int dest = scn.nextInt();
    int criteria = scn.nextInt();
    int k = scn.nextInt();

    boolean[] visited = new boolean[vertices];
    multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

    System.out.println("Smallest path = " + spath + "@" + spathwt);
    System.out.println("Largest path = " + lpath + "@" + lpathwt);
    System.out.println("Just larger path than " + criteria + " = " + cpath + "@" + cpathwt);
    System.out.println("Just smaller path than " + criteria + " = " + fpath + "@" + fpathwt);
    
    if (!pq.isEmpty()) {
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    } else {
      System.out.println(k + "th largest path = No path found");
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
// 0 3 10
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0
// 6
// 30
// 4

// output
// Smallest path = 01256@28
// Largest path = 032546@66
// Just larger path than 30 = 012546@36
// just smaller path than 30 = 01256@28
// 4th largest path = 03456@48
//
