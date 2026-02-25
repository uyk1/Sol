class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 증설 횟수
        int[] diff = new int[24]; // 차분 배열
        int curCnt = 0; // 현재 서버 수
        
        for(int i = 0; i < 24; i++) {
            curCnt += diff[i]; // 만료될 서버 수 반영
            int tmpCnt = players[i] / m - curCnt;
            
            if(tmpCnt > 0) {
                answer += tmpCnt;
                curCnt += tmpCnt;
                
                if(i + k < 24) diff[i + k] -= tmpCnt;
            }
        }
        
        return answer;
    }
}