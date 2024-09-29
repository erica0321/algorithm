import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int 타깃인덱스 = 0; // 작업 배열에서 타깃이 되는 인덱스
        int 끝나는시간 = 0; // 현재 작업이 끝나는 시간
        int 끝난작업수 = 0; // 끝난 작업의 개수
        
        // 우선순위 큐, 작업 소요 시간이 짧은 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // jobs 배열을 작업이 요청된 시간을 기준으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 모든 작업이 끝날 때까지 반복
        while (끝난작업수 < jobs.length) {
            // 현재 시점에서 처리할 수 있는 작업들을 모두 우선순위 큐에 추가
            while (타깃인덱스 < jobs.length && jobs[타깃인덱스][0] <= 끝나는시간) {
                pq.offer(jobs[타깃인덱스++]);
            }
            
            if (pq.isEmpty()) { // 우선순위 큐가 비어있다면, 새로운 작업 시작 가능
                끝나는시간 = jobs[타깃인덱스][0];
            } else {
                int[] 임시 = pq.poll(); // 가장 빨리 끝날 작업을 가져옴
                
                // 대기 시간을 포함한 처리 시간 계산
                answer += (끝나는시간 + 임시[1]) - 임시[0];
                끝나는시간 += 임시[1]; // 해당 작업의 처리 시간을 끝나는 시간에 더함
                끝난작업수++;
            }
        }
        
        // 평균 대기 시간을 구함
        return answer / jobs.length;
    }
}
