import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int standard = 0;
        if(ext.equals("code")) standard = 0;
        else if(ext.equals("date")) standard = 1;
        else if(ext.equals("maximum")) standard = 2;
        else standard = 3;

        int sort = 0;
        if(sort_by.equals("code")) sort = 0;
        else if(sort_by.equals("date")) sort = 1;
        else if(sort_by.equals("maximum")) sort = 2;
        else sort = 3;

        final int finalSort = sort; 

        List<int[]> list = new ArrayList<>();
        for (int[] temp : data) {
            if (temp[standard] < val_ext) {
                list.add(temp);
            }
        }

        list.sort((o1, o2) -> Integer.compare(o1[finalSort], o2[finalSort]));

        return list.toArray(new int[list.size()][]);
    }
}
