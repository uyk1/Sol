import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 바구니 > Stack > Deque 활용(Stack: push, pop / Queue: offer, poll)
        Deque<Integer> bucket = new ArrayDeque<>();
        
        // board도 Stack 형식으로 전환. 열 방향으로 담아야 함에 유의.
        ArrayList<Deque<Integer>> boardStack = new ArrayList<>();
        for(int i = 0; i < board[0].length; i++) {
            boardStack.add(new ArrayDeque<Integer>());
            
            for(int j = board.length - 1; j >= 0; j--) {
                if(board[j][i] != 0) boardStack.get(i).push(board[j][i]);
            }
        }
        
        for(int i : moves) {
            Deque<Integer> stack = boardStack.get(i - 1); // 참조
            
            if(stack.isEmpty()) continue;
            
            int item = stack.pop();
            
            if(!bucket.isEmpty() && bucket.peek() == item) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.push(item);
            }
        }
        
        return answer;
    }
}