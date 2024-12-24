package sort;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivot = arr[(low + high) / 2];
        int i = low - 1, j = high + 1;
        while (i < j) {
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        quickSort(arr, low, j);
        quickSort(arr, j + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {30, 35, 15, 5, 10, 20, 25};
        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
