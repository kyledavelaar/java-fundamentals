import java.util.*;

public class PriorityQueueExample {
  static class PQSort implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
      return two - one; // sort in reverse order
    }
  }

  public static void main(String[] args) {
    int[] ia = {1,5,3,7,6,9,8};
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    for (int i: ia) {
      pq1.offer(i); // load queue
    }
    for (int i: ia) {
      System.out.println(pq1.poll() + " "); // 1,3,5,6,7,8,9 -> ordered by natural order
    }

    PQSort pqs = new PQSort();  // get the comparator
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, pqs);
    for( int i: ia) {
      pq2.offer(i); // load second queue;
    }

    System.out.println("size " + pq2.size()); // 7
    System.out.println("size " + pq2.peek()); // 9 returns highest priority element without removing it
    System.out.println("size " + pq2.size()); // 7
    System.out.println("size " + pq2.poll()); // 9 returns highest priority element and removes it
    System.out.println("size " + pq2.size()); // 6

    for (int i: ia) {
      System.out.println(pq2.poll() + " "); // 8,7,6,5,3,1 null
    }
  }
}
