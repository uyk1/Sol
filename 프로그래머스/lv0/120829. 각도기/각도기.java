class Solution {
    public int solution(int angle) {
        int answer = 0;
        int sign = angle / 90;
        boolean chk = (angle % 90 == 0);
        if(sign == 0) answer = 1;
        else if(sign == 1 && chk) answer = 2;
        else if(sign == 1 && !chk) answer = 3;
        else answer = 4;
        
        return answer;
    }
}