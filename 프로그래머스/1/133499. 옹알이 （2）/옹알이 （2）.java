class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for (String str : babbling) {
            if (str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama")) {
                continue;
            }
            String temp = str.replaceAll("aya|ye|woo|ma", "");
            if (temp.isEmpty()) count++;
        }
        return count;
    }
}
