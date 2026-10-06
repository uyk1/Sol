class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scoreBoard = new int[3];
        char[] dart = dartResult.toCharArray();
        
        int cnt = -1; // 현재 다트 카운트
        
        for(int i = 0; i < dart.length; i++) {
            char c = dart[i];
            
            // 점수인 경우
            if(c - '0' > 0 && c - '0' < 10) {
                cnt++;
                scoreBoard[cnt] = c - '0';
                continue;
            } else if(c == '0') {
                int prevIdx = i - 1;
                if(prevIdx >= 0 && dart[prevIdx] == '1') {
                    scoreBoard[cnt] = 10;
                } else {
                    cnt++;
                    scoreBoard[cnt] = 0;
                }
                continue;
            }
            
            
            // 보너스
            if(c == 'S') {
                continue; 
            } else if(c == 'D') {
                scoreBoard[cnt] *= scoreBoard[cnt];
                continue;
            } else if(c == 'T') {
                scoreBoard[cnt] *= scoreBoard[cnt] * scoreBoard[cnt];
                continue;
            }
            
            // 옵션
            if(c == '*') {
                // 중첩
                if(cnt > 0) {
                    scoreBoard[cnt - 1] *= 2;
                }
                scoreBoard[cnt] *= 2;
                continue;
            } else if(c == '#') {
                scoreBoard[cnt] *= -1;
                continue;
            }
        }
        
        for(int i : scoreBoard) answer += i;
        
        return answer;
    }
}