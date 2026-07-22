class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        // 주기 구하기
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        // 초침-시침 1/60-1/43200 = 719/43200
        // 초침-분침 1/60-1/3600 = 59/3600
        // 초침-분침-시침 1/43200 << 겹치는 구간으로, 빼줘야 함
        int a = count(start, end, 43200, 719);
        int b = count(start, end, 3600, 59);
        int c = count(start, end, 43200, 1);
        
        return a + b - c;
    }
    
    // 시작시간, 끝시간, 주기를 받아 겹치는 횟수 반환
    private int count(int start, int end, int mult, int div) {
        int min = (start * div + mult - 1) / mult; // 올림
        int max = end * div / mult; // 내림
        
        return Math.max(0, max - min + 1); // max - min + 1는 min max 구간에 포함되는 정수의 개수를 의미.
    }
}