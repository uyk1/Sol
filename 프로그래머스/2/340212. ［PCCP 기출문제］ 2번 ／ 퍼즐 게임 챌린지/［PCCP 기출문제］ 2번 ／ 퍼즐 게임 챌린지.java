import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 시간 초과로 '이진탐색' 기법 적용
        int lo = 1;
        int hi = Arrays.stream(diffs).max().getAsInt(); // 주어진 값들 중 최대값
        
        // (추가) 풀 수 없는 문제인 경우 처리
        if(!canSolve(diffs, times, limit, hi)) return -1;
        
        // 이진탐색
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(canSolve(diffs, times, limit, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    private boolean canSolve(int[] diffs, int[] times, long limit, int mid) {
        long time = times[0];
        long prev = times[0];
        
        for(int i = 1; i < diffs.length; i++) {
            int cnt = diffs[i] - mid;
            
            if(cnt <= 0) {
                time += times[i];
            } else {
                time += cnt * (prev + times[i]) + times[i];
            }
            
            if(time > limit) return false;
            
            prev = times[i]; // 이전 퍼즐 시간 갱신
        }
        
        return time <= limit;
    }
}