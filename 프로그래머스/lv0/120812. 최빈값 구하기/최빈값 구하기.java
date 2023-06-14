import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] count = new int[1000];
        for(int i: array) count[i]++;
        int max = -1;
        for(int i = 0; i < 1000; i++) {
            if(count[i] == max) {
                answer = -1;
                continue;
            }
            if(count[i] < max) continue;
            max = count[i];
            answer = i;
        }
        
        return answer;
    }
}