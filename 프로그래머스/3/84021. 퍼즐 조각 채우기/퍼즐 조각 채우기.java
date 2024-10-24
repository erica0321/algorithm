import java.util.*;

class Solution {
    public static ArrayList<ArrayList<int[]>> list;
    public static ArrayList<ArrayList<int[]>> puzzle;
    public static boolean[][] visitedGame, visitedPuzzle;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static int answer = 0;
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        
        visitedGame = new boolean[N][N];
        visitedPuzzle = new boolean[N][N];
        
        list = new ArrayList<>();
        puzzle = new ArrayList<>();
        
        // 1. bfs 로직 통일시키기 위해서 game_board 1 -> 0, 0 -> 1로 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 1) game_board[i][j] = 0;
                else game_board[i][j] = 1;
            }
        }
        
        // 2. game_board, table 탐색하여 1인 부분 좌표 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 1 && !visitedGame[i][j])
                    bfs(game_board, j, i, visitedGame, list);
                if (table[i][j] == 1 && !visitedPuzzle[i][j])
                    bfs(table, j, i, visitedPuzzle, puzzle);
            }
        }
        
        // 3. 비교하여 채울 수 있는지 확인
        canFill();
        return answer;
    }
    
    public static void bfs(int[][] board, int startX, int startY, boolean[][] visited, ArrayList<ArrayList<int[]>> arr) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX, startY});
        visited[startY][startX] = true;
        ArrayList<int[]> temp = new ArrayList<>();
        temp.add(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[ny][nx] == 1) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new int[] {nx, ny});
                        temp.add(new int[] {nx - startX, ny - startY});
                    }
                }
            }
        }
        arr.add(temp);
    }
    
    public static void canFill() {
        int puzzleNum = puzzle.size();
        int holeNum = list.size();
        
        boolean[] isFilled = new boolean[holeNum];
        
        for (int i = 0; i < puzzleNum; i++) {
            for (int j = 0; j < holeNum; j++) {
                // 칸수가 다르거나 이미 채워졌다면 패스
                if (puzzle.get(i).size() != list.get(j).size() || isFilled[j]) continue;
                // 회전했을 때 같은지 확인
                if (rotateFill(list.get(j), puzzle.get(i))) {
                    isFilled[j] = true;
                    answer += list.get(j).size();
                    break;
                }
            }
        }
    }
    
    public static boolean rotateFill(ArrayList<int[]> hole, ArrayList<int[]> piece) {
        for (int i = 0; i < 4; i++) {
            normalize(hole);
            normalize(piece);
            
            // 좌표 비교
            boolean isSame = true;
            for (int j = 0; j < hole.size(); j++) {
                int[] h = hole.get(j);
                int[] p = piece.get(j);
                if (h[0] != p[0] || h[1] != p[1]) {
                    isSame = false;
                    break;
                }
            }
            
            if (isSame) return true;
            
            // 90도 회전
            rotate(piece);
        }
        
        return false;
    }
    
    public static void rotate(ArrayList<int[]> piece) {
        for (int j = 0; j < piece.size(); j++) {
            int[] temp = piece.get(j);
            int tempX = temp[0];
            temp[0] = temp[1];
            temp[1] = -tempX;
        }
    }
    
    public static void normalize(ArrayList<int[]> list) {
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int offsetX = list.get(0)[0];
        int offsetY = list.get(0)[1];
        
        for (int[] coord : list) {
            coord[0] -= offsetX;
            coord[1] -= offsetY;
        }
    }
}
