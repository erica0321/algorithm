class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int[] validTimes = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100 + 10;
            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            validTimes[i] = hour * 100 + minute;
        }

        for (int i = 0; i < timelogs.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < 7; j++) {
                int day = (startday + j -1) % 7;
                if (day == 5 || day == 6) continue;
                if (timelogs[i][j] > validTimes[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) answer++;
        }
        
        return answer;
    }
}
