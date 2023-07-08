import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split("");
        int start = 0;
        outer: while(start < s.length()) {            
            String x = arr[start]; // 검사할 값
            int xcnt = 0; // x와 동일한 값의 개수
            int ycnt = 0; // x와 다른 값의 개수
            for(int i = start; i < s.length(); i++) {
                if(arr[i].equals(x)) xcnt++;
                else ycnt++;
                
                if(xcnt == ycnt) {
                    start = i + 1;
                    answer++;
                    break;
                } else {
                    if(i == s.length() - 1) {
                        answer++;
                        break outer;
                    }
                }
            }
        }
        
        return answer;
    }
}