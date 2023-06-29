class Solution {
    public int solution(int n) {
        int answer = 1;
        int tmp = 1;
        for(int i = 1; i <= n; i++) {
            tmp *= i;
            if(tmp == n) return i;
            if(tmp > n) return i-1;
        }
        return answer;
    }
}