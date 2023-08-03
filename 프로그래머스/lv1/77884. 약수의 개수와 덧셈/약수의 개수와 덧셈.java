class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            int cnt = 0; // 약수의 개수
            for(int j = 1; j <= i; j++) {
                if(i % j != 0) continue;
                cnt++;
            }
            if(cnt % 2 != 0) answer -= i;
            else answer += i;
        }
        
        return answer;
    }
}