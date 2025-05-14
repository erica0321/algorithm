class Solution {
  public String solution(int n) {
      String[] str = {"4", "1", "2"};
      String answer = "";
      
      int N = n;
      
      while(N > 0){
          int idx = N % 3;
          if(idx == 0) N--;
          N /= 3;
          answer = str[idx] + answer;
      }
     
      return answer;
  }
}
