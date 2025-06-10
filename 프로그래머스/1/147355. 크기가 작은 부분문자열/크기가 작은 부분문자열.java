class Solution {
    public int solution(String t, String p) {
		int answer = 0;

		long num = Long.parseLong(p);
        
        
		for (int i = 0; i < t.length() - p.length() + 1; i++) {
			long temp = Long.parseLong(t.substring(i, i + p.length()));
			if (temp <= num) answer++;
		}
        
		return answer;
    }
}