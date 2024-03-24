import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int cnt = people.length; // 사람 수
        int start = 0; // 남은 사람 중 가장 가벼운 사람의 인덱스
        int end = people.length - 1; // 남은 사람 중 가장 무거운 사람의 인덱스
        
        // 정렬
        Arrays.sort(people);
        
        // 반복문을 통해 현재 가장 적은 무게의 사람과 가장 많은 무게의 사람을 합해봄.
        while(cnt > 0) {
            if(start != end && people[start] + people[end] <= limit) {
                answer++;
                cnt -= 2;
                start++;
                end--;
            } else if(start == end) {
                answer++;
                cnt--;
                break;
            } else {
                answer++;
                cnt--;
                end--;
            }
        }
        
        return answer;
    }
}