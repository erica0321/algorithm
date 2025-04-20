import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static List<Integer> list;
  public static int max;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    energy(0);
    System.out.println(max);

  }

  public static void energy(int energy) {
    if(list.size() == 2) {
      max = Math.max(max, energy);
      return;
    }

    for(int i = 1; i < list.size() - 1; i++) {
      int num = list.get(i);
      int weight = list.get(i-1) * list.get(i+1);
      list.remove(i);
      energy(energy + weight);
      list.add(i, num);
    }
  }
}