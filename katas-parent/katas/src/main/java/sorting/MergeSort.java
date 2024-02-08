package sorting;

public class MergeSort {

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;

        // Divide by middle
        int mid = left + (right - left) / 2;

        // Do mergesort for each half
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        // Merge halves
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {

        // Create 2 subarrays
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        // Populate 2 subarrays
        System.arraycopy(array, left, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);

        // Merge 2 subarrays taking the lesser value
        int leftIdx = 0;
        int rightIdx = 0;
        int idx = left;
        while (idx < array.length && leftIdx < leftArray.length && rightIdx < rightArray.length) {
            if (leftArray[leftIdx] < rightArray[rightIdx]) {
                array[idx++] = leftArray[leftIdx++];
            } else {
                array[idx++] = rightArray[rightIdx++];
            }
        }

        // Copy remaining values if only one array is left unprocessed
        if (leftIdx < leftArray.length) {
            System.arraycopy(leftArray, leftIdx, array, idx, leftArray.length - leftIdx);
        }
        if (rightIdx < rightArray.length) {
            System.arraycopy(rightArray, rightIdx, array, idx, rightArray.length - rightIdx);
        }
    }

}
