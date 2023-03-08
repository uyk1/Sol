import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        for(char c: arr) {
            int i = c - '0';
            answer += i;
        }
        return answer;
    }
}