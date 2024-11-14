import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0;i<N;i++){
      list.add(Integer.parseInt(br.readLine()));
    }
    list.sort(Integer::compareTo);
    for(int i =0; i<list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
