class Solution {
    public boolean solution(int x) {
        String[] str = Integer.toString(x).split("");
        int divider = 0;
        for (int i = 0; i < str.length; i++) {
            divider += Integer.parseInt(str[i]);
        }
        return x % divider == 0;
    }
}
