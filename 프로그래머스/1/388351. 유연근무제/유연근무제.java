class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length; // 직원 수
        
        // 반복문을 돌며 상을 받을 수 있는지 확인(직원별)
        for(int i = 0; i < n; i++) {
            int cnt = 0; // 시간에 맞춰 출근한 일수 카운트
            
            for(int j = 0; j < 7; j++) {
                int d = startday + j; // 현재 요일
                // 토, 일의 경우 의미없음
                if(d % 7 == 6 || d % 7 == 0) {
                    continue;
                }

                // 희망, 실제 출근 시간 비교
                int wh = schedules[i] / 100;
                int wm = schedules[i] % 100 + 10;
                if(wm >= 60) {
                    wh += 1;
                    wm -= 60;
                }
                int rh = timelogs[i][j] / 100;
                int rm = timelogs[i][j] % 100;

                if(wh * 60 + wm >= rh * 60 + rm) {
                    cnt++;
                }
            }
            
            if(cnt == 5) answer++;
        }
        
        return answer;
    }
}