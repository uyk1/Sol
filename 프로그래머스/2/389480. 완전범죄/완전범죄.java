class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        
        // DP
        boolean[][] cur = new boolean[n][m];
        cur[0][0] = true;
        
        for(int[] target : info) {
            // 초기화
            boolean[][] next = new boolean[n][m];
            
            // cur을 돌다가 true인 경우를 만나면 처리
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(cur[i][j]) {
                        // A가 훔치거나, B가 훔치거나
                        int tmpN = i + target[0];
                        int tmpM = j + target[1];
                        
                        if(tmpN >= n && tmpM >= m) continue;
                        
                        if(tmpN < n) next[tmpN][j] = true;
                        if(tmpM < m) next[i][tmpM] = true;
                    }
                }
            }
            
            // 전이
            cur = next;
        }
        
        // cur을 돌며 A 흔적 누적 개수의 최솟값 반환, 없다면 -1 반환
        boolean flag = false;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(cur[i][j]) {
                    flag = true;
                    answer = Math.min(answer, i);
                }
            }
        }
        
        return flag ? answer : -1;
    }
}