import java.util.*;

//이중 for문은 시간초과 -> map 이용
class Solution {
    public String[] solution(String[] players, String[] callings) {
        //해시맵, 용량 지정
        HashMap<String, Integer> map = new HashMap<>(players.length);
        for(int i = 0; i < players.length; i++) map.put(players[i], i);
        //호명
        for(String player: callings) {
            int currRank = map.get(player);
            String prePlayer = players[currRank-1];
            //players 배열 수정
            players[currRank] = prePlayer;
            players[currRank-1] = player;
            //순위 변경
            map.put(prePlayer, currRank);
            map.put(player, currRank-1);
        }
        return players;
    }
}