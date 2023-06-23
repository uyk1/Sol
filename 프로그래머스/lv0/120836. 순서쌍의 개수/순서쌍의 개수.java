class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        while(num*num < n) {
            if(n % num == 0) {
                answer += 2;
            }
            num++;
        }
        if(num*num == n) answer++;
        return answer;
    }
}