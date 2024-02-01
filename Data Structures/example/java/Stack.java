public class Stack {

  private static final int MAX_SIZE = 100; // 스택의 최대 크기
  private int[] array; // 스택을 저장할 배열
  private int top; // 스택의 맨 위 인덱스

  public Stack() {
    this.array = new int[MAX_SIZE];
    this.top = -1; // 스택이 비어있을 때의 초기 값
  }

  // 스택에 요소 추가
  public void push(int data) {
    if (top == MAX_SIZE - 1) {
      System.out.println("Stack is full. Cannot push.");
      return;
    }

    array[++top] = data;
    System.out.println("Pushed: " + data);
  }

  // 스택에서 요소 제거
  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot pop.");
      return -1; // 임의의 값 반환
    }

    int poppedElement = array[top--];
    System.out.println("Popped: " + poppedElement);
    return poppedElement;
  }

  // 스택이 비어있는지 확인
  public boolean isEmpty() {
    return top == -1;
  }

  // 스택의 크기 확인
  public int size() {
    return top + 1;
  }

  // 스택의 모든 요소 출력
  public void printStack() {
    if (isEmpty()) {
      System.out.println("Stack is empty.");
      return;
    }

    System.out.print("Stack: ");
    for (int i = 0; i <= top; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Stack stack = new Stack();

    // 스택에 요소 추가
    stack.push(10);
    stack.push(20);
    stack.push(30);

    // 스택 출력
    stack.printStack();

    // 스택에서 요소 제거
    stack.pop();

    // 스택 출력
    stack.printStack();
  }
}
