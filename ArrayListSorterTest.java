package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Testing class for ArrayListSorter
 * 
 * @author Alex Dean and Archer Fox
 * @version 2/21/2024
 */
public class ArrayListSorterTest {
    ArrayList<Integer> intList = new ArrayList<>();
    ArrayList<Integer> intListSorted = new ArrayList<>();
    ArrayList<Integer> intListOne = new ArrayList<>();
    ArrayList<Integer> emptyList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();
    ArrayList<String> stringListSorted = new ArrayList<>();
    ArrayList<Integer> listBelowThreshold = new ArrayList<>();
    ArrayList<Integer> listBelowThresholdSorted = new ArrayList<>();

    @BeforeEach
    void setup() {
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 4, 3, 2, 1, 5, 3, 7, 3, 9 };
        intList.addAll(Arrays.asList(intArr));

        intListSorted = new ArrayList<>();
        Integer[] sortedArr = new Integer[] { 1, 2, 3, 3, 3, 4, 5, 7, 9 };
        intListSorted.addAll(Arrays.asList(sortedArr));

        intListOne.add(6);

        listBelowThreshold = new ArrayList<>();
        Integer[] newArr = new Integer[] { 1, 4, 3, 2 };
        listBelowThreshold.addAll(Arrays.asList(newArr));

        listBelowThresholdSorted = new ArrayList<>();
        Integer[] sortedSmall = new Integer[] { 1, 2, 3, 4 };
        listBelowThresholdSorted.addAll(Arrays.asList(sortedSmall));

        stringList = new ArrayList<>();
        String[] stringArr = new String[] { "hi", "bonjour", "hola", "ciao", "privyet", "guten tag" };
        stringList.addAll(Arrays.asList(stringArr));

        stringListSorted = new ArrayList<>();
        String[] sortedStringArr = new String[] { "bonjour", "ciao", "guten tag", "hi", "hola", "privyet" };
        stringListSorted.addAll(Arrays.asList(sortedStringArr));
    }

    @Test
    public void testMedianPivot() {
        assertEquals(4, ArrayListSorter.medianPivot(intList, 0, intList.size() - 1));
    }

    @Test
    public void testMiddlePivot() {
        assertEquals(4, ArrayListSorter.middlePivot(intList, 0, intList.size() - 1));
    }

    @Test
    public void testRandomPivot() {
        int piv = ArrayListSorter.randomPivot(intList, 0, intList.size() - 1);
        assertTrue(piv >= 0 && piv <= intList.size() - 1);
    }

    @Test
    public void testQuickSort() {
        ArrayListSorter.quicksortRecursive(intList, 0, intList.size() - 1);
        assertEquals(intListSorted, intList);
    }

    @Test
    public void testMergeSort() {
        ArrayListSorter.mergesortRecursive(intList, new ArrayList<Integer>(Collections.nCopies(intList.size(), null)),
                0, intList.size() - 1);
        assertEquals(intListSorted, intList);
    }

    @Test
    public void testMergeSortOneItem() {
        ArrayListSorter.mergesortRecursive(intListOne,
                new ArrayList<Integer>(Collections.nCopies(intListOne.size(), null)), 0, intListOne.size() - 1);
    }

    @Test
    public void testQuickSortOneItem() {
        ArrayListSorter.quicksortRecursive(intListOne, 0, intListOne.size() - 1);
    }

    @Test
    public void testMergeSortTwoItems() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(9);
        test.add(2);
        ArrayListSorter.mergesortRecursive(test, new ArrayList<Integer>(Collections.nCopies(test.size(), null)), 0,
                test.size() - 1);
        assertEquals(2, test.get(0));
        assertEquals(9, test.get(1));
    }

    @Test
    public void testQuickSortTwoItems() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(9);
        test.add(2);
        ArrayListSorter.quicksortRecursive(test, 0, test.size() - 1);
        assertEquals(2, test.get(0));
        assertEquals(9, test.get(1));
    }

    @Test
    public void testQuickSortEmpty() {
        ArrayListSorter.quicksortRecursive(emptyList, 0, emptyList.size() - 1);
        assertEquals(new ArrayList<Integer>(), emptyList);
    }

    @Test
    public void testMergeSortEmpty() {
        ArrayListSorter.mergesortRecursive(emptyList,
                new ArrayList<Integer>(Collections.nCopies(emptyList.size(), null)), 0, emptyList.size() - 1);
        assertEquals(new ArrayList<Integer>(), emptyList);
    }

    @Test
    public void testQuickSortString() {
        ArrayListSorter.quicksortRecursive(stringList, 0, stringList.size() - 1);
        assertEquals(stringListSorted, stringList);
    }

    @Test
    public void testMergeSortString() {
        ArrayListSorter.mergesortRecursive(stringList,
                new ArrayList<String>(Collections.nCopies(stringList.size(), null)), 0, stringList.size() - 1);
        assertEquals(stringListSorted, stringList);
    }

    @Test
    public void testGenerateAscending() {
        ArrayList<Integer> list = ArrayListSorter.generateAscending(5);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5 };
        intList.addAll(Arrays.asList(intArr));
        assertEquals(intList, list);
    }

    @Test
    public void testGenerateAscendingEmpty() {
        ArrayList<Integer> list = ArrayListSorter.generateAscending(0);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] {};
        intList.addAll(Arrays.asList(intArr));
        assertEquals(intList, list);
    }

    @Test
    public void testGenerateDescendingEmpty() {
        ArrayList<Integer> list = ArrayListSorter.generateDescending(0);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] {};
        intList.addAll(Arrays.asList(intArr));
        assertEquals(intList, list);
    }

    @Test
    public void testGenerateDescending() {
        ArrayList<Integer> list = ArrayListSorter.generateDescending(5);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 5, 4, 3, 2, 1 };
        intList.addAll(Arrays.asList(intArr));
        assertEquals(intList, list);
    }

    @Test
    public void testSortBelowThreshold() {
        ArrayList<Integer> list = ArrayListSorter.generateDescending(5);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 5, 4, 3, 2, 1 };
        intList.addAll(Arrays.asList(intArr));
        assertEquals(intList, list);
    }

    @Test
    public void testMergeBelowThreshold() {
        ArrayListSorter.mergesort(listBelowThreshold);
        assertEquals(listBelowThresholdSorted, listBelowThreshold);
    }

    @Test
    public void testQuickSortPermuted() {
        ArrayList<Integer> list = ArrayListSorter.generatePermuted(5);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5 };
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.quicksort(list);
        assertEquals(intList, list);
    }

    @Test
    public void testMergeSortPermuted() {
        ArrayList<Integer> list = ArrayListSorter.generatePermuted(5);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5 };
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.mergesort(list);
        assertEquals(intList, list);
    }

    @Test
    public void testQuickSortPermutedLarge() {
        ArrayList<Integer> list = ArrayListSorter.generatePermuted(15);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.quicksort(list);
        assertEquals(intList, list);
    }

    @Test
    public void testMergeSortPermutedLarge() {
        ArrayList<Integer> list = ArrayListSorter.generatePermuted(15);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.mergesort(list);
        assertEquals(intList, list);
    }

    @Test
    public void testOneItemArrayPermuted() {
        ArrayList<Integer> list = ArrayListSorter.generatePermuted(1);
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 1 };
        intList.addAll(Arrays.asList(intArr));
        assertEquals(intList, list);
    }

    @Test
    public void testManyButOneSameItemQuick() {
        ArrayList<Integer> list = new ArrayList<>();
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 3, 7, 7, 7 };
        Integer[] sortedIntArr = new Integer[] { 3, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
        list.addAll(Arrays.asList(intArr));
        intList.addAll(Arrays.asList(sortedIntArr));
        ArrayListSorter.quicksortRecursive(list, 0, list.size() - 1);
        assertEquals(intList, list);
    }

    @Test
    public void testManyButOneSameItemMerge() {
        ArrayList<Integer> list = new ArrayList<>();
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 3, 7, 7, 7 };
        Integer[] sortedIntArr = new Integer[] { 3, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
        list.addAll(Arrays.asList(intArr));
        intList.addAll(Arrays.asList(sortedIntArr));
        ArrayListSorter.mergesortRecursive(list, new ArrayList<Integer>(Collections.nCopies(list.size(), null)), 0,
                list.size() - 1);
        assertEquals(intList, list);
    }

    @Test
    public void testManySameStrings() {
        ArrayList<String> list = new ArrayList<>();
        stringList = new ArrayList<>();
        String[] intArr = new String[] { "hi", "hi", "hi", "hi", "bye", "hi" };
        String[] sortedIntArr = new String[] { "bye", "hi", "hi", "hi", "hi", "hi" };
        list.addAll(Arrays.asList(intArr));
        stringList.addAll(Arrays.asList(sortedIntArr));
        ArrayListSorter.mergesortRecursive(list, new ArrayList<String>(Collections.nCopies(list.size(), null)), 0, list.size() - 1);
        assertEquals(stringList, list);
    }

}
