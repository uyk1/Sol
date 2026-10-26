import java.util.*;

class Solution {
    /*
    후입선출, 스택 이용.
    정렬은 과제 시작 시간 기준으로 plans를 재정렬.
    */
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Stack<String[]> stack = new Stack<>();
        
        Arrays.sort(plans, Comparator.comparing(plan -> plan[1]));
        
        int answerIndex = 0;
        
        for(int i = 0; i < plans.length - 1; i++) {
            // 스택에 담을 때, 남은 시간 확인
            String[] current = plans[i];
            String[] next = plans[i + 1];
            
            int currentStart = toMinutes(current[1]);
            int nextStart = toMinutes(next[1]);

            int availableTime = nextStart - currentStart;
            int playtime = Integer.parseInt(current[2]);
            
            if (playtime > availableTime) {
                // 현재 과제를 끝내지 못함
                // 남은 시간과 함께 스택에 저장
                stack.push(new String[] {current[0], String.valueOf(playtime - availableTime)});
            } else {
                // 현재 과제를 완료
                // answer에 이름 추가
                // 남는 시간으로 스택의 과제 처리
                
                answer[answerIndex++] = current[0];
                availableTime -= playtime;
                
                while (!stack.isEmpty() && availableTime > 0) {
                    // 가장 최근에 중단한 과제를 꺼낸다.
                    // 남은 시간과 availableTime을 비교한다.
                    String[] pop = stack.pop();
                    
                    playtime = Integer.parseInt(pop[1]);
                    
                    if(availableTime >= playtime) {
                        availableTime -= playtime;
                        answer[answerIndex++] = pop[0];
                    } else {
                        stack.push(new String[] {pop[0], String.valueOf(playtime - availableTime)});
                        availableTime = 0;
                    }
                }
            }
        }
        
        // 마지막 과제는 따로 처리 > 다음 과제가 없으므로 바로 완료
        answer[answerIndex++] = plans[plans.length - 1][0];

        while (!stack.isEmpty()) {
            answer[answerIndex++] = stack.pop()[0];
        }
        
        return answer;
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60
             + Integer.parseInt(parts[1]);
    }
}