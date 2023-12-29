package SimpleGraph;

import java.util.*;

// Kelas untuk merepresentasikan graf sederhana
class SimpleGraph {
    // Daftar ketetanggaan menggunakan sebuah privet map
    private Map<Integer, List<Integer>> adjacencyList;

    // Konstruktor untuk inisialisasi graf
    public SimpleGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul ke dalam graf
    public void addNode(Integer node) {
        // Menambahkan simpul baru jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan sisi antar simpul
    public void addEdge(int source, int destination) {
        // Menambahkan tujuan sebagai sebuah antar berhubungan
        adjacencyList.get(source).add(destination);
    }

    // Metode untuk mendapatkan hasil dari suatu simpul
    public List<Integer> getNeighbors(int node) {
        // Mengembalikan daftar hasil dari simpul, atau daftar kosong jika simpul tidak ditemukan
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk mencetak graf
    public void printGraph() {
        // Iterasi melalui setiap simpul
        for (int node : adjacencyList.keySet()) {
            // Mencetak simpul dan hasilnya
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            // Pindah ke baris baru setelah mencetak hasil dari suatu simpul
            System.out.println();
        }
    }

    // Metode utama untuk pengujian
    public static void main(String[] args) {
        // Membuat objek graf
        SimpleGraph graph = new SimpleGraph();

        // Menambahkan simpul-simpul
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        // Menambahkan sisi-sisi antar simpul
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        // Mencetak graf
        graph.printGraph();
    }
}
