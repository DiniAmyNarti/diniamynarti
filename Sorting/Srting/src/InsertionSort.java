public class InsertionSort {
    // Metode untuk melakukan insertion sort pada sebuah array
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            // Memindahkan elemen yang lebih besar dari key ke posisi setelahnya
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            // Tempatkan sebuah key ke posisi yang sesuai
            array[i + 1] = key;
        }
    }

    public static void main(String a[]) {
        int[] arr1 = {9, 14, 3, 2, 43, 11, 58, 22};

        // Menampilkan array sebelum diurutkan
        System.out.println("Before Insertion Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Untuk memanggil metode insertion sort
        insertionSort(arr1);

        // Menampilkan array yang telah diurutkan
        System.out.println("After Insertion Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
