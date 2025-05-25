class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10; 
        int right = 12;

        for (int number : numbers) {
            if (number == 0) number = 11; 
            if (number % 3 == 1) {
                left = number;
                answer += "L";
            } else if (number % 3 == 0) { 
                right = number;
                answer += "R";
            } else {
                int lDist = getDistance(left, number);
                int rDist = getDistance(right, number);

                if (lDist == rDist) {
                    if (hand.equals("right")) {
                        right = number;
                        answer += "R";
                    } else {
                        left = number;
                        answer += "L";
                    }
                } else if (lDist < rDist) {
                    left = number;
                    answer += "L";
                } else {
                    right = number;
                    answer += "R";
                }
            }
        }

        return answer;
    }

    public static int getDistance(int from, int to) {
        int fromX = (from - 1) / 3;
        int fromY = (from - 1) % 3;
        int toX = (to - 1) / 3;
        int toY = (to - 1) % 3;

        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
}
