class Solution {
    public int solution(int[] numbers) {
        int total = 45;
        for (int number : numbers) {
            total -= number;
        }
        return total;
    }
}