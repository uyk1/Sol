class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long outerSq = (long) r2 * r2 - (long) x * x;
            long innerSq = (long) r1 * r1 - (long) x * x;
            
            long maxY = (long) Math.floor(Math.sqrt(outerSq));
            long minY = (long) Math.ceil(Math.sqrt(innerSq));
            
            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}