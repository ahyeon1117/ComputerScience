public class Queue {

  private static final int MAX_SIZE = 100; // 큐의 최대 크기
  private int[] array; // 큐를 저장할 배열
  private int front; // 큐의 맨 앞 인덱스
  private int rear; // 큐의 맨 뒤 인덱스
  private int size; // 현재 큐에 저장된 요소의 개수

  public Queue() {
    this.array = new int[MAX_SIZE];
    this.front = 0;
    this.rear = -1;
    this.size = 0;
  }

  // 큐에 요소 추가
  public void enqueue(int data) {
    if (size == MAX_SIZE) {
      System.out.println("Queue is full. Cannot enqueue.");
      return;
    }

    rear = (rear + 1) % MAX_SIZE;
    array[rear] = data;
    size++;
    System.out.println("Enqueued: " + data);
  }

  // 큐에서 요소 제거
  public int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty. Cannot dequeue.");
      return -1; // 임의의 값 반환
    }

    int removedElement = array[front];
    front = (front + 1) % MAX_SIZE;
    size--;
    System.out.println("Dequeued: " + removedElement);
    return removedElement;
  }

  // 큐가 비어있는지 확인
  public boolean isEmpty() {
    return size == 0;
  }

  // 큐의 크기 확인
  public int size() {
    return size;
  }

  // 큐의 모든 요소 출력
  public void printQueue() {
    if (isEmpty()) {
      System.out.println("Queue is empty.");
      return;
    }

    System.out.print("Queue: ");
    int index = front;
    for (int i = 0; i < size; i++) {
      System.out.print(array[index] + " ");
      index = (index + 1) % MAX_SIZE;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Queue queue = new Queue();

    // 큐에 요소 추가
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    // 큐 출력
    queue.printQueue();

    // 큐에서 요소 제거
    queue.dequeue();

    // 큐 출력
    queue.printQueue();
  }
}
