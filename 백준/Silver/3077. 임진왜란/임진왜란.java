import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    String[] hyunwoo = new String[num];
    String[] answer = new String[num];

    hyunwoo = br.readLine().split(" ");
    answer = br.readLine().split(" ");


    Map<String, Integer> map = new HashMap<>();
    for(int i =0; i<num ; i++) {
      map.put(answer[i], i);
    }

    int score = 0;
    for(int i = 0; i < num; i++) {
      for(int j = i+1; j < num; j++) {
        if(map.get(hyunwoo[i]) < map.get(hyunwoo[j])) {
          score++;
        }
      }
    }

    System.out.println(score + "/" + num * (num-1) / 2);
  }
}
