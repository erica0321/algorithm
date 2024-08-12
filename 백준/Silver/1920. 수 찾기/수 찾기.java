import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    String str = bf.readLine();
    String[] strArr = str.split(" ");
    int[] numbers1 = new int[strArr.length];

    for (int i = 0; i < N; i++) {
      numbers1[i] = Integer.parseInt(strArr[i]); // 문자열을 정수로 변환하여 배열에 저장
    }

    Arrays.sort(numbers1);

    int M = Integer.parseInt(bf.readLine());

    String str2 = bf.readLine();
    String[] strArr2 = str2.split(" ");

    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(strArr2[i]);
      int in  = Arrays.binarySearch(numbers1, target);
      
      if(in < 0) {
        System.out.println(0);
      } else {
        System.out.println(1);
      }
    
    }
  }
}