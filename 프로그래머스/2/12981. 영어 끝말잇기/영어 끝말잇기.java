class Solution {
    public int[] solution(int n, String[] words) {
        int length = words.length;

        for (int i = 1; i < length; i++) {
            if (!words[i].substring(0, 1).equals(words[i - 1].substring(words[i - 1].length() - 1))) {
                int round = i / n + 1;
                int people = i % n + 1;
                return new int[]{people, round};
            }
            for (int j = 0; j < i; j++) {
                if (words[j].equals(words[i])) {
                    int round = i / n + 1;
                    int people = i % n + 1;
                    return new int[]{people, round};
                }
            }
        }

        return new int[]{0, 0};
    }
}
