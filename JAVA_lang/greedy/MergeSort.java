package greedy;

public class MergeSort {

    // 合并排序算法
    public static void mergeSort(float[] arr) {
        if (arr.length < 2) {
            return; // 数组长度小于2时无需排序
        }
        int mid = arr.length / 2;
        float[] left = new float[mid];
        float[] right = new float[arr.length - mid];

        // 将数组分成左右两部分
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // 递归排序左右两部分
        mergeSort(left);
        mergeSort(right);

        // 合并排序后的部分
        merge(arr, left, right);
    }

    // 合并两个已排序的子数组
    private static void merge(float[] arr, float[] left, float[] right) {
        int i = 0, j = 0, k = 0;

        // 合并两个数组，按升序排序
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // 处理剩余的元素
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // 测试 mergeSort 方法
    public static void main(String[] args) {
        float[] arr = {30, 10, 60, 40, 50, 20};
        System.out.println("排序前：");
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(arr);

        System.out.println("排序后：");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
