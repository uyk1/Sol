class Solution {
    public String solution(String new_id) {
        String answer = "";
        String str = new_id.toLowerCase();
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                answer = answer + c;
            }
        }
        
        while(answer.contains("..")) answer = answer.replace("..", ".");
        
        if(!answer.isEmpty() && answer.charAt(0) == '.') answer = answer.substring(1);
        if(!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);
        
        if(answer.equals("")) answer = "a";
        
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        if(!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);
        
        while(answer.length() <= 2) answer += answer.charAt(answer.length() - 1); 
        
        return answer;
    }
}