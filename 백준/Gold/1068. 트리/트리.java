import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static List<ArrayList<Integer>> list;
  public static int deleteNode;
  public static int leafCount = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      list.add(new ArrayList<>());
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int root = -1;
    for (int i = 0; i < N; i++) {
      int parentNode = Integer.parseInt(st.nextToken());
      if (parentNode == -1) {
        root = i;
      } else {
        list.get(parentNode).add(i);
      }
    }

    deleteNode = Integer.parseInt(br.readLine());

    if (root != deleteNode) {
      dfs(root);
    }

    System.out.println(leafCount);
  }

  public static void dfs(int node) {
    if(node == deleteNode) return;
    if(list.get(node).isEmpty()) {
      leafCount++;
      return;
    }

    boolean isLeaf = true;
    for(int child : list.get(node)) {
      if(child!= deleteNode) {
        isLeaf = false;
        dfs(child);
      }
    }

    if(isLeaf) leafCount++;
  }

}
