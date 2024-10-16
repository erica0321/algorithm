class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        int move = len - 1; 

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);

            int nextIndex = i + 1;
            // 연속된 'A'가 있을 경우 멈추는 위치를 확인
            while (nextIndex < len && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            move = Math.min(move, i + len - nextIndex + Math.min(i, len - nextIndex));
        }

        answer += move;
        return answer;
    }
}
