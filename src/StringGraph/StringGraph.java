package StringGraph;

import java.util.*;

// Kelas untuk merepresentasikan graf berbasis string
class StringGraph {
    // Daftar ketetanggaan menggunakan Map
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi graf
    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul ke graf
    public void addNode(String node) {
        // Menambahkan simpul baru jika belum ada simpulnya
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan sebuah sisi antar simpul
    public void addEdge(String source, String destination) {
        // Menambahkan tujuan sebagai tetangga dari sumber simpul
        adjacencyList.get(source).add(destination);
    }

    // Metode untuk mencetak graf
    public void printGraph() {
        // Iterasi melalui setiap simpul
        for (String node : adjacencyList.keySet()) {
            // Mencetak simpul dan tetangganya
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            // Pindah ke baris baru setelah mencetak tetangga dari suatu simpul
            System.out.println();
        }
    }

    // Metode pertama untuk pengujian
    public static void main(String[] args) {
        // Membuat objek graf
        StringGraph graph = new StringGraph();

        // Menambahkan simpul-simpul
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan sebuah sisi pada antar simpul
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak graf
        graph.printGraph();
    }
}

