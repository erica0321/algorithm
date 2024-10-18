import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N, M;
  public static boolean[] truth;
  public static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); 
    M = Integer.parseInt(st.nextToken()); 

    truth = new boolean[N + 1]; 
    parents = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      parents[i] = i;
    }

    st = new StringTokenizer(br.readLine());
    int truthNum = Integer.parseInt(st.nextToken());  

    if (truthNum == 0) {
      System.out.println(M);
      return;
    }

    int[] truthPeople = new int[truthNum];
    for (int i = 0; i < truthNum; i++) {
      truthPeople[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<int[]> parties = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int partySize = Integer.parseInt(st.nextToken());
      int[] party = new int[partySize];

      party[0] = Integer.parseInt(st.nextToken());
      for (int j = 1; j < partySize; j++) {
        party[j] = Integer.parseInt(st.nextToken());
        union(party[0], party[j]);
      }
      parties.add(party);
    }

    for (int i = 1; i < truthNum; i++) {
      union(truthPeople[0], truthPeople[i]);
    }

    int result = 0;
    for (int[] party : parties) {
      boolean canLie = true;
      for (int person : party) {
        if (findParents(person) == findParents(truthPeople[0])) {
          canLie = false;
          break;
        }
      }
      if (canLie) {
        result++;  
      }
    }

    System.out.println(result); 
  }

  public static int findParents(int node) {
    if (parents[node] == node) {
      return node;
    } else {
      parents[node] = findParents(parents[node]); 
      return parents[node];
    }
  }

  public static void union(int a, int b) {
    int rootA = findParents(a);
    int rootB = findParents(b);
    if (rootA != rootB) {
      parents[rootB] = rootA; 
    }
  }
}
