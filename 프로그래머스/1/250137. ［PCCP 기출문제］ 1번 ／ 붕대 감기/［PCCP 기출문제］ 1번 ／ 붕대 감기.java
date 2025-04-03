class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int ycnt = 0; // 연속 회복 초 카운트
        int aidx = 0; // 몬스터 공격
        
        for(int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            // 몬스터 공격이 있는지 확인
            if(aidx < attacks.length && attacks[aidx][0] == i) {
                answer -= attacks[aidx][1];
                if(answer <= 0) return -1;
                ycnt = 0;
                aidx++;
                continue;
            }
            
            // 붕대감기 시전시간 확인 필요
            answer += bandage[1];
            ycnt++;
            if(ycnt == bandage[0]) {
                // 추가 체력 회복
                answer += bandage[2];
                ycnt = 0;
            }
            if(answer > health) answer = health;
        }
        
        return answer;
    }
}