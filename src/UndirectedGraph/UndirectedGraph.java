package UndirectedGraph;

import java.util.*;

// Kelas untuk merepresentasikan graf tak berarah
class UndirectedGraph {
    // Daftar ketetanggaan menggunakan Map
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi graf
    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul ke graf
    public void addNode(String node) {
        // Menambahkan simpul baru jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan sisi antar simpul (graf tak berarah)
    public void addEdge(String source, String destination) {
        // Menambahkan simpul sumber dan tujuan jika belum ada
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Menambahkan tujuan sebagai tetangga dari sumber, dan sebaliknya (karena graf tak berarah)
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Metode untuk mendapatkan tetangga dari suatu simpul
    public List<String> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dari simpul, atau daftar kosong jika simpul tidak ditemukan
        return adjacencyList.getOrDefault(node, Collections.emptyList());
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

    // Sebuah metode untuk melakukan suatu  pengujian
    public static void main(String[] args) {
        // Membuat objek graf
        UndirectedGraph graph = new UndirectedGraph();

        // Menambahkan simpul-simpul
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan sisi-sisi antar simpul (graf tak berarah)
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Mencetak graf
        graph.printGraph();
    }
}

