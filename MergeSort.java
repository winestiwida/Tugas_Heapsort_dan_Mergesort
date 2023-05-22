public class MergeSort {
    void merge(int arr[], int l, int m, int r, String sortOrder) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if ((sortOrder.equals("ascending") && L[i] <= R[j]) || (sortOrder.equals("descending") && L[i] >= R[j])) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r, String sortOrder) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m, sortOrder);
            sort(arr, m + 1, r, sortOrder);
            merge(arr, l, m, r, sortOrder);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 17, 15, 13, 12, 10, 11 };

        System.out.println("Ascending:");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1, "ascending");

        System.out.println("\nAscending Sorted:");
        printArray(arr);

        ob.sort(arr, 0, arr.length - 1, "descending");

        System.out.println("\nDescending Sorted:");
        printArray(arr);
    }
}