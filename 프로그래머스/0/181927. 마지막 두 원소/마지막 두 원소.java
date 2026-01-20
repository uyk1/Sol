class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length + 1;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++) {
            if(i == len - 1) answer[i] = num_list[i - 2] < num_list[i - 1] ? num_list[i - 1] - num_list[i - 2] : num_list[i - 1] * 2;
            else answer[i] = num_list[i];
        }
        
        return answer;
    }
}