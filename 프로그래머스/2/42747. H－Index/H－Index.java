import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);  // 인용 횟수 배열을 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;  // h는 적어도 citations[i]번 인용된 논문의 수
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
