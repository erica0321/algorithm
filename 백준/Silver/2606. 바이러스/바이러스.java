import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int node = Integer.parseInt(br.readLine());
    int edgeNum = Integer.parseInt(br.readLine());

    // 부모 배열 초기화
    parents = new int[node + 1];
    for (int i = 1; i <= node; i++) {
      parents[i] = i;
    }

    // 간선 입력 받기
    for (int i = 0; i < edgeNum; i++) {
      String[] str = br.readLine().split(" ");
      int start = Integer.parseInt(str[0]);
      int end = Integer.parseInt(str[1]);

      // 두 노드의 부모를 병합
      int rootA = findParent(start);
      int rootB = findParent(end);

      if (rootA != rootB) {
        parents[rootB] = rootA;
      }
    }

    // 1번 노드와 연결된 노드의 수 세기
    int rootOfOne = findParent(1);
    int answer = 0;

    for (int i = 2; i <= node; i++) {
      if (findParent(i) == rootOfOne) {
        answer++;
      }
    }

    System.out.println(answer);
  }

  public static int findParent(int node) {
    if (parents[node] == node) {
      return node;
    } else {
      parents[node] = findParent(parents[node]);
      return parents[node];
    }
  }
}
