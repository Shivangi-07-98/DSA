import java.util.*;
public class Q19_FractionalKnapsack {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scn.nextInt();
    }
    for (int i = 0; i < n; i++) {
      weights[i] = scn.nextInt();
    }
    int capacity = scn.nextInt();

    System.out.println(fractionalKnapsack(values, weights, capacity));
  }

  // Greedy solution
  // Fractional knapsack can be solved using greedy approach
  // Sort items by value/weight ratio and take items greedily
  public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
    int n = values.length;
    Item[] items = new Item[n];
    
    for (int i = 0; i < n; i++) {
      items[i] = new Item(values[i], weights[i]);
    }
    
    // Sort by value/weight ratio in descending order
    Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
    
    double totalValue = 0.0;
    int remainingCapacity = capacity;
    
    for (Item item : items) {
      if (remainingCapacity >= item.weight) {
        // Take the whole item
        totalValue += item.value;
        remainingCapacity -= item.weight;
      } else {
        // Take fraction of the item
        totalValue += item.ratio * remainingCapacity;
        break;
      }
    }
    
    return totalValue;
  }
  
  static class Item {
    int value;
    int weight;
    double ratio;
    
    Item(int value, int weight) {
      this.value = value;
      this.weight = weight;
      this.ratio = (double) value / weight;
    }
  }
  
}

