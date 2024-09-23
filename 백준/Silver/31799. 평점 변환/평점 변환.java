import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static int[] scores;
  public static int course;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    course = Integer.parseInt(br.readLine());
    String grades = br.readLine();

    scores = new int[course];
    convertGradesToScores(grades);

    StringBuilder answer = new StringBuilder();

    int now;
    int prev = 0;

    for (int i = 0; i < course; i++) {
      now = scores[i];
      if(i > 0) {
        prev = scores[i-1];
      }

      if (now <= 3) {
        answer.append("B");
      } else if (now <= 5) {
        if (prev <= 3) answer.append("D");
        else answer.append("B");
      } else if (now <= 7) {
        if (prev <= 5) answer.append("P");
        else answer.append("D");
      }else if(now == 8) {
        if(prev <= 7) answer.append("E");
        else answer.append("P");
      } else if (now == 9) {
        answer.append("E");
      }
    }

    System.out.println(answer);
  }

  public static void convertGradesToScores(String grades) {
    int index = 0;

    for (int i = 0; i < grades.length(); i++) {
      char grade = grades.charAt(i);
      int score = 0;

      if (grade == 'A' || grade == 'B' || grade == 'C') {
        if (i + 1 < grades.length()) {
          char nextChar = grades.charAt(i + 1);
          if (nextChar == '+') {
            if (grade == 'A') score = 9;
            else if (grade == 'B') score = 6;
            else score = 3;
            i++;
          } else if (nextChar == '0') {
            if (grade == 'A') score = 8;
            else if (grade == 'B') score = 5;
            else score = 2;
            i++;
          } else if (nextChar == '-') {
            if (grade == 'A') score = 7;
            else if (grade == 'B') score = 4;
            else score = 1;
            i++;
          } else {
            if (grade == 'A') score = 8;
            else if (grade == 'B') score = 5;
            else score = 2;
          }
        } else {
          if (grade == 'A') score = 8;
          else if (grade == 'B') score = 5;
          else score = 2;
        }
      }
      scores[index++] = score;
    }
  }
}
