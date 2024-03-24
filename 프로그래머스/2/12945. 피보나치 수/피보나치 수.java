class Solution {
    public int solution(int n) {
        // DP를 위한 배열
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        
        // 피보나치 % 1234567
        if(n >= 2) {
            for(int i = 2; i <= n; i++) {
                arr[i] = ((arr[i-1] % 1234567)+ (arr[i-2] % 1234567))%1234567;
            }
        }
        
        return arr[n];
    }
}