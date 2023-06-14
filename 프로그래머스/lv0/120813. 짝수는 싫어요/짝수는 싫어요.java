class Solution {
    public int[] solution(int n) {
        int idx = 0;
        if(n%2 == 0) idx = n/2;
        else idx = n/2+1;
        int[] answer = new int[idx];
        for(int i = 0; i < idx; i++) answer[i] = 2 * i + 1;
        return answer;
    }
}