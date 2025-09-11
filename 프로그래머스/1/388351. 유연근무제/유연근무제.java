class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int num = schedules.length; // 인원수
        int len = timelogs[0].length; // 진행날짜
        
        // 인원별로 진행
        for(int i = 0; i < num; i++) {
            int day = startday; // 시작일
            boolean flag = false; // 지각여부
            int sch = schedules[i]; // 지정한 출근 시간
            int limit; // 지각 리미트
            if((sch + 10) % 100 >= 60) {
                limit = (sch / 100 + 1) * 100 + ((sch + 10) % 100 - 60);
            } else {
                limit = sch + 10;
            }
            int[] log = timelogs[i]; // 실제 출근 로그
            // 일주일
            for(int j = 0; j < len; j++) {
                if(day > 5) { // 토, 일 스킵
                    if(day != 7) day++;
                    else day = 1;
                    continue;
                }
                // 지각여부 확인
                if(limit < log[j]) {
                    flag = true;
                    break;
                }
                day++;
            }
            // flag가 false이면 지각 X
            if(!flag) answer++;
        }
        
        return answer;
    }
}