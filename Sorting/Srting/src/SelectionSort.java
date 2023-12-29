public class SelectionSort {
    private long[] data;    // Array untuk menyimpan data
    private int jumItem;    // Jumlah item sebuah  array

    // Konstruktor untuk inisialisasi array data
    public SelectionSort(int max) {
        data = new long[max];
        jumItem = 0;
    }

    // Metode untuk menambahkan nilai ke dalam sebuah array
    public void tambah(long nilai) {
        data[jumItem] = nilai;
        jumItem++;
    }

    // Metode untuk mencetak sebuah isi array
    public void cetak() {
        for (int j = 0; j < jumItem; j++)
            System.out.print(data[j] + " ");
        System.out.println(" ");
    }

    // Metode untuk melakukan selection sort pada sebuah aray array
    public void selection_sort() {
        int i, j, pos;
        for (i = 0; i < jumItem - 1; i++) {
            pos = i;

            for (j = i + 1; j < jumItem; j++) {
                if (data[j] < data[pos])
                    pos = j;
            }

            if (pos != i)
                tukar(pos, i);

            System.out.print("Hasil langkah ke " + (i + 1) + " :");
            cetak();
            System.out.println();
        }
    }

    // Sebuah metode untuk menukar dua elemen dalam array
    private void tukar(int a, int b) {
        long temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}

// Sebuah kelas untuk menguji dan mengeksekusi SelectionSort
class SortingSelectionSort {
    public static void main(String[] args) {
        int ukuran = 100;
        SelectionSort DeretAngka;
        DeretAngka = new SelectionSort(ukuran);

        // Menambahkan beberapa nilai ke dalam array
        DeretAngka.tambah(22);
        DeretAngka.tambah(2);
        DeretAngka.tambah(90);
        DeretAngka.tambah(25);
        DeretAngka.tambah(20);
        DeretAngka.tambah(30);
        DeretAngka.tambah(6);
        DeretAngka.tambah(3);

        // Menampilkan data awal
        System.out.print("Data awal : ");
        DeretAngka.cetak();
        System.out.println();

        // Melakukan selection sort
        DeretAngka.selection_sort();

        // Menampilkan sebuah data yang telah diurutkan
        System.out.print("Data akhir : ");
        DeretAngka.cetak();
        System.out.println();
    }
}