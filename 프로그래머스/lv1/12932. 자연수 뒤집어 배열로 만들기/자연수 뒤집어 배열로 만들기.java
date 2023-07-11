import java.util.*;

class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        int[] answer = new int[num.length()];
        for(int i = 1; i <= num.length(); i++) {
            int tmp = 0;
            if(i == 1) tmp = Integer.parseInt(num.substring(num.length() - 1));
            else tmp = Integer.parseInt(num.substring(num.length() - i, num.length() - i + 1));
            answer[i-1] = tmp;
        }
        
        return answer;
    }
}