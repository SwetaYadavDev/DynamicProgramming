package org.DynamicSweta;

class MaxLeafToLeafPathSum {

    // Node structure for the binary tree
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Global variable to store the maximum leaf-to-leaf path sum
    private int maxLeafToLeafSum;

    /**
     * DFS function returns the maximum root-to-leaf path sum for current node
     * Also updates the global maximum if both left & right subtrees exist
     */
    private int dfs(Node root) {
        // Base case: if node is null → return 0 (no contribution)
        if (root == null) return 0;

        // If node is a leaf, just return its value
        if (root.left == null && root.right == null) return root.data;

        // Recursively get max path sum from left and right subtrees
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        // If both children exist → this is a candidate for leaf-to-leaf path
        if (root.left != null && root.right != null) {
            // Update global maximum with leaf-to-leaf path through this node
            maxLeafToLeafSum = Math.max(maxLeafToLeafSum, leftSum + rightSum + root.data);

            // Return max path from this node to one leaf (for parent path)
            return root.data + Math.max(leftSum, rightSum);
        }

        // If only one child exists → return root + path from that side
        return (root.left == null) ? root.data + rightSum : root.data + leftSum;
    }

    // Public function to calculate maximum leaf-to-leaf path sum
    public int maxLeafToLeafPathSum(Node root) {
        maxLeafToLeafSum = Integer.MIN_VALUE; // Initialize with smallest value
        dfs(root);
        return maxLeafToLeafSum;
    }

    // Driver code
    public static void main(String[] args) {
        MaxLeafToLeafPathSum tree = new MaxLeafToLeafPathSum();

        // Construct a sample tree
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);

        // Compute maximum leaf-to-leaf path sum
        System.out.println("Max Leaf-to-Leaf Path Sum: " + tree.maxLeafToLeafPathSum(root));
    }
}

