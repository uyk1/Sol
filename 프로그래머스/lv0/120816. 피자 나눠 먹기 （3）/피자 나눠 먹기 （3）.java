class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int total = i * slice;
            if(total / n >= 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}