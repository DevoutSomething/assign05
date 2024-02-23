package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Class containing static methods for quick, merge, and insertion sort
 * 
 * @author Alex Dean and Archer Fox
 * @version 2/20/2024
 */
public class ArrayListSorter {
    private static final int THRESHOLD = 0;

    /**
     * Driver method for mergesort
     * 
     * @param arr
     */
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
        // creates a list to be used for merging so that the list won't be
        // re-initialized every time
        ArrayList<T> preallocatedList = new ArrayList<>(Collections.nCopies(arr.size(), null));
        mergesortRecursive(arr, preallocatedList, 0, arr.size() - 1);
    }

    /**
     * Recursive method for mergesort, splits array into subarrays of size one and
     * then begins merging them
     * 
     * @param arr
     * @param preallocatedList list to hold temporary values
     * @param low
     * @param high
     */
    private static <T extends Comparable<? super T>> void mergesortRecursive(ArrayList<T> arr,
            ArrayList<T> preallocatedList, int left, int right) {
        if (left >= right)
            return;
        if (right - left <= THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = left + ((right - left) / 2);
        mergesortRecursive(arr, preallocatedList, left, mid);
        mergesortRecursive(arr, preallocatedList, mid + 1, right);

        merge(arr, preallocatedList, left, mid, right);
    }

    /**
     * Merges two sublists in sorted order
     * 
     * @param arr
     * @param preallocatedList list to hold temporary values
     * @param left
     * @param mid
     * @param right
     */
    private static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> preallocatedList,
            int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= right) {
            if (arr.get(i).compareTo(arr.get(j)) < 0)
                preallocatedList.set(tempIndex, arr.get(i++));
            else
                preallocatedList.set(tempIndex, arr.get(j++));
            tempIndex++;
        }

        while (i <= mid)
            preallocatedList.set(tempIndex++, arr.get(i++));
        while (j <= right)
            preallocatedList.set(tempIndex++, arr.get(j++));

        for (i = left; i <= right; i++)
            arr.set(i, preallocatedList.get(i - left));
    }

    /**
     * Driver method for quicksort
     * 
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
        quicksortRecursive(arr, 0, arr.size() - 1);
    }

    /**
     * Recursive method for quicksort, partitions around a pivot and then sorts the
     * arrays to both sides using quicksort recursively
     * 
     * @param arr
     * @param left
     * @param right
     */
    private static <T extends Comparable<? super T>> void quicksortRecursive(ArrayList<T> arr, int left, int right) {
        if (left >= right)
            return;

        int pivotIndex = medianOfThreePivot(arr, left, right);
        int partitionIndex = partition(arr, left, right, pivotIndex);

        quicksortRecursive(arr, left, partitionIndex - 1);
        quicksortRecursive(arr, partitionIndex + 1, right);
    }

    /**
     * Swaps elements in the list so that elements less than the pivot will be to
     * the left and those greater will be on the right
     *
     * @param arr
     * @param left
     * @param right
     * @param pivotIndex
     * @return index where the pivot ended up, so that subarrays to left and right
     *         can be sorted
     */
    private static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int left, int right,
            int pivotIndex) {

        T pivot = arr.get(pivotIndex);
        int pointer1 = left;
        swap(arr, pivotIndex, right);

        for (int pointer2 = left; pointer2 < right; pointer2++) {
            if (arr.get(pointer2).compareTo(pivot) < 0) {
                swap(arr, pointer1++, pointer2);
            }
        }

        swap(arr, pointer1, right);
        return pointer1;
    }

    /**
     * Finds the median of the left, right, and middle elements of a list
     *
     * @param arr
     * @param left
     * @param right
     * @return index of median
     */
    private static <T extends Comparable<? super T>> int medianOfThreePivot(ArrayList<T> arr, int left, int right) {
        T leftItem = arr.get(left);
        T middleItem = arr.get(left + (right - left) / 2);
        T rightItem = arr.get(right);

        if (leftItem.compareTo(middleItem) * rightItem.compareTo(leftItem) >= 0) {
            return left;
        } else if (middleItem.compareTo(leftItem) * rightItem.compareTo(middleItem) >= 0) {
            return left + (right - left) / 2;
        } else {
            return right;
        }
    }

    /**
     * Returns a random index between left and right, inclusive
     * 
     * @param arr
     * @param left
     * @param right
     * @return random index
     */
    private static <T extends Comparable<? super T>> int randomPivot(ArrayList<T> arr, int left, int right) {
        Random rng = new Random();
        return rng.nextInt(left, right + 1);
    }

    /**
     * Returns the index in the middle of left and right
     * 
     * @param arr
     * @param left
     * @param right
     * @return middle index
     */
    private static <T extends Comparable<? super T>> int middlePivot(ArrayList<T> arr, int left, int right) {
        return left + ((right - left) / 2);
    }

    /**
     * Helper method for swapping two elements in a list
     * 
     * @param arr
     * @param i
     * @param j
     */
    private static <T> void swap(ArrayList<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * Insertion sort method for use when a list is below a certain size threshold
     * 
     * @param arr
     * @param left
     * @param right
     */
    private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> arr, int left, int right) {
        T temp;
        int j;
        for (int i = left + 1; i <= right; i++) {
            temp = arr.get(i);
            j = i - 1;
            while (j >= left && arr.get(j).compareTo(temp) > 0) {
                arr.set(j + 1, arr.get(j));
                arr.set(j--, temp);
            }
        }
    }

    /**
     * Generates and returns an ArrayList of integers 1 to size in ascending order
     * 
     * @param size
     * @return ascending list
     */
    public static ArrayList<Integer> generateAscending(int size) {
        ArrayList<Integer> ascendedTemp = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            ascendedTemp.add(i);
        }
        return ascendedTemp;
    }

    /**
     * Generates and returns an ArrayList of integers 1 to size in permuted order
     * 
     * @param size
     * @return randomized list
     */
    public static ArrayList<Integer> generatePermuted(int size) {
        ArrayList<Integer> arrayListRandom = generateAscending(size);
        Collections.shuffle(arrayListRandom);
        return arrayListRandom;
    }

    /**
     * Generates and returns an ArrayList of integers 1 to size in descending order
     * 
     * @param size
     * @return descending list
     */
    public static ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> decendedTemp = new ArrayList<>();
        for (int i = size; i > 0; i--) {
            decendedTemp.add(i);
        }
        return decendedTemp;
    }
}
