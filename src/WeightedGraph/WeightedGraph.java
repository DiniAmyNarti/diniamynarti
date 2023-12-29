package WeightedGraph;

// Import  yang diperlukan
import java.util.*;

// Kelas untuk merepresentasikan tepi (Edge) dalam graf berbobot
class Edge {
    // Variabel untuk menyimpan tujuan dan bobot tepi
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edge
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Kelas untuk merepresentasikan graf berbobot
class WeightedGraph {
    // Daftar ketetanggaan menggunakan Map, dengan daftar tepi (Edge) untuk setiap simpul
    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor untuk inisialisasi graf berbobot
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            // Untuk mengeprint sebuah kelas yang sudah benar
            System.out.println();
        }
    }

    // Metode utama untuk pengujian
    public static void main(String[] args) {
        // Membuat objek graf berbobot
        WeightedGraph graph = new WeightedGraph();

        // Menambahkan node atau simpul
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan sebuah sisi ke antar simpul dengan bobot
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Mencetak graf berbobot
        graph.printGraph();
    }

}



