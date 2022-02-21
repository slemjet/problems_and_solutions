package sorting;

public class QuickSort {

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        // Partition elements around pivot
        int pivot = partition(array, left, right);
        // Do quicksort for left subarray
        quickSort(array, left, pivot - 1);
        // Do quicksort for left subarray
        quickSort(array, pivot + 1, right);
    }

    /**
     * Take last element as pivot
     * Put pivot in its correct position
     * Put all element < pivot to the left of the pivot and all > pivot to the right of pivot</>
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[right];

        // Initiate left element
        int l = left - 1;

        for (int r = left; r < right; r++) {

            if (array[r] < pivot) {
                // Need to swap current right element with the pivot
                l++;
                swap(array, l, r);
            }
        }

        // Put pivot at its position - after all elements < than pivot
        swap(array, l + 1, right);
        return l + 1;
    }

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivot = array[right];
        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && array[l] < pivot) l++;
            while (l < r && array[r] > pivot) r--;

            if (l < r) {
                // Swap element
                swap(array, l, r);
                l++;
            }
        }
        sort(array, left, l - 1);
        sort(array, l, right);
    }

    private void swap(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

}
