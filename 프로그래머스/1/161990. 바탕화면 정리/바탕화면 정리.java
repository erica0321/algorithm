class Solution {
    public int[] solution(String[] wallpaper) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        
        int length = wallpaper.length;
        
        for (int i = 0; i < length; i++) {
            String wall = wallpaper[i];
            for (int j = 0; j < wall.length(); j++) {
                if (wall.charAt(j) == '#') {
                    top = Math.min(i, top);
                    left = Math.min(j, left);
                    bottom = Math.max(i + 1, bottom);
                    right = Math.max(j + 1, right);
                }
            }
        }
        
        return new int[]{top, left, bottom, right};
    }
}
