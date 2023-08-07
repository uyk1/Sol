class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};     
        
        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            int origin = 0;
            if(tmp == ' ') answer += ' ';
            else if(Character.isUpperCase(tmp)) {
                origin = tmp - 'A';
                if(origin + n >= 26) answer += upper[origin + n - 26];
                else answer += upper[origin + n];
            }
            else {
                origin = tmp - 'a';
                if(origin + n >= 26) answer += lower[origin + n - 26];
                else answer += lower[origin + n];
            }
        }
        
        return answer;
    }
}