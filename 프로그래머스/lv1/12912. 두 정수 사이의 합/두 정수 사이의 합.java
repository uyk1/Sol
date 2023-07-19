class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        long answer = 0;
        int big = Math.max(a, b), small = Math.min(a, b);
        long tmp = big + small; //여기서 합을 long으로 받지 않으면 오버플로우..
        if((big - small) % 2 == 0) {
            //홀수개
            answer = tmp * ((big - small)/2) + (tmp/2);
        } else {
            //짝수개
            answer = tmp * ((big - small)/2 + 1);
        }
        return answer;
    }
}