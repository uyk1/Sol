import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        int sum1 = Integer.parseInt(str1+str2);
        int sum2 = Integer.parseInt(str2+str1);
        if(sum1 >= sum2) answer = sum1;
        else answer = sum2;
        return answer;
    }
}