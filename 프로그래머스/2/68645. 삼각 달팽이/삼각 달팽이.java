class Solution {
    public static int[][] map;
    public static int[] result;
    public int[] solution(int n) {
        map = new int[n][n];
        
        int count = n * (n+1) / 2;
        result = new int[count];
        int x = -1;
        int y = 0;
        int num = 1;
        
        for(int i =0; i<n; i++) {
            for(int j = i; j<n; j++) {
                if(i % 3 == 0) {
                    x++;
                } else if(i%3 == 1) {
                    y++;
                } else if(i%3 == 2) {
                    x--;
                    y--;
                }
                map[x][y] = num;
                num ++;
            }
        }
        
        int idx = 0;
        for(int i =0; i<n; i++) {
            for(int j =0; j<n; j++) {
                if(map[i][j] != 0){
                    result[idx] = map[i][j];
                    idx++;
                }
            }
        }
        return result;
    }
}