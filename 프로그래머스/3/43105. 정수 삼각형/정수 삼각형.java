class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        
        int[][] dp = new int[h][h];
        
        // 가장 위 & 왼쪽 열 & 오른쪽 열
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < h; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; 
        }
        
        // 왼쪽 위에서 내려온 경우와 오른쪽 위에서 내려온 경우 비교
        for(int i = 1; i < h; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        
        for(int i: dp[h - 1]) answer = Math.max(answer, i);
        
        return answer;
    }
}