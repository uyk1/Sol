class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0;
        long calc = num;
        while(cnt <= 500 && calc != 1) {
            if(calc % 2 == 0) calc /= 2;
            else calc = calc * 3 + 1;
            cnt++;
        }
        if(calc != 1) answer = -1;
        else answer = cnt;
        return answer;
    }
}