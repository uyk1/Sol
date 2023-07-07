class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int cnt = 0; // 약수의 개수
            for(int j = 1; j * j <= i; j++) {
                if(i % j == 0) {
                    cnt++;
                    if(i / j != j) cnt++;
                }
                if(cnt > limit) {
                    cnt = power;
                    break;
                }
            }
            answer += cnt;
        }
        return answer;
    }
}
// 즉, 총 공격력 구하기