import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String b: babbling) {
            // 연속 발음 x
            if(b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) continue;
            // 가능한 발음 지우기 // " "로 바꾸는 이유는 ""로 바꿀 시 앞뒤가 합쳐지면서 가능한 발음이 생길 수 있기 때문.
            b = b.replace("aya", " ");
            b = b.replace("ye", " ");
            b = b.replace("woo", " ");
            b = b.replace("ma", " ");
            b = b.replace(" ", "");
            
            if(b.length() == 0) answer++;
        }
        return answer;
    }
}
// 발음할 수 있는 만큼 지워버리기