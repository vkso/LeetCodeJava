import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        // 选择中间元素作为基准（避免最坏情况）
        int pivot = arr[(low + high) / 2];
        int left = low, right = high;

        // 分区操作
        while (left <= right) {
            // 找到左侧大于等于基准的元素
            while (arr[left] < pivot) left++;
            // 找到右侧小于等于基准的元素
            while (arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        // 递归处理左右子数组
        sort(arr, low, right);
        sort(arr, left, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
