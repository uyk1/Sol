import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] l = new int[]{3, 0}; // 왼손 시작 위치
        int[] r = new int[]{3, 2}; // 오른손 시작 위치
        
        for(int i : numbers) {
            if(i == 1 || i == 4 || i == 7) {
                answer += "L";
                l = new int[]{i / 3, 0};
                continue;
            }
            else if(i == 3 || i == 6 || i == 9) {
                answer += "R";
                r = new int[]{i / 4, 2};
                continue;
            }
            else {
                int[] target = new int[2];
                
                target[1] = 1;
                if(i == 2) {
                    target[0] = 0;
                } else if(i == 5) {
                    target[0] = 1;
                } else if(i == 8) {
                    target[0] = 2;
                } else {
                    target[0] = 3;
                }
                
                // 현재 위치에서 거리 비교
                int ld = Math.abs(l[0] - target[0]) + Math.abs(l[1] - target[1]);
                int rd = Math.abs(r[0] - target[0]) + Math.abs(r[1] - target[1]);
                
                if(ld == rd) {
                    if(hand.equals("left")) {
                        answer += "L";
                        l = target;
                    } else {
                        answer += "R";
                        r = target;
                    }
                } else if(ld < rd) {
                    answer += "L";
                    l = target;
                } else {
                    answer += "R";
                    r = target;
                }
            }
        }
        
        return answer;
    }
}