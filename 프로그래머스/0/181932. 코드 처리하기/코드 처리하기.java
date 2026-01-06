class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = false;

        for(int i = 0; i < code.length(); i++) {
            String s = code.substring(i, i + 1);
            if(!mode) {
                if(s.equals("1")) {
                    mode = true;
                    continue;
                }
                if(i % 2 == 0) answer += s;
            } else {
                if(s.equals("1")) {
                    mode = false;
                    continue;
                }
                if(i % 2 == 1) answer += s;
            }
        }
        
        return answer.equals("") ? "EMPTY" : answer;
    }
}