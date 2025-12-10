public class BST {
    Node root;

    BST() {
        this.root = null;
    }

    // 1) Insert  50, 30, 70, 20, 40, 60, 80, 35, 45, 65
    public void insert(int v) {
        if (root == null) {
            root = new Node(v);
            return;
        }
        Node cur = root; // 50 This pointer will be used to traverse down the tree to find the correct insertion spot
        while (true) { //20
            if (v < cur.val) { // Go Left Subtree
                if (cur.left == null) {
                    cur.left = new Node(v);
                    return;
                }
                cur = cur.left; //30 If the left child is not empty, the cur pointer moves down to the left child,
                // and the loop repeats, checking the new current node.
            } else { //70 Go Right Subtree
                if (cur.right == null) {
                    cur.right = new Node(v);
                    return;
                }
                cur = cur.right; // If the right child is not empty,
                // the cur pointer moves down to the right child, and the loop repeats.
            }
        }
    }

    // 2) Search (returns true if found)
    public boolean search(int v) {
        Node cur = root;
        while (cur != null) {
            if (v == cur.val) return true;
            cur = (v < cur.val) ? cur.left : cur.right;
            //if v < cur.left then cur=cur.left
            //if v > cur.left then cur=cur.right
        }
        return false;
    }


    // 3) Delete (standard BST delete using inorder successor)
    public void delete(int v) {
        root = deleteRec(root, v);
    }

    public Node deleteRec(Node node, int key) {
        if (node == null) return null; // no node to delete because empty
        if (key < node.val) {
            node.left = deleteRec(node.left, key); // Go Left sub-tree
        } else if (key > node.val) {               // Go Left sub-tree
            node.right = deleteRec(node.right, key);
        } else {   // node to delete found // key == node.val
            // case 1: no child  // If both children are null, the node is a leaf.
            // To delete it, we simply return null.
            // This null value is then assigned to the parent's left or right pointer in the previous recursive call,
            if (node.left == null && node.right == null) return null;
            // case 2: one child
            if (node.left == null) return node.right; // if righ child exist
            if (node.right == null) return node.left; // if left child exist
            // case 3: two children -> find inorder successor (smallest in right subtree)
            Node succ = minNode(node.right); //35
            node.val = succ.val; // copy successor value
            node.right = deleteRec(node.right, succ.val); // delete successor node
        }
        return node;
    }

    public Node minNode(Node node) {//40
        Node cur = node;
        while (cur.left != null) cur = cur.left; // the cur pointer moved down to its left child.
        return cur;
    }

}
