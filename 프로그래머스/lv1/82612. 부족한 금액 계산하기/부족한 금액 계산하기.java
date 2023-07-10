class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        long tCnt = 0;
        for(int i = 1; i <= count; i++) tCnt += i;
        answer -= tCnt * price;
        if(answer >= 0) return 0;
        return answer * -1;
    }
}