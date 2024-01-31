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

class BinaryTree {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();

    // 이진 트리에 노드 추가
    binaryTree.insert(50);
    binaryTree.insert(30);
    binaryTree.insert(70);
    binaryTree.insert(20);
    binaryTree.insert(40);
    binaryTree.insert(60);
    binaryTree.insert(80);

    // 중위 순회로 출력
    System.out.println("이진 트리 중위 순회:");
    binaryTree.inorderTraversal();
  }

  private TreeNode root;

  public BinaryTree() {
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

  public void inorderTraversal() {
    inorderTraversalRec(root);
  }

  private void inorderTraversalRec(TreeNode root) {
    if (root != null) {
      String direction = root.isLeftChild == true ? "Left" : "Right";
      inorderTraversalRec(root.left);
      System.out.println(
        String.format(
          "Data : %s, Direction : %s, Depth : %s",
          root.data,
          direction,
          findNodeDepth(root)
        )
      );
      inorderTraversalRec(root.right);
    }
  }

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
}
