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
    String psf;
    int wsf;

    Pair(String psf, int wsf) {
      this.psf = psf;
      this.wsf = wsf;
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

  public static void multisolver(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int criteria, int k, String psf) {
    if (src == dest) {
      if (psf.length() > 0) {
        String path = psf;
        int weight = 0;
        
        // Calculate total weight from the path
        for (int i = 0; i < path.length() - 1; i++) {
          int v1 = path.charAt(i) - '0';
          int v2 = path.charAt(i + 1) - '0';
          for (Edge e : graph[v1]) {
            if (e.v2 == v2) {
              weight += e.wt;
              break;
            }
          }
        }
        
        if (weight < spathwt) {
          spathwt = weight;
          spath = path;
        }
        if (weight > lpathwt) {
          lpathwt = weight;
          lpath = path;
        }
        if (weight > criteria && weight < cpathwt) {
          cpathwt = weight;
          cpath = path;
        }
        if (weight < criteria && weight > fpathwt) {
          fpathwt = weight;
          fpath = path;
        }
        if (pq.size() < k) {
          pq.add(new Pair(path, weight));
        } else {
          if (weight > pq.peek().wsf) {
            pq.remove();
            pq.add(new Pair(path, weight));
          }
        }
      }
      return;
    }

    visited[src] = true;
    for (Edge e : graph[src]) {
      if (!visited[e.v2]) {
        multisolver(graph, visited, e.v2, dest, criteria, k, psf + e.v2);
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
    multisolver(graph, visited, src, dest, criteria, k, src + "");

    System.out.println("Smallest path = " + spath + "@" + spathwt);
    System.out.println("Largest path = " + lpath + "@" + lpathwt);
    System.out.println("Just larger path than " + criteria + " = " + cpath + "@" + cpathwt);
    System.out.println("just smaller path than " + criteria + " = " + fpath + "@" + fpathwt);
    System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);

    // scn.close();
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
