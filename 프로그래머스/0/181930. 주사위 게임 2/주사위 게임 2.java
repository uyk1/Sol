class Solution {
    public int solution(int a, int b, int c) {
        int answer = a + b + c;
        
        // 두 개 이상 같으면 제곱의 합을 곱함
        if (a == b || b == c || a == c) {
            answer *= (a*a + b*b + c*c);
        }
        
        // 세 개 모두 같으면 세제곱의 합을 곱함
        if (a == b && b == c) {
            answer *= (a*a*a + b*b*b + c*c*c);
        }
        
        return answer;
    }
}