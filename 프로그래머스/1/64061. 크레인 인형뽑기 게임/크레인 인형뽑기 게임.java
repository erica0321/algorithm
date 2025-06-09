import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i =0; i<moves.length; i++) {
            int move = moves[i] -1;
            
            for(int j =0; j<board[0].length; j++) {
                if(board[j][move] == 0) continue;
                
                if(st.peek() == board[j][move]) {
                    st.pop();
                    answer += 2;
                } else {
                    st.push(board[j][move]);
                }
                board[j][move] = 0;
                break;
            }
        }
        return answer;
    }
}