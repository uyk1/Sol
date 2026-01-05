class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        
        if(number % lcm(n, m) == 0) answer = 1;
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        // 최소공약수 구하기(재귀)
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    private int lcm(int a, int b) {
        // 최소공배수 구하기
        return (a * b) / gcd(a, b);
    }
}