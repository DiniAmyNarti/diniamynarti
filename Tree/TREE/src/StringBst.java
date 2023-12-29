import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kelas node untuk merepresentasikan simpul dalam pohon biner
class node{
    String value;
    Node left;
    Node right;

    // Konstruktor untuk membuat objek Node dengan nilai tertentu
    public node(String value) {
        this.value = value;
        left = null;
        right = null;
    }
}

// Kelas StringBst untuk merepresentasikan pohon pencarian biner (BST) dengan nilai String
class StringBst {
    Node root;
    private int Value;

    // Konstruktor untuk membuat objek StringBst dengan root null
    public StringBst() {
        root = null;
    }

    // Metode untuk menyisipkan nilai String ke dalam pohon BST
    public Node insert(Node root, String value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.compareTo(String.valueOf(root.value)) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(String.valueOf(root.value)) > 0) {
        } else if (value.compareTo(String.valueOf(root.value)) > 0) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Metode untuk traversal pre-order pada pohon BST
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Metode untuk traversal in-order pada pohon BST
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    // Metode untuk traversal post-order pada pohon BST
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Metode untuk traversal level-order pada pohon BST
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Metode untuk mencetak struktur pohon biner
    public void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);
            List<Node> children = new ArrayList<>();
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
            for (int i = 0; i < children.size() - 1; i++) {
                printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            if (children.size() > 0) {
                printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // Metode utama untuk pengujian
    public static void main(String[] args) {
        // Membuat objek StringBst
        StringBst tree = new StringBst();
        // Menyisipkan nilai-nilai String ke dalam pohon BST
        tree.root = tree.insert(tree.root, "Mango");
        tree.insert(tree.root, "Apple");
        tree.insert(tree.root, "Orange");
        tree.insert(tree.root, "Banana");
        tree.insert(tree.root, "Grapes");
        tree.insert(tree.root, "Pineapple");
        tree.insert(tree.root, "Peach");

        // Menampilkan struktur pohon biner
        System.out.println("Struktur pohon biner:");
        tree.printTree(tree.root, "", true);

        // Menampilkan hasil traversal pre-order
        System.out.println("Traversal pre-order:");
        tree.preorder(tree.root);

        // Menampilkan hasil traversal in-order
        System.out.println("\nTraversal in-order:");
        tree.inorder(tree.root);

        // Menampilkan hasil traversal post-order
        System.out.println("\nTraversal post-order:");
        tree.postorder(tree.root);

        // Menampilkan hasil traversal level-order
        System.out.println("\nTraversal level-order:");
        tree.levelOrder(tree.root);
    }
}
