class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;
  TreeNode parent; // 부모 노드의 포인터
  boolean isLeftChild; // 현재 노드가 부모의 왼쪽 자식인지 여부

  public TreeNode(int data, TreeNode parent, boolean isLeftChild) {
    this.data = data;
    this.left = null;
    this.right = null;
    this.parent = parent;
    this.isLeftChild = isLeftChild;
  }
}

class BinarySearchTree {

  private TreeNode root;

  public BinarySearchTree() {
    this.root = null;
  }

  // 새 노드를 추가하는 메서드
  public void insert(int data) {
    root = insertRec(null, root, data, false); // 부모가 없으므로 null 전달
  }

  private TreeNode insertRec(
    TreeNode parent,
    TreeNode root,
    int data,
    boolean isLeftChild
  ) {
    if (root == null) {
      root = new TreeNode(data, parent, isLeftChild);
      return root;
    }

    if (data < root.data) {
      root.left = insertRec(root, root.left, data, true);
    } else if (data > root.data) {
      root.right = insertRec(root, root.right, data, false);
    }

    return root;
  }

  // BST를 중위 순회하여 정렬된 순서로 출력하는 메서드
  public void inorderTraversal() {
    inorderTraversalRec(root);
    System.out.println();
  }

  private void inorderTraversalRec(TreeNode root) {
    if (root != null) {
      inorderTraversalRec(root.left);
      String direction = root.isLeftChild ? "Left" : "Right";
      System.out.println(
        String.format(
          "Data: %s, Direction: %s, Depth: %s",
          root.data,
          direction,
          findNodeDepth(root)
        )
      );
      inorderTraversalRec(root.right);
    }
  }

  // BST에서 값을 찾는 메서드
  public boolean search(int data) {
    return searchRec(root, data);
  }

  private boolean searchRec(TreeNode root, int data) {
    if (root == null) {
      return false;
    }

    if (data == root.data) {
      return true;
    } else if (data < root.data) {
      return searchRec(root.left, data);
    } else {
      return searchRec(root.right, data);
    }
  }

  // BST에서 특정 노드의 깊이를 찾는 메서드
  public int findNodeDepth(TreeNode targetNode) {
    return findNodeDepthRec(root, targetNode, 0);
  }

  private int findNodeDepthRec(
    TreeNode root,
    TreeNode targetNode,
    int currentDepth
  ) {
    if (root == null) {
      return -1;
    }

    if (root == targetNode) {
      return currentDepth;
    }

    int leftDepth = findNodeDepthRec(root.left, targetNode, currentDepth + 1);
    if (leftDepth != -1) {
      return leftDepth;
    }

    int rightDepth = findNodeDepthRec(root.right, targetNode, currentDepth + 1);
    return rightDepth;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    // BST에 값 추가
    bst.insert(50);
    bst.insert(30);
    bst.insert(70);
    bst.insert(20);
    bst.insert(40);
    bst.insert(60);
    bst.insert(80);

    // 중위 순회로 출력하여 정렬된 순서 확인
    System.out.println("BST 중위 순회:");
    bst.inorderTraversal();

    // 특정 값 검색
    int searchValue = 40;
    if (bst.search(searchValue)) {
      System.out.println("BST에서 " + searchValue + "를 찾았습니다.");
    } else {
      System.out.println("BST에서 " + searchValue + "를 찾지 못했습니다.");
    }

    // 특정 노드의 깊이 찾기
    TreeNode targetNode = bst.root.left.right; // 예시로 노드를 선택
    int depth = bst.findNodeDepth(targetNode);
    System.out.println("노드의 깊이: " + depth);
  }
}
