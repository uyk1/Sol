class Solution {
    public int solution(int n) {
        if(n <= 3) return 0;
        int answer = 0;
        for(int i = 4; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(i%j == 0) cnt++;
                if(cnt == 3) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}