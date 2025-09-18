import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0; // 가장 선물을 많이 받은 친구의 선물 수
        
        int n = friends.length; // 친구 수
        Map<String, Integer> friendsMap = new HashMap<>(); // 친구 목록 맵
        for(int i = 0; i < n; i++) friendsMap.put(friends[i], i); // 인덱스 매핑
        
        int[][] grid = new int[n][n]; // 선물 주고 받은 내역
        int[] presentCount = new int[n]; // 선물 지수
        
        // 내역 확인 - 문자열 split
        for(int i = 0; i < gifts.length; i++) {
            String[] parts = gifts[i].split(" "); // 공백으로 분리
            int giver = friendsMap.get(parts[0]);
            int getter = friendsMap.get(parts[1]);
            
            // 통계 처리
            grid[giver][getter]++;
            presentCount[giver]++;
            presentCount[getter]--;
        }
        
        // 다음 달 받을 선물 수 확인
        int[] nextMonth = new int[n];
        
        for(int i = 0; i < n; i++) {
            int ipc = presentCount[i]; // 해당자 선물지수
            
            for(int j = i + 1; j < n; j++) {
                int jpc = presentCount[j]; // 친구 선물지수
                int plus = grid[i][j]; // 준 선물
                int minus = grid[j][i]; // 받은 선물
                
                if(plus > minus || (plus == minus) && ipc > jpc) nextMonth[i]++;
                if(plus < minus || (plus == minus) && jpc > ipc) nextMonth[j]++;
            }
        }
        
        for(int cnt: nextMonth) answer = Math.max(answer, cnt);
        
        return answer;
    }
}