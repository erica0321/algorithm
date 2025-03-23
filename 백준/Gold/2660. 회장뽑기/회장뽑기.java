import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N+1][N+1];
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= N; j++){
        if(i == j) arr[i][j] = 0;
        else arr[i][j] = 999999;
      }
    }

    while(true) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end   = Integer.parseInt(st.nextToken());

      if(start == -1 && end == -1) break;

      arr[start][end] = 1;
      arr[end][start] = 1;
    }

    for(int k = 1; k <= N; k++){
      for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
          if(arr[i][j] > arr[i][k] + arr[k][j]) {
            arr[i][j] = arr[i][k] + arr[k][j];
          }
        }
      }
    }

    int[] friends = new int[N+1];
    for(int i = 1; i <= N; i++){
      int max = 0;
      for(int j = 1; j <= N; j++){
        if(arr[i][j] < 999999) {
          max = Math.max(max, arr[i][j]);
        }
      }
      friends[i] = max;
    }

    int minScore = 999999;
    for(int i = 1; i <= N; i++){
      minScore = Math.min(minScore, friends[i]);
    }

    StringBuilder sb = new StringBuilder();
    int count = 0;
    for(int i = 1; i <= N; i++){
      if(friends[i] == minScore) {
        count++;
        sb.append(i).append(" ");
      }
    }

    System.out.println(minScore + " " + count);
    System.out.println(sb.toString());
  }
}
