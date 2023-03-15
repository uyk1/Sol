import java.util.*;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); //논문의 인용 횟수를 오름차순 정렬
        //h번 인용된 논문이 h편 이상
        int length = citations.length;
        for(int i = 0; i < length; i++) {
            //예를 들어 citations[0] = 5이면 h-index는 5
            int h = length - i;
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}