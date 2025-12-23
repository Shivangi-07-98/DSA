import java.util.*;

// O(V^2)
// Spread of infection (same as Q9) but edges stored in an adjacency matrix.
public class Q19_SpreadOfInfectionUsingAdjacencyMatrix {

  private static class Pair {
    int vtx;
    int time;

    Pair(int vtx, int time) {
      this.vtx = vtx;
      this.time = time;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int vertices = scn.nextInt();
    Integer[][] graph = new Integer[vertices][vertices];

    int edges = scn.nextInt();
    for (int i = 0; i < edges; i++) {
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      int wt = scn.nextInt();

      graph[v1][v2] = wt;
      graph[v2][v1] = wt;
    }

    int src = scn.nextInt();
    int timeLimit = scn.nextInt();

    int infected = 0;
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, 1));
    boolean[] visited = new boolean[vertices];

    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited[rem.vtx]) {
        continue;
      }
      visited[rem.vtx] = true;

      if (rem.time > timeLimit) {
        break;
      }
      infected++;

      for (int nbr = 0; nbr < graph.length; nbr++) {
        if (graph[rem.vtx][nbr] != null && !visited[nbr]) {
          queue.add(new Pair(nbr, rem.time + 1));
        }
      }
    }

    System.out.println(infected);
    scn.close();
  }
}

// input
// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 6
// 3

// output
// 4
