import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        int w = 0;
        int h = 0;
        for(int[] arr: sizes) {
            if(w < arr[0]) w = arr[0];
            if(h < arr[1]) h = arr[1];
        }
        answer = w*h;
        return answer;
    }
}