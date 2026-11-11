package Punto4A;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Returns the (possibly new) subtree root so the parent can re-link it
    private TreeNode insertRec(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);            // empty spot: create the node here
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }
        // equal key: ignored, because codes are unique
        return node;
    }

    public static int countEquipmentInRange(TreeNode node, int min, int max) {
        // Base case: empty subtree, or a range that cannot contain any key
        if (node == null || min > max) {
            return 0;
        }

        int count = 0;

        // The node itself counts if its key is inside [min, max]
        if (node.key >= min && node.key <= max) {
            count = 1;
        }

        // Left subtree has keys < node.key. It can only contain keys >= min
        // if node.key > min. Otherwise the whole left branch is pruned.
        if (node.key > min) {
            count += countEquipmentInRange(node.left, min, max);
        }

        // Right subtree has keys > node.key. It can only contain keys <= max
        // if node.key < max. Otherwise the whole right branch is pruned.
        if (node.key < max) {
            count += countEquipmentInRange(node.right, min, max);
        }

        return count;
    }
}