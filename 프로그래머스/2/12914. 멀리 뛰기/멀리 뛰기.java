class Solution {
    public long solution(int n) {
        long answer = 0;
        
        // n이 1 or 2이면
        if(n == 1 || n == 2) return n;
            
        long[] arr = new long[n];
        
        // 1칸 또는 2칸 이동으로 n에 도달 -> 점화식 dp[i] = dp[i-1] + dp[i-2]
        // 1칸 적은 위치에 도달한 방법 수 + 2칸 적은 위치에 도달한 방법 수
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i = 2; i < n; i++) {
            // long 범위를 초과하지 않도록 미리 나누기
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }
        
        answer = arr[n-1];
        
        return answer;
    }
}