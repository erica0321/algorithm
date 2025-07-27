class Solution {
    public String[] solution(String[] names) {
        int num = names.length % 5 > 0 ? names.length / 5 + 1 : names.length / 5;
        String[] answer = new String[num];
        for(int i =0; i< num; i++) answer[i] = names[i * 5]; 
        return answer;
    }
}