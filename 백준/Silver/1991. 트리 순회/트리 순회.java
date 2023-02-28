import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //자신과 자식들(왼쪽, 오른쪽)을 가진 노드 클래스
    static class Node {
        char data;
        Node left, right;
        //자식이 없는 경우의 수도 있을 수 있음
        public Node(char data) {
            this.data = data;
        }
    }
    //트리 클래스 구현
    static class Tree {
        Node root;
        //추가
        public void add(char data, char left_data, char right_data) {
            if(root == null) {
                //data가 .이 아니라면 루트 노트 추가
                if(data != '.') root = new Node(data);
                if(left_data != '.') root.left = new Node(left_data);
                if(right_data != '.') root.right = new Node(right_data);
            } else {
                //root가 존재한다면 탐색 후 추가할 것
                search(root, data, left_data, right_data);
            }
        }
        //탐색
        public void search(Node root, char data, char left_data, char right_data) {
            if(root == null) return;
            else if(root.data == data) {
                //data가 일치하는 노드를 찾으면 자식 노드 추가
                if(left_data != '.') root.left = new Node(left_data);
                if(right_data != '.') root.right = new Node(right_data);
            }
            else {
                //왼쪽, 오른쪽 자식 탐색
                search(root.left, data, left_data, right_data);
                search(root.right, data, left_data, right_data);
            }
        }
        //전위 순회 (중 -> 좌 -> 우)
        public void preorder(Node root) {
            System.out.print(root.data);
            if(root.left != null) preorder(root.left);
            if(root.right != null) preorder(root.right);
        }
        //중위 순회 (좌 -> 중 -> 우)
        public void inorder(Node root) {
            if(root.left != null) inorder(root.left);
            System.out.print(root.data);
            if(root.right != null) inorder(root.right);
        }
        //후위 순회 (좌 -> 우 -> 중)
        public void postorder(Node root) {
            if(root.left != null) postorder(root.left);
            if(root.right != null) postorder(root.right);
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //이진 트리의 노드 개수
        Tree tree = new Tree();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left_data = st.nextToken().charAt(0);
            char right_data = st.nextToken().charAt(0);
            tree.add(data, left_data, right_data);
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}