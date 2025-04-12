import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
  static int K;
  static int[] buildings;
  static List<ArrayList<Integer>> list;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());
    int numbers = (int) Math.pow(2, K) - 1;
    buildings = new int[numbers];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < numbers; i++) {
      buildings[i] = Integer.parseInt(st.nextToken());
    }

    list = new ArrayList<>();
    for(int i = 0; i < K; i++) {
      list.add(new ArrayList<>());
    }

    inorder(0, numbers-1, 0);

    for(ArrayList<Integer> depth : list) {
      for(Integer i : depth) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  public static void inorder(int start, int end, int depth) {
    if(depth == K) return;

    int mid = (start + end) / 2;
    list.get(depth).add(buildings[mid]);

    inorder(start, mid-1, depth + 1);
    inorder(mid+1, end, depth+1);
  }
}
