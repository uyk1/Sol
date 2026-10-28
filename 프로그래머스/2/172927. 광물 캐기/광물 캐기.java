import java.util.*;

class Solution {
    /*
    한 번 사용한 곡괭이는 5번 지속 사용 > 5개씩 광물들을 묶어 비용 합산 후 정렬
    */
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[][] buckets = new int[(minerals.length + 4) / 5][4];
        
        for(int i = 0; i < (minerals.length + 4) / 5; i++) {
            int startIdx = i * 5;
            
            for(int j = 0; j < 5; j++) {
                int currIdx = startIdx + j;
                
                if(currIdx >= minerals.length) break;
                
                if(minerals[currIdx].equals("diamond")) {
                    buckets[i][0] += 25;
                    buckets[i][1]++;
                } else if(minerals[currIdx].equals("iron")) {
                    buckets[i][0] += 5;
                    buckets[i][2]++;
                } else if(minerals[currIdx].equals("stone")) {
                    buckets[i][0] += 1;
                    buckets[i][3]++;
                }
            }
        }
        
        int maxBuckets = Math.min(
            buckets.length,
            picks[0] + picks[1] + picks[2]
        );

        Arrays.sort(
            buckets,
            0,
            maxBuckets,
            (a, b) -> {
                if(a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(b[2], a[2]);
            }
        );
        
        for(int[] bucket : buckets) {
            if(picks[0] != 0) {
                picks[0]--;
                answer += bucket[1] * 1 + bucket[2] * 1 + bucket[3] * 1;
            } else if(picks[1] != 0) {
                picks[1]--;
                answer += bucket[1] * 5 + bucket[2] * 1 + bucket[3] * 1;
            } else if(picks[2] != 0) {
                picks[2]--;
                answer += bucket[1] * 25 + bucket[2] * 5 + bucket[3] * 1;
            }
            
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
        }
        
        return answer;
    }
}