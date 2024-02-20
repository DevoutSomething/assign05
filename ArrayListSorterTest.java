package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ArrayListSorterTest {
    ArrayList<Integer> intList = new ArrayList<>();
    ArrayList<Integer> intListSorted = new ArrayList<>();
    ArrayList<Integer> intListOne = new ArrayList<>();
    ArrayList<Integer> emptyList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();
    ArrayList<String> stringListSorted = new ArrayList<>();

    @BeforeEach
    void setup() {
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{4,3,2,1,5,3,7,3,9};
        intList.addAll(Arrays.asList(intArr));

        intListSorted = new ArrayList<>();
        Integer[] sortedArr = new Integer[]{1,2,3,3,3,4,5,7,9};
        intListSorted.addAll(Arrays.asList(sortedArr));

        intListOne.add(6);

        stringList = new ArrayList<>();
        String[] stringArr = new String[]{"hi", "bonjour", "hola", "ciao", "privyet", "guten tag"};
        stringList.addAll(Arrays.asList(stringArr));

        stringListSorted = new ArrayList<>();
        String[] sortedStringArr = new String[]{"bonjour", "ciao", "guten tag", "hi", "hola", "privyet"};
        stringListSorted.addAll(Arrays.asList(sortedStringArr));
    }

    @Test
    public void testPivotFinder() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{2,1,3}));
        assertEquals(0, ArrayListSorter.findPivot(list, 0, list.size() - 1));
    }

    @Test 
    public void testQuickSort(){
        ArrayListSorter.quicksort(intList);
        assertEquals(intListSorted, intList);
    }

    @Test
    public void testMergeSort() {
        ArrayListSorter.mergesort(intList);
        assertEquals(intListSorted, intList);
    }

    @Test
    public void testMergeSortOneItem() { 
        ArrayListSorter.mergesort(intListOne);
    }

    @Test
    public void testQuickSortOneItem() { 
        ArrayListSorter.quicksort(intListOne);
    }

    @Test
    public void testQuickSortEmpty() {
        ArrayListSorter.quicksort(emptyList);
        assertEquals(new ArrayList<Integer>(), emptyList);
    }

    @Test
    public void testMergeSortEmpty() {
        ArrayListSorter.mergesort(emptyList);
        assertEquals(new ArrayList<Integer>(), emptyList);
    }

    @Test
    public void testQuickSortString() {
        ArrayListSorter.quicksort(stringList);
        assertEquals(stringListSorted, stringList);
    }

    @Test
    public void testMergeSortString() {
        ArrayListSorter.mergesort(stringList);
        assertEquals(stringListSorted, stringList);
    }
}
