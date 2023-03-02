import java.util.Scanner;

public class Main {
    //각 노드의 키값은 10^6보다 작은 양의 정수
    static int[] tree = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //전위 순회한 결과 입력 받기
        int cnt = 0;
        while(sc.hasNext()) tree[cnt++] = sc.nextInt();
        //후위 순회한 결과 출력
        postOrder(0, cnt-1);
    }

    //후위 순회한 결과를 찾기 위한 메서드
    static void postOrder(int start, int end) {
        //start와 end가 같은 경우도 본인을 출력해야하므로 > 대신 >=를 사용할 수 없음.
        if(start > end) return;
        //루트의 오른쪽 자식 노드 찾기
        int right = start+1;
        while(right <= end && tree[right] < tree[start]) right++;
        //재귀 좌우
        postOrder(start+1, right-1);
        postOrder(right, end);
        //루트 값 출력
        System.out.println(tree[start]);
    }
}