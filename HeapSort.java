public class HeapSort {
    public static void heapSort(int[] arr, boolean ascending) {
        int n = arr.length;

        // Membangun heap sort maksimum atau minimum
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, ascending);

        // Menyortir array dengan mempertahankan properti heap
        for (int i = n - 1; i > 0; i--) {
            // Menukar elemen teratas (terbesar atau terkecil) dengan elemen terakhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Memanggil heapify pada subarray yang belum terurut
            heapify(arr, i, 0, ascending);
        }
    }

    public static void heapify(int[] arr, int n, int i, boolean ascending) {
        int root = i; // Inisialisasi root
        int leftChild = 2 * i + 1; // Indeks anak kiri dalam array
        int rightChild = 2 * i + 2; // Indeks anak kanan dalam array

        // Mengecek apakah harus mencari elemen terbesar atau terkecil
        if (ascending) {
            // Jika anak kiri lebih besar dari root
            if (leftChild < n && arr[leftChild] > arr[root])
                root = leftChild;

            // Jika anak kanan lebih besar dari root
            if (rightChild < n && arr[rightChild] > arr[root])
                root = rightChild;
        } else {
            // Jika anak kiri lebih kecil dari root
            if (leftChild < n && arr[leftChild] < arr[root])
                root = leftChild;

            // Jika anak kanan lebih kecil dari root
            if (rightChild < n && arr[rightChild] < arr[root])
                root = rightChild;
        }

        // Jika root bukan lagi root awal
        if (root != i) {
            // Menukar elemen root dengan elemen terbesar atau terkecil
            int swap = arr[i];
            arr[i] = arr[root];
            arr[root] = swap;

            // Melakukan rekursi pada subarray yang terpengaruh
            heapify(arr, n, root, ascending);
        }
    }

    public static void main(String[] args) {
        int[] arr = {90, 80, 60, 40, 70, 30, 10, 20, 50};

        // Mengurutkan secara menaik/Ascending
        heapSort(arr, true);
        System.out.println("Hasil Dari Ascending:");
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();

        // Mengurutkan secara Menurun/Discending
        heapSort(arr, false);
        System.out.println("Hasil Dari Discending:");
        for (int i : arr)
            System.out.print(i + " ");
    }
}