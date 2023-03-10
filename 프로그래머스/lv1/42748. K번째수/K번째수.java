import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] c = commands[i];
            int[] tmp = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(tmp);
            answer[i] = tmp[c[2]-1];
        }
        
        return answer;
    }
}