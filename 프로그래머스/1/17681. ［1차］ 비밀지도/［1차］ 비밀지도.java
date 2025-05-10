class Solution {
    public static int[][] map1, map2, result;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        map1 = new int[n][n];
        map2 = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            int num1 = arr1[i];
            int num2 = arr2[i];

            for (int j = n - 1; j >= 0; j--) {
                map1[i][j] = num1 % 2;
                map2[i][j] = num2 % 2;
                num1 /= 2;
                num2 /= 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = map1[i][j] | map2[i][j];
            }
        }

        String[] answer = new String[n]; 

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j] == 1 ? '#' : ' ');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
