class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n == 1 || n == 2) return 1;
        
        // 절반까지만 확인해도 됨
        for(int i = 1; i <= n/2; i++) {
            int sum = 0;
            int cnt = 0;
            while(sum < n) {
                sum += i + cnt;
                cnt++;
            }
            if(sum == n) answer++;
        }
        
        return answer + 1;
    }
}