public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r) {

        // Base case
        if (l >= r) {
            return;
        }

        // Find middle
        int mid = l + (r - l) / 2;

        // Sort left half
        mergeSort(arr, l, mid);

        // Sort right half
        mergeSort(arr, mid + 1, r);

        // Merge both sorted halves
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        // Temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy left half
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        // Copy right half
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // Merge both arrays
        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining left elements
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining right elements
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 1, 9, 2};

        mergeSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}