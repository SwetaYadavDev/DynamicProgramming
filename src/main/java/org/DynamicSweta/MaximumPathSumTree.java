package org.DynamicSweta;

class MaximumPathSumTree {

    // Node structure for the binary tree
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Global variable to store the overall maximum path sum
    private int maxPathSum;

    /**
     * DFS function to calculate:
     * 1. Maximum gain from this node to its parent (to continue the path upward)
     * 2. Update the global maximum path sum if the current path gives a better sum
     */
    private int dfs(Node root) {
        // Base case: if the node is null, it contributes 0 to the path
        if (root == null) return 0;

        // Recursively calculate max gain from left and right subtrees
        // If the path sum becomes negative, ignore it by taking max(0, sum)
        int leftGain = Math.max(0, dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));

        // Path passing through this node (can go left → node → right)
        int pathThroughRoot = root.data + leftGain + rightGain;

        // Update the global maximum if this path gives a larger sum
        maxPathSum = Math.max(maxPathSum, pathThroughRoot);

        /**
         * Return the maximum sum if the path continues upward:
         * Either take left path or right path (whichever is greater)
         * because path upward cannot branch into two paths.
         */
        return root.data + Math.max(leftGain, rightGain);
    }

    // Public function to get the maximum path sum in the tree
    public int maximumPathSum(Node root) {
        maxPathSum = Integer.MIN_VALUE; // Initialize to the smallest value
        dfs(root);                      // Run DFS to calculate maximum path sum
        return maxPathSum;               // Return the result
    }

    // Driver code
    public static void main(String[] args) {
        MaximumPathSumTree tree = new MaximumPathSumTree();

        // Constructing the binary tree
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        // Call the public function and print the result
        System.out.println("Maximum Path Sum: " + tree.maximumPathSum(root));
    }
}
