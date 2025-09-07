package org.DynamicSweta;

class DiameterTreeDP {

    // Class to store diameter and height together for each subtree
    static class TreeInfo {
        int height;    // height of the subtree
        int diameter;  // diameter of the subtree

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Node structure for the binary tree
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // DFS function to calculate height & diameter for each node
    private TreeInfo dfs(Node root) {
        // Base case: if root is null → height = 0, diameter = 0
        if (root == null) return new TreeInfo(0, 0);

        // Recursively find info for left and right subtrees
        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        // Height = max(left height, right height) + 1
        int height = Math.max(left.height, right.height) + 1;

        // Longest path passing through this node = left height + right height
        int diameterThroughRoot = left.height + right.height;

        // Maximum diameter so far: either through root OR in left/right subtree
        int diameter = Math.max(diameterThroughRoot,
                Math.max(left.diameter, right.diameter));

        // Return height and diameter for this subtree
        return new TreeInfo(height, diameter);
    }

    // Public function to calculate diameter of tree
    public int diameterOfTree(Node root) {
        return dfs(root).diameter;
    }

    // Driver Code
    public static void main(String[] args) {
        DiameterTreeDP tree = new DiameterTreeDP();

        // Construct a sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Call the public function
        System.out.println("Diameter of tree: " + tree.diameterOfTree(root));
    }
}

