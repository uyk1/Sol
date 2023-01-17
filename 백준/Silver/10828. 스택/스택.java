import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	interface Stack{
		boolean isEmpty();
		boolean isFull();
		void push(String item);
		String pop();
		String peek();
		void clear();
	}
	
	static class ArrayStack implements Stack {
		
		private int top;
		private int stackSize;
		private String stackArr[];
		
		public int getTop() {
			return top;
		}

		public int getStackSize() {
			return stackSize;
		}

		public String[] getStackArr() {
			return stackArr;
		}

		//스택 생성을 위한 생성자
		public ArrayStack(int stackSize) {
			top = -1;
			this.stackSize = stackSize;
			stackArr = new String[this.stackSize];
		}

		@Override //스택이 비어있는 상태인지 확인
		public boolean isEmpty() {
			//스택 포인터가 -1인 경우 스택이 빈 상태 아니면 스택에 데이터가 존재
			return top == -1;
		}

		@Override //스택이 가득찬 상태인지 확인
		public boolean isFull() {
			//스택 포인터가 스택의 마지막 인덱스와 동일한 경우 true
			return top == this.stackSize - 1;
		}

		@Override //데이터 추가
		public void push(String item) {
			if(isFull()) {
				System.out.println("Full");
			} else {
				stackArr[++top] = item;
			}
		}

		@Override //스택 최상위(마지막) 데이터 추출 후 삭제
		public String pop() {
			if(isEmpty()) {
				return "0";
			} else {
				return stackArr[top--];
			}
		}

		@Override //스택 최상위 데이터 추출
		public String peek() {
			if(isEmpty()) {
				return "0";
			} else {
				return stackArr[top];
			}
		}

		@Override //스택에 저장된 모든 데이터 출력
		public void clear() {
			if(isEmpty()) {
				System.out.println("Empty");
			} else {
				for(int i = 0; i <= top; i++) {
					System.out.println(stackArr[i] + " ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int stackSize = 10000;
		ArrayStack stack = new ArrayStack(stackSize);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			String[] act = new String[size];
			for(int j = 0; j < size; j++) act[j] = st.nextToken();
			if(act[0].equals("push")) stack.push(act[1]);
			else if(act[0].equals("pop")) {
				String tmp = stack.pop();
				if(!tmp.equals("0")) sb.append(tmp + "\n");
				else sb.append(-1 + "\n");
			}
			else if(act[0].equals("size")) sb.append((stack.getTop() + 1) + "\n");
			else if(act[0].equals("empty")) {
				if(stack.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			else if(act[0].equals("top")) {
				if(stack.getTop() != -1) sb.append(stack.peek() + "\n");
				else sb.append(-1 + "\n");
			}
		}
		System.out.println(sb);
	}
}