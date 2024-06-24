import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long total_sum = 0;
        long queue1_sum = 0;
        long goal_sum;
        
        // 빼고 넣기 쉽게 하기 위해 LinkedList 사용
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // 전체 합과 queue1의 합 구하기
        for (int i = 0; i < queue1.length; i++) {
            total_sum += queue1[i] + queue2[i];
            queue1_sum += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        // 두 수의 합이 홀수면 같게 만들지 못함
        if (total_sum % 2 != 0) return -1;
        
        // 목표 합 구하기
        goal_sum = total_sum / 2;
        
        while (true) {
            // 목표 합과 큐1 합이 같으면 끝
            if (queue1_sum == goal_sum) break;
            
            // 모든 원소를 바꾸고 다시 원상 복귀 했을 때
            if (answer > (queue1.length + queue2.length) * 2) return -1;
            
            // 큐1 합이 목표 합보다 크면 큐1 맨앞 요소 제거 후 큐2에 넣기
            if (queue1_sum > goal_sum) {
                int element = q1.poll();
                queue1_sum -= element;
                q2.add(element);
            } else {
                // 큐2 맨앞 요소 제거 후 큐1에 넣기
                int element = q2.poll();
                queue1_sum += element;
                q1.add(element);
            }
            answer += 1;
        }
        
        return answer;
    }

}
