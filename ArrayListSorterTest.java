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
    ArrayList<Integer> listBelowThreshold = new ArrayList<>();
    ArrayList<Integer> listBelowThresholdSorted = new ArrayList<>();
    @BeforeEach
    void setup() {
        intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{4,3,2,1,5,3,7,3,9};
        intList.addAll(Arrays.asList(intArr));

        intListSorted = new ArrayList<>();
        Integer[] sortedArr = new Integer[]{1,2,3,3,3,4,5,7,9};
        intListSorted.addAll(Arrays.asList(sortedArr));

        intListOne.add(6);
        
        
        listBelowThreshold = new ArrayList<>();
        Integer[] newArr = new Integer[]{1,4,3,2};
        listBelowThreshold.addAll(Arrays.asList(newArr));
        
        listBelowThresholdSorted = new ArrayList<>();
        Integer[] sortedSmall = new Integer[]{1,2,3,4};
        listBelowThresholdSorted.addAll(Arrays.asList(sortedSmall));

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
    
    @Test
    public void testGenerateAscending() { 
    	ArrayList<Integer> list = ArrayListSorter.generateAscending(5);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{1,2,3,4,5};
        intList.addAll(Arrays.asList(intArr));
    	assertEquals(intList, list);
    }
    
    @Test
    public void testGenerateAscendingEmpty() { 
    	ArrayList<Integer> list = ArrayListSorter.generateAscending(0);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{};
        intList.addAll(Arrays.asList(intArr));
    	assertEquals(intList, list);
    }
    
    @Test
    public void testGenerateDescendingEmpty() { 
    	ArrayList<Integer> list = ArrayListSorter.generateDescending(0);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{};
        intList.addAll(Arrays.asList(intArr));
    	assertEquals(intList, list);
    }
    
    
    @Test
    public void testGenerateDescending() { 
    	ArrayList<Integer> list = ArrayListSorter.generateDescending(5);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{5,4,3,2,1};
        intList.addAll(Arrays.asList(intArr));
    	assertEquals(intList, list);
    }
    
    @Test
    public void testSortBelowThreshold() { 
    	ArrayList<Integer> list = ArrayListSorter.generateDescending(5);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{5,4,3,2,1};
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
        Integer[] intArr = new Integer[]{1,2,3,4,5};
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.quicksort(list);
    	assertEquals(intList, list);
    }
    
    @Test 
    public void testMergeSortPermuted() {
    	ArrayList<Integer> list = ArrayListSorter.generatePermuted(5);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{1,2,3,4,5};
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.mergesort(list);
    	assertEquals(intList, list);
    }
    
    @Test 
    public void testQuickSortPermutedLarge() {
    	ArrayList<Integer> list = ArrayListSorter.generatePermuted(15);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.quicksort(list);
    	assertEquals(intList, list);
    }
    
    @Test 
    public void testMergeSortPermutedLarge() {
    	ArrayList<Integer> list = ArrayListSorter.generatePermuted(15);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.mergesort(list);
    	assertEquals(intList, list);
    }
    
    @Test
    public void testOneItemArrayQuick() {
    	ArrayList<Integer> list = ArrayListSorter.generatePermuted(1);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{1};
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.quicksort(list);
    	assertEquals(intList, list);
    }
    @Test
    public void testOneItemArrayMerge() {
    	ArrayList<Integer> list = ArrayListSorter.generatePermuted(1);
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{1};
        intList.addAll(Arrays.asList(intArr));
        ArrayListSorter.mergesort(list);
    	assertEquals(intList, list);
    }
    
    @Test
    public void testManyButOneSameItemQuick() {
    	ArrayList<Integer> list = new ArrayList<>();
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{7,7,7,7,7,7,7,7,7,7,7,7,3,7,7,7};
        Integer[] sortedIntArr = new Integer[]{3,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7};
   	 	list.addAll(Arrays.asList(intArr));
        intList.addAll(Arrays.asList(sortedIntArr));
        ArrayListSorter.quicksort(list);
    	assertEquals(intList, list);
    }
    
    @Test
    public void testManyButOneSameItemMerge() {
    	ArrayList<Integer> list = new ArrayList<>();
    	intList = new ArrayList<>();
        Integer[] intArr = new Integer[]{7,7,7,7,7,7,7,7,7,7,7,7,3,7,7,7};
        Integer[] sortedIntArr = new Integer[]{3,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7};
   	 	list.addAll(Arrays.asList(intArr));
        intList.addAll(Arrays.asList(sortedIntArr));
        ArrayListSorter.mergesort(list);
    	assertEquals(intList, list);
    }
    
    @Test
    public void testManySameStrings() {
    	ArrayList<String> list = new ArrayList<>();
    	stringList = new ArrayList<>();
        String[] intArr = new String[]{"hi", "hi" , "hi", "hi" , "bye" , "hi"};
        String[] sortedIntArr = new String[]{"bye", "hi", "hi" , "hi", "hi"  , "hi"};
   	 	list.addAll(Arrays.asList(intArr));
   	 	stringList.addAll(Arrays.asList(sortedIntArr));
        ArrayListSorter.mergesort(list);
    	assertEquals(stringList, list);
    }
    
    
}
