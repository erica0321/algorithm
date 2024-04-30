class Solution {
  public String solution(String[] survey, int[] choices) {
    int[][] score = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };
    int i = 0;

    // score 값 계산
    for (i = 0; i < survey.length; i++) {
      int scoreIndex;
      // 어느 지표인지 구하기
      if (survey[i].equals("AN") || survey[i].equals("NA")) {
        scoreIndex = 3;
      } else if (survey[i].equals("JM") || survey[i].equals("MJ")) {
        scoreIndex = 2;
      } else if (survey[i].equals("CF") || survey[i].equals("FC")) {
        scoreIndex = 1;
      } else {
        scoreIndex = 0;
      }

      String disagree = survey[i].split("")[0];
      String agree = survey[i].split("")[1];

      int result = disagree.compareTo(agree);

      // 동의에 점수
      if (choices[i] > 4) {
        // 비동의가 사전상 뒤에 있음
        if (result > 0) {
          score[scoreIndex][0] += choices[i] - 4;
        } else {
          score[scoreIndex][1] += choices[i] - 4;
        }
        // 비동의에 점수
      } else if (choices[i] < 4) {
        // 비동의가 사전상 뒤에 있음
        if (result > 0) {
          score[scoreIndex][1] += 4 - choices[i];
        } else {
          score[scoreIndex][0] += 4 - choices[i];
        }
      } else {
        continue;
      }
    }

    for (i = 0; i < score.length; i++) {
      for (int j = 0; j < score[i].length; j++) {
        System.out.print(score[i][j] + " ");
      }
      System.out.println();
    }

    String answer = "";

    if (score[0][0] >= score[0][1]) {
      answer += "R";
    } else {
      answer += "T";
    }

    if (score[1][0] >= score[1][1]) {
      answer += "C";
    } else {
      answer += "F";
    }

    if (score[2][0] >= score[2][1]) {
      answer += "J";
    } else {
      answer += "M";
    }

    if (score[3][0] >= score[3][1]) {
      answer += "A";
    } else {
      answer += "N";
    }

    return answer;
  }
}