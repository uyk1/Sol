import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1; // num 상자 자체 포함
        
        // num 상자의 위치 - 행, 열 둘 다 0부터 시작
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        
        // row 짝수 여부에 따라 col 재정의
        if(row % 2 == 1) col = w - 1 - col;
        
        // 실제 박스 위치 열의 위층들을 확인
        int currentRow = row + 1;
        
        while(true) {
            // 도달한 층의 시작 박스 번호
            int start = currentRow * w + 1;
            
            // 만약 범위 초과라면 종료
            if(start > n) break;
            
            // 현재 층의 짝수 여부에 따라 박스 존재여부 판단
            int boxesCnt = Math.min(w, n - currentRow * w); // 현재 층 박스 개수
            if(currentRow % 2 == 0) {
                // 짝수층
                if(col < boxesCnt) {
                    answer++;
                }
            } else {
                // 홀수층
                if(col >= w - boxesCnt) {
                    answer++;
                }
            }
            
            currentRow++;
        }
        
        return answer;
    }
}