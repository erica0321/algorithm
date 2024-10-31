class Solution {
    public static int answer;
    public static char[] directions;
    public static boolean[][][][] visited; 
    
    public int solution(String dirs) {
        answer = 0; 
        visited = new boolean[11][11][11][11]; 
        directions = new char[dirs.length()];
        
        for (int i = 0; i < dirs.length(); i++) {
            directions[i] = dirs.charAt(i);
        }
        
        find(5, 5, 0);
        return answer;
    }
    
    public static void find(int cx, int cy, int idx) {
        if (idx >= directions.length) return;

        int nx = cx;
        int ny = cy;
        
        switch (directions[idx]) {
            case 'U': ny += 1; break;
            case 'D': ny -= 1; break;
            case 'L': nx -= 1; break;
            case 'R': nx += 1; break;
        }
        
        if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
            find(cx, cy, idx + 1);
        } else {
            if (!visited[cx][cy][nx][ny]) {
                visited[cx][cy][nx][ny] = true;
                visited[nx][ny][cx][cy] = true;
                answer++;
            }
            find(nx, ny, idx + 1);
        }
    }
}
