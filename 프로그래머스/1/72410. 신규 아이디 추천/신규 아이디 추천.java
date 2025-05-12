class Solution {
    public String solution(String new_id) {
        String result = new_id.toLowerCase();

        result = result.replaceAll("[^a-z0-9-_.]", "");
        result = result.replaceAll("[.]{2,}", ".");
        result = result.replaceAll("^[.]|[.]$", "");
    
        if (result.equals("")) result += "a";
        if (result.length() >= 16) result = result.substring(0, 15).replaceAll("[.]$","");
        if (result.length() <= 2) {
            while (result.length() < 3) {
                char last = result.charAt(result.length()-1);
                result += last;
            }
        }

        return result;
    }
}