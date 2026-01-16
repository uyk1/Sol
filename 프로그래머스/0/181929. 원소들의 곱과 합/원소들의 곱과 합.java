class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        long mul = 1;
        long sum = 0;
        
        for(int i : num_list) {
            mul *= i;
            sum += i;
        }
        
        answer = mul < sum * sum ? 1 : 0;
        
        return answer;
    }
}