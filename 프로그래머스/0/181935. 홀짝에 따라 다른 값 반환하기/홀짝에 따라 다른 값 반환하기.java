class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 == 1) answer = cal1(n);
        else answer = cal2(n);
        
        return answer;
    }
    
    private int cal1(int a) {
        int result = 0;
        
        while(a > 0) {
            result += a;
            a -= 2;
        }
        
        return result;
    }
    
    private int cal2(int a) {
        int result = 0;
        
        while(a > 0) {
            result += a * a;
            a -= 2;
        }
        
        return result;
    }
}