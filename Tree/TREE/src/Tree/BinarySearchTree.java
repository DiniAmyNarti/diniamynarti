package Tree;

import java.util.LinkedList;
import java.util.Queue;

// Kelas Node untuk merepresentasikan simpul dalam pohon biner
class Node {
    int data;
    Node left;
    Node right;

    // Konstruktor untuk membuat objek Node dengan data tertentu
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Kelas BinarySearchTree untuk merepresentasikan pohon pencarian biner
public class BinarySearchTree {
    // Akar (root) dari pohon biner
    Node root;

    // Konstruktor untuk membuat objek BinarySearchTree dengan root null
    public BinarySearchTree() {
        root = null;
    }

    // Metode untuk membuat pohon biner sampel
    public void createSampleTree() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);

        root.right.left.left = new Node(10);
    }

    // Metode utama untuk pengujian
    public static void main(String[] args) {
        // Membuat objek BinarySearchTree
        BinarySearchTree tree = new BinarySearchTree();
        // Membuat pohon biner sampel
        tree.createSampleTree();

        // Menampilkan hasil traversal Preorder
        System.out.println("Traversal Preorder:");
        tree.preorderTraversal(tree.root);

        // Menampilkan hasil traversal Inorder
        System.out.println("\nTraversal Inorder:");
        tree.inorderTraversal(tree.root);

        // Menampilkan hasil traversal Postorder
        System.out.println("\nTraversal Postorder:");
        tree.postorderTraversal(tree.root);

        // Menampilkan hasil traversal Level Order
        System.out.println("\nTraversal Level Order:");
        tree.levelOrderTraversal(tree.root);
    }

    // Metode untuk traversal Preorder pada pohon biner
    private void preorderTraversal(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // Metode untuk traversal Inorder pada pohon biner
    private void inorderTraversal(Node node) {
        if (node == null)
            return;

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    // Metode untuk traversal Postorder pada pohon biner
    private void postorderTraversal(Node node) {
        if (node == null)
            return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // Metode untuk traversal Level Order pada pohon biner
    private void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }
}

