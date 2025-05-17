import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> people = new HashMap<>();
        List<double[]> failList = new ArrayList<>();

        for (int stage : stages) {
            people.put(stage, people.getOrDefault(stage, 0) + 1);
        }

        int leftUser = stages.length;

        for (int i = 1; i <= N; i++) {
            int notCleared = people.getOrDefault(i, 0);
            double failRate = 0.0;

            if (leftUser != 0) {
                failRate = (double) notCleared / leftUser;
            }

            failList.add(new double[]{i, failRate});
            leftUser -= notCleared;
        }

        Collections.sort(failList, (a, b) -> {
            if (Double.compare(b[1], a[1]) == 0) {
                return (int) (a[0] - b[0]);
            }
            return Double.compare(b[1], a[1]);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failList.get(i)[0];
        }

        return answer;
    }
}
