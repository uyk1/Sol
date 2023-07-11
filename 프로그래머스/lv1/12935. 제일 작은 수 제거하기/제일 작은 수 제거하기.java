import java.math.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        
        int[] answer = new int[arr.length - 1];
        int tmp = arr[0];
        for(int i: arr) {
            tmp = Math.min(tmp, i);
        }
        int idx = 0;
        for(int i: arr) {
            if(i == tmp || idx == arr.length - 1) continue;
            answer[idx++] = i;
        }
        
        return answer;
    }
}