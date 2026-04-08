import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length; // 행
        
        // bfs.. 는 너무 비효율적일 것 같고, dp 방식 사용
        int[][] dp = new int[n][4];
        
        // 첫 행 값 채우기
        for(int i = 0; i < 4; i++) dp[0][i] = land[0][i];
        
        // dp 채우기(두 번째 행부터)
        // 이전 행의 최대값(dp에서)을 가져와 현재 위치값(land에서) 더하기
        for(int i = 1; i < n; i++) {
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
            dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }

        return answer = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3])));
    }
}