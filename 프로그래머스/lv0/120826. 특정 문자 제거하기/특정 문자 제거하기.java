class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++) {
            String tmp = my_string.substring(i, i+1);
            if(tmp.equals(letter)) continue;
            answer += tmp;
        }
        return answer;
    }
}