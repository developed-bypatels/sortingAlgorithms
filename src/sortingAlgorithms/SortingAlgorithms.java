/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // 
        
        // TODO code application logic here
        
        // o	List in order (fastest to slowest) your selection of algorithm to use when the sort contain 25 elements.  
        // -    As per my obervation on sorting 25 elements through different algorithms 
        //              - I will use Quick Sort , Insertion Sort , Merge Sort, Bubble Sort, Selection Sort
        //      With some reasons for preferring this sorting algorithms
        //              - it will take less compares to sort algortihms in that way
        //              - it will take way lesser time
        
        //o	List in order (fastest to slowest) your selection of algorithm to use when the sort contain 25000 elements.
        //-     As per my obeservation on sorting 25000 elements through different algorithms
        //              - I will use Merge Sort, Quick Sort, Bubble Sort, Insertion Sort, Selection Sort
        
        //o	List the algorithm and the BIG O notation for that algorithm. 
        //          - Quick Sort        = O(n log(n))
        //          - Merge Sort        = O(n log(n))
        //          - Bubble Sort       = O(n)
        //          - Insertion Sort    = O(n)
        //          - Selection Sort    = O(n^2)
        
        //o	Which algorithm has the best performance of the basic step?  Does this have any impact on your selection of fastest algorithm 
        //      when sorting 25000 elements.
        //          - Best Performance in sorting the most basic array was Quick Sort.
        //          - While selecting algorithm for sorting 25000 elements the algorithm with lesser comparison and less execution speed is 
        //              preferred where quick Sort laid behind by Merge Sort in both terms
     
        System.out.printf("Sorting Algorithm Performance Analysis\n");

        Sorting sorting = new Sorting();
        int[] firstRandomArray = new int[25];
        int[] secondRandomArray = new int[250];
        int[] thirdRandomArray = new int[25000];
      
        for(int i = 0 ; i<25 ;i++){
            firstRandomArray[i] = (int)(Math.random()*25);
        }
        for(int i=0;i<250;i++){
            secondRandomArray[i] = (int) (Math.random()*250);
        }
        for(int i=0;i<25000;i++){
            thirdRandomArray[i] = (int) (Math.random()*25000);
        }
              
        // Making clone for bubble sorting of Arrays
        int[] bubbleSortFirstArray = Arrays.copyOf(firstRandomArray, firstRandomArray.length);
        int[] bubbleSortSecondArray = Arrays.copyOf(secondRandomArray, secondRandomArray.length);
        int[] bubbleSortThirdArray = Arrays.copyOf(thirdRandomArray, thirdRandomArray.length);
        
        
        // Bubble Sorting and recording time for firstRandomArray
        long startBubbleSortFirstArray = System.nanoTime();
        int bubbleSortFirstCounter = sorting.bubbleSort(bubbleSortFirstArray);
        long endBubbleSortFirstArray = System.nanoTime();

        // Bubble Sorting and recording time for secondRandomArray
        long startBubbleSortSecondArray = System.nanoTime();
        int bubbleSortSecondCounter = sorting.bubbleSort(bubbleSortSecondArray);
        long endBubbleSortSecondArray = System.nanoTime();
        
        // Bubble Sorting and recording time for thirdRandomArray
        long startBubbleSortThirdArray = System.nanoTime();
        int bubbleSortThirdCounter = sorting.bubbleSort(bubbleSortThirdArray);
        long endBubbleSortThirdArray = System.nanoTime();

        
        // Making clone for insertion sorting of Arrays
        int[] insertionSortFirstArray = Arrays.copyOf(firstRandomArray, firstRandomArray.length);
        int[] insertionSortSecondArray = Arrays.copyOf(secondRandomArray, secondRandomArray.length);
        int[] insertionSortThirdArray = Arrays.copyOf(thirdRandomArray, thirdRandomArray.length);
        
        // Insertion sorting and recording time for firstRandomArray
        long startInsertionSortFirstArray = System.nanoTime();
        int insertionSortFirstCounter = sorting.insertionSort(insertionSortFirstArray);
        long endInsertionSortFirstArray = System.nanoTime();; 

        // Insertion Sorting and recording time for secondRandomArray
        long startInsertionSortSecondArray = System.nanoTime();
        int insertionSortSecondCounter = sorting.insertionSort(insertionSortSecondArray);
        long endInsertionSortSecondArray = System.nanoTime();
        
        // Insertion Sorting and recording time for thirdRandomArray
        long startInsertionSortThirdArray = System.nanoTime();
        int insertionSortThirdCounter = sorting.insertionSort(insertionSortThirdArray);
        long endInsertionSortThirdArray = System.nanoTime();
        
        // Making clone for selection sorting of Arrays
        int[] selectionSortFirstArray = Arrays.copyOf(firstRandomArray, firstRandomArray.length);
        int[] selectionSortSecondArray = Arrays.copyOf(secondRandomArray, secondRandomArray.length);
        int[] selectionSortThirdArray = Arrays.copyOf(thirdRandomArray, thirdRandomArray.length);
        
        // Selection sorting and recording time for firstRandomArray
        long startSelectionSortFirstArray = System.nanoTime();
        int selectionSortFirstCounter = sorting.selectionSort(selectionSortFirstArray);
        long endSelectionSortFirstArray = System.nanoTime();; 

        // Selection Sorting and recording time for secondRandomArray
        long startSelectionSortSecondArray = System.nanoTime();
        int selectionSortSecondCounter = sorting.selectionSort(selectionSortSecondArray);
        long endSelectionSortSecondArray = System.nanoTime();
        
        // Selection Sorting and recording time for thirdRandomArray
        long startSelectionSortThirdArray = System.nanoTime();
        int selectionSortThirdCounter = sorting.selectionSort(selectionSortThirdArray);
        long endSelectionSortThirdArray = System.nanoTime();
        
        
        // Making clone for quick sorting of Arrays
        int[] quickSortFirstArray = Arrays.copyOf(firstRandomArray, firstRandomArray.length);
        int[] quickSortSecondArray = Arrays.copyOf(secondRandomArray, secondRandomArray.length);
        int[] quickSortThirdArray = Arrays.copyOf(thirdRandomArray, thirdRandomArray.length);
        
        // Quick sorting and recording time for firstRandomArray
        long startQuickSortFirstArray = System.nanoTime();
        int quickSortFirstCounter = sorting.quickSort(quickSortFirstArray);
        long endQuickSortFirstArray = System.nanoTime();; 

        // Quick Sorting and recording time for secondRandomArray
        long startQuickSortSecondArray = System.nanoTime();
        int quickSortSecondCounter = sorting.quickSort(quickSortSecondArray);
        long endQuickSortSecondArray = System.nanoTime();
        
        // Quick Sorting and recording time for thirdRandomArray
        long startQuickSortThirdArray = System.nanoTime();
        int quickSortThirdCounter = sorting.quickSort(quickSortThirdArray);
        long endQuickSortThirdArray = System.nanoTime();
        
        // Making clone for merge sorting of Arrays
        int[] mergeSortFirstArray = Arrays.copyOf(firstRandomArray, firstRandomArray.length);
        int[] mergeSortSecondArray = Arrays.copyOf(secondRandomArray, secondRandomArray.length);
        int[] mergeSortThirdArray = Arrays.copyOf(thirdRandomArray, thirdRandomArray.length);
        
        // Merge sorting and recording time for fristRandomArray
        long startMergeSortFirstArray = System.nanoTime();
        int mergeSortFirstCounter = sorting.mergeSort(mergeSortFirstArray);
        long endMergeSortFirstArray = System.nanoTime();; 

        // Merge Sorting and recording time for secondRandomArray
        long startMergeSortSecondArray = System.nanoTime();
        int mergeSortSecondCounter = sorting.mergeSort(mergeSortSecondArray);
        long endMergeSortSecondArray = System.nanoTime();
        
        // Merge Sorting and recording time for thirdRandomArray
        long startMergeSortThirdArray = System.nanoTime();
        int mergeSortThirdCounter = sorting.mergeSort(mergeSortThirdArray);
        long endMergeSortThirdArray = System.nanoTime();
        
        System.out.println("\n\nComparison for array size of 25\n\n");
        System.out.printf("Number of compares for quick sort\t=%5d  time  = %6d ns Basic Step\t= %6.1f ns\n",quickSortFirstCounter,endQuickSortFirstArray - startQuickSortFirstArray,(double)(endQuickSortFirstArray - startQuickSortFirstArray)/quickSortFirstCounter);
        System.out.printf("Number of compares for merge sort\t=%5d  time  = %6d ns Basic Step\t= %6.1f ns\n",mergeSortFirstCounter,endMergeSortFirstArray - startMergeSortFirstArray,(double)(endMergeSortFirstArray - startMergeSortFirstArray)/mergeSortFirstCounter);
        System.out.printf("Number of compares for bubble sort\t=%5d  time  = %6d ns Basic Step\t= %6.1f ns\n",bubbleSortFirstCounter,endBubbleSortFirstArray - startBubbleSortFirstArray,(double)(endBubbleSortFirstArray - startBubbleSortFirstArray)/bubbleSortFirstCounter);
        System.out.printf("Number of compares for insertion sort\t=%5d  time  = %6d ns Basic Step\t= %6.1f ns\n",insertionSortFirstCounter,endInsertionSortFirstArray - startInsertionSortFirstArray,(double)(endInsertionSortFirstArray - startInsertionSortFirstArray)/insertionSortFirstCounter);
        System.out.printf("Number of compares for selection sort\t=%5d  time  = %6d ns Basic Step\t= %6.1f ns\n",selectionSortFirstCounter,endSelectionSortFirstArray - startSelectionSortFirstArray,(double)(endSelectionSortFirstArray - startSelectionSortFirstArray)/selectionSortFirstCounter);

        
        System.out.println("\n\nComparison for array size of 250\n\n");
        System.out.printf("Number of compares for quick sort\t=%6d  time  = %8d ns Basic Step\t= %6.1f ns\n",quickSortSecondCounter,endQuickSortSecondArray - startQuickSortSecondArray,(double)(endQuickSortSecondArray - startQuickSortSecondArray)/quickSortSecondCounter);
        System.out.printf("Number of compares for merge sort\t=%6d  time  = %8d ns Basic Step\t= %6.1f ns\n",mergeSortSecondCounter,endMergeSortSecondArray - startMergeSortSecondArray,(double)(endMergeSortSecondArray - startMergeSortSecondArray)/mergeSortSecondCounter);
        System.out.printf("Number of compares for bubble sort\t=%6d  time  = %8d ns Basic Step\t= %6.1f ns\n",bubbleSortSecondCounter,endBubbleSortSecondArray - startBubbleSortSecondArray,(double)(endBubbleSortSecondArray - startBubbleSortSecondArray)/bubbleSortSecondCounter);
        System.out.printf("Number of compares for insertion sort\t=%6d  time  = %8d ns Basic Step\t= %6.1f ns\n",insertionSortSecondCounter,endInsertionSortSecondArray - startInsertionSortSecondArray,(double)(endInsertionSortSecondArray - startInsertionSortSecondArray)/insertionSortSecondCounter);
        System.out.printf("Number of compares for selection sort\t=%6d  time  = %8d ns Basic Step\t= %6.1f ns\n",selectionSortSecondCounter,endSelectionSortSecondArray - startSelectionSortSecondArray,(double)(endSelectionSortSecondArray - startSelectionSortSecondArray)/selectionSortSecondCounter);

        System.out.println("\n\nComparison for array size of 25000\n\n");
        System.out.printf("Number of compares for quick sort\t=%10d  time  = %10d ns Basic Step\t= %6.1f ns\n",quickSortThirdCounter,endQuickSortThirdArray - startQuickSortThirdArray,(double)(endQuickSortThirdArray - startQuickSortThirdArray)/quickSortThirdCounter);
        System.out.printf("Number of compares for merge sort\t=%10d  time  = %10d ns Basic Step\t= %6.1f ns\n",mergeSortThirdCounter,endMergeSortThirdArray - startMergeSortThirdArray,(double)(endMergeSortThirdArray - startMergeSortThirdArray)/mergeSortThirdCounter);
        System.out.printf("Number of compares for bubble sort\t=%10d  time  = %10d ns Basic Step\t= %6.1f ns\n",bubbleSortThirdCounter,endBubbleSortThirdArray - startBubbleSortThirdArray,(double)(endBubbleSortThirdArray - startBubbleSortThirdArray)/bubbleSortThirdCounter);
        System.out.printf("Number of compares for insertion sort\t=%10d  time  = %10d ns Basic Step\t= %6.1f ns\n",insertionSortThirdCounter,endInsertionSortThirdArray - startInsertionSortThirdArray,(double)(endInsertionSortThirdArray - startInsertionSortThirdArray)/insertionSortThirdCounter);
        System.out.printf("Number of compares for selection sort\t=%10d  time  = %10d ns Basic Step\t= %6.1f ns\n",selectionSortThirdCounter,endSelectionSortThirdArray - startSelectionSortThirdArray,(double)(endSelectionSortThirdArray - startSelectionSortThirdArray)/selectionSortThirdCounter);

    }
    
}
