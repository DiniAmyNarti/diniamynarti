package BfsGraphTraversal;

import java.util.*;

// Kelas untuk merepresentasikan sisi (edges) dari sebuah graf
class Edges {
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edges dengan tujuan (destination) dan sebuah nama(weight)
    public Edges(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Kelas utama untuk penelusuran graf menggunakan BFS (Breadth-First Search)
public class BfsGraphTraversal {
    private Map<String, List<Edges>> adjacencyList; // Representasi adjacency list untuk graf

    // Konstruktor untuk inisialisasi adjacency list
    public BfsGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan sisi (edge) ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node source sudah ada dalam graf
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan sisi ke node source
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    // Metode untuk mendapatkan tetangga-tetangga dari suatu node
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk melakukan penelusuran graf menggunakan BFS
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // Tambahkan node awal ke antrian dan tandai sebagai sudah dikunjungi
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            // Iterasi melalui tetangga-tetangga dari node saat ini
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                // Jika tetangga belum dikunjungi, tambahkan ke antrian dan tandai sebagai sudah dikunjungi
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        BfsGraphTraversal graph = new BfsGraphTraversal();

        // Menambahkan node dan sisi-sisi ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Melakukan penelusuran BFS dari node "A"
        graph.bfsTraversal("A");
    }
}

