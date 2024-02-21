package assign05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Class containing static methods for quick, merge, and insertion sort
 * 
 * @author Alex Dean and Archer Fox
 * @version 2/20/2024
 */
public class ArrayListSorter {
    private static final int THRESHOLD = 5;

    /**
     * Driver method for mergesort, calls insertion sort if list size is below
     * threshold
     * 
     * @param arr
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
        if (arr.size() <= THRESHOLD) {
            insertionSort(arr);
        } else {
            // ArrayList<T> preallocatedList = new ArrayList<T>(Collections.nCopies(arr.size(), null));
            T[] nullArr = (T[]) (new Comparable[arr.size()]);
            ArrayList<T> preallocatedList = new ArrayList<>();
            preallocatedList.addAll(Arrays.asList(nullArr));
            mergesortRecursive(arr, preallocatedList, 0, arr.size() - 1);
        }
    }

    /**
     * Recursive method for mergesort, splits array into subarrays of size one and
     * then begins merging them
     * 
     * @param arr
     * @param low
     * @param high
     */
    public static <T extends Comparable<? super T>> void mergesortRecursive(ArrayList<T> arr,
            ArrayList<T> preallocatedList, int low, int high) {
        if (low >= high)
            return;

        int mid = low + ((high - low) / 2);
        mergesortRecursive(arr, preallocatedList, low, mid);
        mergesortRecursive(arr, preallocatedList, mid + 1, high);

        merge(arr, preallocatedList, low, mid, high);
    }

    /**
     * Merges arrays in sorted order
     * 
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> preallocatedList, int low,
            int mid, int high) {
        int i = low;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= high) {
            if (arr.get(i).compareTo(arr.get(j)) < 0)
                preallocatedList.set(tempIndex, arr.get(i++));
            else
                preallocatedList.set(tempIndex, arr.get(j++));
            tempIndex++;
        }

        while (i <= mid)
            preallocatedList.set(tempIndex++, arr.get(i++));
        while (j <= high)
            preallocatedList.set(tempIndex++, arr.get(j++));

        for (i = low; i <= high; i++)
            arr.set(i, preallocatedList.get(i - low));
    }

    /**
     * Driver method for quicksort, calls insertionsort if list size is below
     * threshold
     * 
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
        if (arr.size() <= THRESHOLD) {
            insertionSort(arr);
        } else {
            quicksortRecursive(arr, 0, arr.size() - 1);
        }
    }

    /**
     * Recursive method for quicksort, partitions around a pivot and then sorts the
     * arrays to both sides in the same way
     * 
     * @param arr
     * @param left
     * @param right
     */
    private static <T extends Comparable<? super T>> void quicksortRecursive(ArrayList<T> arr, int left, int right) {
        if (left >= right)
            return;

        int pivotIndex = medianPivot(arr, left, right);
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
        swap(arr, pivotIndex, right);
        int i = left;
        int j = right - 1;

        while (true) {
            while (i < right && arr.get(i).compareTo(pivot) < 0)
                i++;
            while (j >= 0 && arr.get(j).compareTo(pivot) > 0)
                j--;

            if (i >= j)
                break;

            swap(arr, i++, j--);
        }

        swap(arr, i, right);
        return i;
    }

    /**
     * Finds the median of the left, right, and middle elements of a list
     *
     * @param arr
     * @param left
     * @param right
     * @return median
     */
    public static <T extends Comparable<? super T>> int medianPivot(ArrayList<T> arr, int left, int right) {
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

    public static <T extends Comparable<? super T>> int randomPivot(ArrayList<T> arr, int left, int right) {
        Random rng = new Random();
        return rng.nextInt(left, right + 1);
    }

    public static <T extends Comparable<? super T>> int middlePivot(ArrayList<T> arr, int left, int right) {
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
     * @param <T>
     * @param list
     */
    private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list) {
        T temp;
        int j;
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i);
            j = i - 1;
            while (j >= 0 && list.get(j).compareTo(temp) > 0) {
                list.set(j + 1, list.get(j));
                list.set(j--, temp);
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
