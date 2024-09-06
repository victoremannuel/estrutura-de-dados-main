package br.com.junitsetup.trabalhoEmGrupo;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {
    public static void main(String[] args) {
        int[] V = {0, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

        for (int n : V) {
            if (n == 0) continue;
            int[] asc = generateAscendingArray(n);
            int[] desc = generateDescendingArray(n);
            int[] random = generateRandomArray(n);

            // Bolha
            System.out.println("Bubble Sort for N = " + n);
            runBubbleSortTests(n, asc, desc, random);
            
            // Bolha otimizada
            System.out.println("Optimized Bubble Sort for N = " + n);
            runOptimizedBubbleSortTests(n, asc, desc, random);
            
            // Inserção
            System.out.println("Insertion Sort for N = " + n);
            runInsertionSortTests(n, asc, desc, random);
            
            // Seleção
            System.out.println("Selection Sort for N = " + n);
            runSelectionSortTests(n, asc, desc, random);
        }
    }

    // Bolha
    public static void bubbleSort(int[] arr, Result result) {
        int n = arr.length;
        result.comparisons = 0;
        result.swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                result.comparisons++;
                if (arr[j] > arr[j + 1]) {
                    result.swaps++;
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Bolha Otimizada
    public static void optimizedBubbleSort(int[] arr, Result result) {
        int n = arr.length;
        result.comparisons = 0;
        result.swaps = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                result.comparisons++;
                if (arr[j] > arr[j + 1]) {
                    result.swaps++;
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Inserção
    public static void insertionSort(int[] arr, Result result) {
        int n = arr.length;
        result.comparisons = 0;
        result.swaps = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                result.comparisons++;
                arr[j + 1] = arr[j];
                j--;
                result.swaps++;
            }
            arr[j + 1] = key;
        }
    }

    // Seleção
    public static void selectionSort(int[] arr, Result result) {
        int n = arr.length;
        result.comparisons = 0;
        result.swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                result.comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                result.swaps++;
                swap(arr, i, minIdx);
            }
        }
    }

    // Método auxiliar para trocar elementos de matriz
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Método para executar testes de classificação por bolha
    public static void runBubbleSortTests(int n, int[] asc, int[] desc, int[] random) {
        testAlgorithm(n, "Bubble Sort Ascending", SortingTest::bubbleSort, asc);
        testAlgorithm(n, "Bubble Sort Descending", SortingTest::bubbleSort, desc);
        testAlgorithm(n, "Bubble Sort Random", SortingTest::bubbleSort, random);
    }

    // Método para executar testes de classificação de bolhas otimizadas
    public static void runOptimizedBubbleSortTests(int n, int[] asc, int[] desc, int[] random) {
        testAlgorithm(n, "Optimized Bubble Sort Ascending", SortingTest::optimizedBubbleSort, asc);
        testAlgorithm(n, "Optimized Bubble Sort Descending", SortingTest::optimizedBubbleSort, desc);
        testAlgorithm(n, "Optimized Bubble Sort Random", SortingTest::optimizedBubbleSort, random);
    }

    // Método para executar testes Inserção
    public static void runInsertionSortTests(int n, int[] asc, int[] desc, int[] random) {
        testAlgorithm(n, "Insertion Sort Ascending", SortingTest::insertionSort, asc);
        testAlgorithm(n, "Insertion Sort Descending", SortingTest::insertionSort, desc);
        testAlgorithm(n, "Insertion Sort Random", SortingTest::insertionSort, random);
    }

    // Método para executar testes Seleção
    public static void runSelectionSortTests(int n, int[] asc, int[] desc, int[] random) {
        testAlgorithm(n, "Selection Sort Ascending", SortingTest::selectionSort, asc);
        testAlgorithm(n, "Selection Sort Descending", SortingTest::selectionSort, desc);
        testAlgorithm(n, "Selection Sort Random", SortingTest::selectionSort, random);
    }

    // Executor de teste genérico para qualquer algoritmo de classificação
    public static void testAlgorithm(int n, String testName, SortAlgorithm algorithm, int[] originalArray) {
        Result result = new Result();
        long totalTime = 0;
        for (int i = 0; i < n; i++) {
            int[] arrCopy = Arrays.copyOf(originalArray, originalArray.length);
            long startTime = System.nanoTime();
            algorithm.sort(arrCopy, result);
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        System.out.printf("%s: Comparisons = %d, Swaps = %d, Time = %d ns%n",
                testName, result.comparisons, result.swaps, totalTime / n);
    }

    // Interface funcional para algoritmos de classificação
    interface SortAlgorithm {
        void sort(int[] arr, Result result);
    }

    // Classe para armazenar dados de resultado (comparações e trocas)
    static class Result {
        int comparisons;
        int swaps;
    }

    // Métodos para gerar diferentes tipos de matrizes
    public static int[] generateAscendingArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateDescendingArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        return arr;
    }
}
