import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] std = new int[n];
        Arrays.fill(std, 1);
        for(int i: lost) {
            std[i-1]--;
        }
        for(int i:reserve) {
            std[i-1]++;
        }
        for(int i = 0; i < n; i++) {
            if(std[i] != 0) continue;
            if(i-1 >= 0 && std[i-1] == 2) {
                std[i-1] = 1;
                std[i] = 1;
            } else if(i+1 < n && std[i+1] == 2) {
                std[i+1] = 1;
                std[i] = 1;
            }
        }
        for(int i: std) if(i >= 1) answer++;
        return answer;
    }
}