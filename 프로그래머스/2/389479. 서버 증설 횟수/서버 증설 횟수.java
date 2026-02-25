class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 증설 횟수
        int[] sArr = new int[24]; // 매 시간 증설되어 있는 서버의 수
        
        for(int i = 0; i < 24; i++) {
            int uCnt = players[i]; // 해당 시간 게임 이용자 수
            // 해당 시간 필요한 서버 증설 개수
            int tmpCnt = (uCnt / m) - sArr[i];
            if(tmpCnt <= 0) continue;
            // sArr 현행화
            int tmpIdx = i;
            while(tmpIdx < Math.min(i + k, 24)) {
                sArr[tmpIdx] += tmpCnt;
                tmpIdx++;
            }
            
            answer += tmpCnt;
        }
        
        return answer;
    }
}