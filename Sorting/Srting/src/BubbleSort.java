import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        // Inisialisasi variabel untuk jumlah bilangan, indeks, dan variabel pertukaran
        int jumlah, i, j, swap;

        // Membuat objek berupa Scanner untuk input dari pengguna
        Scanner scan = new Scanner(System.in);

        // Meminta kepada para pengguna untuk memasukkan jumlah bilangan yang akan diurutkannya
        System.out.print("Masukkan Jumlah Bilangan Yang Mau DiInputkan :");
        jumlah = scan.nextInt();

        // Membuat array untuk menyimpan bilangan yang akan dimasukkan oleh pengguna
        int[] array = new int[jumlah];

        // Meminta pengguna memasukkan bilangannya satu per satu
        System.out.println("\nMasukkan " + jumlah + " Buah Bilangan Integer");
        System.out.println("===========================================");
        for (i = 0; i < jumlah; i++) {
            System.out.print("Bilangan Ke- " + (i + 1) + " =");
            array[i] = scan.nextInt();
        }

        // Menampilkan bilangan sebelum bilangan diurutkan
        System.out.println("\nBilangan Belum Terurutnya");
        for (int a = 0; a < jumlah; a++) {
            System.out.print(array[a] + " ");
        }

        // Sebuah Algoritma Bubble Sort untuk mengurutkan dalam bilangan array
        for (i = 0; i < (jumlah - 1); i++) {
            for (j = 0; j < jumlah - i - 1; j++) {
                // Jika bilangan ini lebih besar dari bilangan berikutnya,maka tukar posisinya
                if (array[j] > array[j + 1]) {
                    swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }

        // Menampilkan bilangan yang telah diurutkan
        System.out.println("\n\nBilangan Terurutnya adalah :");
        for (i = 0; i < jumlah; i++)
            System.out.print(array[i] + " ");
    }
}
