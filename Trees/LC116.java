public class LC116{

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    //  APPROACH 1 - USING BFS
    public Node connect(Node root) {
        if (root == null)  return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size>0) {
                Node node = queue.poll();
                if (node.left!=null && node.right!=null) {
                    node.left.next = node.right;
                }

                if (node.right!=null && node.next!=null){
                    node.right.next = node.next.left;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return root;
    }

    //  APPROACH 2 - USING RECURSION
    public Node connect(Node root) {
        if (root == null)  return null;

        if (root.left!=null) {
            root.left.next = root.right;
            if (root.next!=null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}