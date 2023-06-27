import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 2;
        Arrays.sort(sides);
        int a = 0, b = 0;
        for(int i = 0; i < 3; i++) {
            if(i == 2) b = sides[i];
            else a += sides[i];
        }
        if(a > b) answer = 1;
        return answer;
    }
}