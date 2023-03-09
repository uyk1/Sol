import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]); //NullPointerException
        int last = arr[0]; //맨 마지막에 넣은 값을 저장
        for(int i: arr) {
            if(i != last) {
                q.add(i);
                last = i;
            }
        }
        int size = q.size();
        answer = new int[size];
        for(int i = 0; i < size; i++) answer[i] = q.poll();        

        return answer;
    }
}