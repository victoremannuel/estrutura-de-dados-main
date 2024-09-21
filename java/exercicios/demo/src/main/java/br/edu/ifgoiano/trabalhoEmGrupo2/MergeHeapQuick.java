package br.edu.ifgoiano.trabalhoEmGrupo2;

import java.util.Arrays;
import java.util.Random;

public class MergeHeapQuick {
    private static class Metrics {
        long swaps = 0;
        long comparisons = 0;
        long executionTime = 0;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Random random = new Random();

        for (int size : sizes) {
            // Arrays já ordenados
            int[] sortedArray = createSortedArray(size);
            int[] reverseArray = createReverseArray(size);
            int[] randomArray = createRandomArray(size, random);

            System.out.println("# Merge Sort");
            runSortsAndPrint("Ordenado", size, sortedArray, MergeHeapQuick::mergeSort);
            runSortsAndPrint("Reverso", size, reverseArray, MergeHeapQuick::mergeSort);
            runSortsAndPrint("Aleatorio", size, randomArray, MergeHeapQuick::mergeSort);

            System.out.println("# Heap Sort");
            runSortsAndPrint("Ordenado", size, sortedArray, MergeHeapQuick::heapSort);
            runSortsAndPrint("Reverso", size, reverseArray, MergeHeapQuick::heapSort);
            runSortsAndPrint("Aleatorio", size, randomArray, MergeHeapQuick::heapSort);

            System.out.println("# Quick Sort");
            runSortsAndPrint("Ordenado", size, sortedArray, MergeHeapQuick::quickSort);
            runSortsAndPrint("Reverso", size, reverseArray, MergeHeapQuick::quickSort);
            runSortsAndPrint("Aleatorio", size, randomArray, MergeHeapQuick::quickSort);
        }
    }

    private static void runSortsAndPrint(String type, int size, int[] array, SortingFunction sortFunction) {
        Metrics metrics = new Metrics();
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        sortFunction.sort(arrayCopy, metrics);
        long endTime = System.nanoTime();
        metrics.executionTime = endTime - startTime;
        System.out.printf("%s;%d;%d;%d;%d\n", type, size, metrics.swaps, metrics.comparisons, metrics.executionTime);
    }

    @FunctionalInterface
    private interface SortingFunction {
        void sort(int[] array, Metrics metrics);
    }

    // Merge Sort
    private static void mergeSort(int[] array, Metrics metrics) {
        mergeSortHelper(array, new int[array.length], 0, array.length - 1, metrics);
    }

    private static void mergeSortHelper(int[] array, int[] temp, int leftStart, int rightEnd, Metrics metrics) {
        if (leftStart >= rightEnd) return;
        int middle = (leftStart + rightEnd) / 2;
        mergeSortHelper(array, temp, leftStart, middle, metrics);
        mergeSortHelper(array, temp, middle + 1, rightEnd, metrics);
        mergeHalves(array, temp, leftStart, rightEnd, metrics);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd, Metrics metrics) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            metrics.comparisons++;
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    // Heap Sort
    private static void heapSort(int[] array, Metrics metrics) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i, metrics);

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i, metrics);
            heapify(array, i, 0, metrics);
        }
    }

    private static void heapify(int[] array, int n, int i, Metrics metrics) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest, metrics);
            heapify(array, n, largest, metrics);
        }
        metrics.comparisons += 2; // duas comparações para os filhos
    }

    // Quick Sort
    private static void quickSort(int[] array, Metrics metrics) {
        quickSortHelper(array, 0, array.length - 1, metrics);
    }

    private static void quickSortHelper(int[] array, int low, int high, Metrics metrics) {
        if (low < high) {
            int pi = partition(array, low, high, metrics);
            quickSortHelper(array, low, pi - 1, metrics);
            quickSortHelper(array, pi + 1, high, metrics);
        }
    }

    private static int partition(int[] array, int low, int high, Metrics metrics) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            metrics.comparisons++;
            if (array[j] < pivot) {
                i++;
                swap(array, i, j, metrics);
            }
        }
        swap(array, i + 1, high, metrics);
        return (i + 1);
    }

    // Utility methods
    private static void swap(int[] array, int i, int j, Metrics metrics) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        metrics.swaps++;
    }

    private static int[] createSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] createReverseArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    private static int[] createRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}
