import java.util.LinkedList;
import java.util.Queue;

// Kelas untuk melakukan traversal pada pohon pencarian biner (BST)
public class TraversalBst {
    // Akar (root) dari pohon BST
    Node root;

    // Metode untuk menyisipkan nilai baru ke dalam pohon BST
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Metode untuk traversal in-order pada pohon BST
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Metode untuk traversal post-order pada pohon BST
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Metode untuk traversal level-order pada pohon BST
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // Metode utama untuk pengujian
    public static void main(String[] args) {
        // Membuat objek TraversalBst
        TraversalBst bst = new TraversalBst();

        // Menyisipkan nilai-nilai ke dalam pohon BST
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        // Menampilkan hasil traversal in-order
        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        // Menampilkan hasil traversal post-order
        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        // Menampilkan hasil traversal level-order
        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}

