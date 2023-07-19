class Solution {
    public String solution(int n) {
        String answer = "";
        char[] arr = {'수', '박'};
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) answer += arr[0];
            else answer += arr[1];
        }
        return answer;
    }
}