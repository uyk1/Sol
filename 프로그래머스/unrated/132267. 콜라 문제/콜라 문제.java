class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int keep = 0; // 남길 콜라의 수
            if(n % a != 0) keep += n % a;
            answer += b * (n / a);
            n = b * (n / a) + keep;
        }
        
        return answer;
    }
}