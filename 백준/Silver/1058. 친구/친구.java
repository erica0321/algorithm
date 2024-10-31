import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static List<ArrayList<Integer>> list = new ArrayList<>();
  public static int N;
  public static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      list.add(new ArrayList<>());
    }

    arr = new int[N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        if (str.charAt(j) == 'Y') {
          list.get(i).add(j);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      arr[i] = bfs(i);
    }

    Arrays.sort(arr);
    System.out.println(arr[N - 1]);
  }

  public static int bfs(int start) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[] visited = new boolean[N];
    visited[start] = true;
    queue.add(new int[]{start, 0});
    int friendCount = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int node = current[0];
      int depth = current[1];

      if (depth == 2) continue;

      for (int friend : list.get(node)) {
        if (!visited[friend]) {
          visited[friend] = true;
          friendCount++;
          queue.add(new int[]{friend, depth + 1});
        }
      }
    }
    return friendCount;
  }
}
