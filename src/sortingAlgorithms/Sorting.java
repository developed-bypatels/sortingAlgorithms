/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgorithms;
import java.util.Arrays;
/**
 *
 * @author I am Prerak Patel and my student number is 000736376 and I haven't shared my program
 */
/* Comp10205 - Sorting Examples
 Sort code from courseWare textbook - Copyright, All rights reserved.

 Additional code added by C. Mark Yendt in May 2014
 */

/**
 * All methods are static to the class - functional style
 *
 * @author mark.yendt
 */
public class Sorting {

    static final boolean SHOW_SOLUTION = true;
    private int quickSortCompares =0;   // Left in for comparison purposes only
    private int mergeSortCompares =0;   // Left in for comparison purposes only

    /**
     * The swap method swaps the contents of two elements in an int array.
     *
     * @param The array containing the two elements.
     * @param a The subscript of the first element.
     * @param b The subscript of the second element.
     */
    private void swap(int[] array, int a, int b) {
        int temp;

        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Bubble Sort function - Note use of swap in this case
     *
     * @param array an unsorted array that will be sorted upon method completion
     */
    public int bubbleSort(int[] array) {
        int lastPos;     // Position of last element to compare
        int index;       // Index of an element to compare
        int bubbleSortCounter = 0;
        // The outer loop positions lastPos at the last element
        // to compare during each pass through the array. Initially
        // lastPos is the index of the last element in the array.
        // During each iteration, it is decreased by one.
        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) {
            
            // The inner loop steps through the array, comparing
            // each element with its neighbor. All of the elements
            // from index 0 thrugh lastPos are involved in the
            // comparison. If two elements are out of order, they
            // are swapped.
            for (index = 0; index <= lastPos - 1; index++) {
                // Compare an element with its neighbor.
                bubbleSortCounter++;
                if (array[index] > array[index + 1]) {
                    // Swap the two elements.

                    swap(array, index, index + 1);
                }
            }
        }
        return bubbleSortCounter;
    }

    /**
     * Insertion Sort - An implementation of the Insertion Sort algorithm
     *
     * @param array an unsorted array that will be sorted upon method completion
     */
    public int insertionSort(int[] array) {
        int unsortedValue;  // The first unsorted value
        int scan;           // Used to scan the array
        int insertionSortCounter = 0;

        // The outer loop steps the index variable through 
        // each subscript in the array, starting at 1. The portion of
        // the array containing element 0  by itself is already sorted.
        for (int index = 1; index < array.length; index++) {
            // The first element outside the sorted portion is
            // array[index]. Store the value of this element
            // in unsortedValue.
            unsortedValue = array[index];

            // Start scan at the subscript of the first element
            // outside the sorted part.
            scan = index;

            // Move the first element in the still unsorted part
            // into its proper position within the sorted part.
            while (scan > 0 && array[scan - 1] > unsortedValue) {
                insertionSortCounter++;
                array[scan] = array[scan - 1];
                scan--;
            }

            // Insert the unsorted value in its proper position
            // within the sorted subset.
            array[scan] = unsortedValue;
        }
        return insertionSortCounter;
    }

    /**
     * An implementation of the selection Sort
     *
     * @param array an unsorted array that will be sorted upon method completion
     * @return
     */

    public int selectionSort(int[] array) {
        int startScan;   // Starting position of the scan
        int index;       // To hold a subscript value
        int minIndex;    // Element with smallest value in the scan
        int minValue;    // The smallest value found in the scan
        int selectionSortCounter = 0;

        // The outer loop iterates once for each element in the
        // array. The startScan variable marks the position where
        // the scan should begin.
        for (startScan = 0; startScan < (array.length - 1); startScan++) {
            // Assume the first element in the scannable area
            // is the smallest value.
            minIndex = startScan;
            minValue = array[startScan];

            // Scan the array, starting at the 2nd element in
            // the scannable area. We are looking for the smallest
            // value in the scannable area. 
            for (index = startScan + 1; index < array.length; index++) {
                selectionSortCounter++;
                if (array[index] < minValue) {
                    minValue = array[index];
                    minIndex = index;
                }
            }

            // Swap the element with the smallest value 
            // with the first element in the scannable area.
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }
        return selectionSortCounter;
    }

    /**
     * The non-recursive Quick sort - manages first call
     *
     * @param array an unsorted array that will be sorted upon method completion
     * @return
     */
  public int quickSort(int array[]) {
        
        doQuickSort(array, 0, array.length - 1);
        return quickSortCompares;
    }

    /**
     * The doQuickSort method uses the QuickSort algorithm to sort an int array.
     *
     * @param array The array to sort.
     * @param start The starting subscript of the list to sort
     * @param end The ending subscript of the list to sort
     */
    private void doQuickSort(int array[], int start, int end) {
        int pivotPoint;

        if (start < end) {
            // Get the pivot point.
            pivotPoint = partition(array, start, end);
            // Note - only one +/=
            // Sort the first sub list.
            doQuickSort(array, start, pivotPoint - 1);

            // Sort the second sub list.
            doQuickSort(array, pivotPoint + 1, end);
        }
    }

    /**
     * The partition method selects a pivot value in an array and arranges the
     * array into two sub lists. All the values less than the pivot will be
     * stored in the left sub list and all the values greater than or equal to
     * the pivot will be stored in the right sub list.
     *
     * @param array The array to partition.
     * @param start The starting subscript of the area to partition.
     * @param end The ending subscript of the area to partition.
     * @return The subscript of the pivot value.
     */
    private int partition(int array[], int start, int end) {
        int pivotValue;    // To hold the pivot value
        int endOfLeftList; // Last element in the left sub list.
        int mid;           // To hold the mid-point subscript

        // see http://www.cs.cmu.edu/~fp/courses/15122-s11/lectures/08-qsort.pdf
        // for discussion of middle point - This improves the almost sorted cases
        // of using quicksort
        // Find the subscript of the middle element.
        // This will be our pivot value.
        mid = (start + end) / 2;

        // Swap the middle element with the first element.
        // This moves the pivot value to the start of 
        // the list.
        swap(array, start, mid);

        // Save the pivot value for comparisons.
        pivotValue = array[start];

        // For now, the end of the left sub list is
        // the first element.
        endOfLeftList = start;

        // Scan the entire list and move any values that
        // are less than the pivot value to the left
        // sub list.
        for (int scan = start + 1; scan <= end; scan++) {
            //qSortCompares++;
            quickSortCompares++;
            if (array[scan] < pivotValue) {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }

        // Move the pivot value to end of the
        // left sub list.
        swap(array, start, endOfLeftList);

        // Return the subscript of the pivot value.
        return endOfLeftList;
    }
    /**
     * completes a merge sort on an
 array
     * @param array the unsorted elements - will be sorted on completion
     */
    public int mergeSort(int array[]) {
        
        int length = array.length;
        doMergeSort(array, 0, length - 1);
        return mergeSortCompares;
    }
 
    /**
     * private recursive method that splits array until we start at array sizes of 1
     * @param array starting array
     * @param lowerIndex lower bound of array to sort
     * @param higherIndex upper bound of array to sort
     */
    
    private void doMergeSort(int[] array, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {

            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(array, lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(array, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(array, lowerIndex, middle, higherIndex);
        }
    }
 
    /**
     * Merges two smaller sorted arrays into one sorted array
     * @param array provided in two sorted parts (1,4,9,2,3,11)
     * @param lowerIndex the location of the first index
     * @param middle - the middle element
     * @param higherIndex - the upper bound of the sorted elements
     */
    private void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex) {
        
        // Create a temporary Array for Merge
        int[] mergeArray = new int[higherIndex-lowerIndex+1];
        // Move current Array into mergeArray
        for (int i = lowerIndex; i <= higherIndex; i++) {
            mergeArray[i-lowerIndex] = array[i];
        }
        // Merge Array is in two parts
        // Part A - from lowerIndex to middle
        // Part B - from middle + 1 to higherIndex
        int partAIndex = lowerIndex;
        int partBIndex = middle + 1;
        int mergeIndex = lowerIndex;
        while (partAIndex <= middle && partBIndex <= higherIndex) {
            // Place items back into Array in order
            // Select the lowestest of the two elements
            mergeSortCompares++;
          
            if (mergeArray[partAIndex-lowerIndex] <= mergeArray[partBIndex-lowerIndex]) {
                array[mergeIndex] = mergeArray[partAIndex-lowerIndex];
                partAIndex++;
            } else {
                array[mergeIndex] = mergeArray[partBIndex-lowerIndex];
                partBIndex++;
            }
            mergeIndex++;
        }
        // Copy the remainder of PartA array (if required)
        while (partAIndex <= middle) {
            array[mergeIndex] = mergeArray[partAIndex-lowerIndex];
            mergeIndex++;
            partAIndex++;
            mergeSortCompares++;
        }
    }
    
    /**
     * Print an array to the Console
     *
     * @param A array to be printed
     */
    public void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%5d ", A[i]);
        }
        System.out.println();
    }

}
