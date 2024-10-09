import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static boolean[][] visited;
  public static int[][] arr;
  public static ArrayList<int[]> list;
  public static Map<Integer, ArrayList<int[]>> map = new HashMap<>();
  public static int[] dx = {1, -1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static int cnt = 0;
  public static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    visited = new boolean[N][N];

    // 1. 입력 받기
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 2. 그룹 나누기 -> dfs
    // 각 그룹별로 말단 노드 저장
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && arr[i][j] == 1) {
          cnt++;
          list = new ArrayList<>(); 
          dfs(i, j);
          map.put(cnt, list);
        }
      }
    }

    // 3. 그룹끼리 최단 거리 구하기 -> bfs
    for (int i = 1; i < cnt; i++) {
      for (int j = i + 1; j <= cnt; j++) { 
        ArrayList<int[]> list1 = map.get(i);
        ArrayList<int[]> list2 = map.get(j);

        for (int[] start : list1) {
          for (int[] end : list2) {
            int dist = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]) - 1;
            min = Math.min(min, dist);
          }
        }
      }
    }

    // 4. 결과 출력
    System.out.println(min);
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;
    list.add(new int[]{x, y});

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && arr[nx][ny] == 1) {
        dfs(nx, ny);
      }
    }
  }
}
