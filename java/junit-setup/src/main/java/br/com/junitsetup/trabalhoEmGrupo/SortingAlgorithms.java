package br.com.junitsetup.trabalhoEmGrupo;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    // Gera vetores de diferentes tipos

    // ascendente
    public static int[] gerarVetorAscendente(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
        return vetor;
    }

    // descendente
    public static int[] gerarVetorDescendente(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    // aleatório
    public static int[] gerarVetorAleatorio(int tamanho) {
        Random random = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho);
        }
        return vetor;
    }

    // Método da bolha
    public static void bubbleSort(int[] arr) {
        int comparacoes = 0, trocas = 0;
        long inicio = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    trocas++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long fim = System.nanoTime();
        System.out.println("\nBubble Sort:");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo de execução (ms): " + (fim - inicio) / 1000000);
    }

    // Método da bolha otimizado
    public static void bubbleSortOtimizado(int[] arr) {
        int comparacoes = 0, trocas = 0;
        long inicio = System.nanoTime();
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    trocas++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Se não houve trocas, o array já está ordenado
        }
        long fim = System.nanoTime();
        System.out.println("\nBubble Sort Otimizado:");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo de execução (ms): " + (fim - inicio) / 1000000);
    }

    // Ordenação por inserção
    public static void insertionSort(int[] arr) {
        int comparacoes = 0, trocas = 0;
        long inicio = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            int chave = arr[i];
            int j = i - 1;
            comparacoes++;
            while (j >= 0 && arr[j] > chave) {
                trocas++;
                arr[j + 1] = arr[j];
                j--;
                comparacoes++;
            }
            arr[j + 1] = chave;
        }
        long fim = System.nanoTime();
        System.out.println("\nInsertion Sort:");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo de execução (ms): " + (fim - inicio) / 1000000);
    }

    // Ordenação por seleção
    public static void selectionSort(int[] arr) {
        int comparacoes = 0, trocas = 0;
        long inicio = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparacoes++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                trocas++;
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        long fim = System.nanoTime();
        System.out.println("\nSelection Sort:");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo de execução (ms): " + (fim - inicio) / 1000000);
    }

    public static void main(String[] args) {
        int tamanho = 50000;

        // Gerando vetores
        int[] ascendente = gerarVetorAscendente(tamanho);
        int[] descendente = gerarVetorDescendente(tamanho);
        int[] aleatorio = gerarVetorAleatorio(tamanho);

        // Testando métodos de ordenação
        System.out.println("\n-----------------");
        System.out.println("Vetor Ascendente:");
        System.out.println("-----------------");
        bubbleSort(Arrays.copyOf(ascendente, tamanho));
        bubbleSortOtimizado(Arrays.copyOf(ascendente, tamanho));
        insertionSort(Arrays.copyOf(ascendente, tamanho));
        selectionSort(Arrays.copyOf(ascendente, tamanho));
        
        System.out.println("\n-----------------");
        System.out.println("Vetor Descendente:");
        System.out.println("-----------------");
        bubbleSort(Arrays.copyOf(descendente, tamanho));
        bubbleSortOtimizado(Arrays.copyOf(descendente, tamanho));
        insertionSort(Arrays.copyOf(descendente, tamanho));
        selectionSort(Arrays.copyOf(descendente, tamanho));
        
        System.out.println("\n-----------------");
        System.out.println("Vetor Aleatório:");
        System.out.println("-----------------");
        bubbleSort(Arrays.copyOf(aleatorio, tamanho));
        bubbleSortOtimizado(Arrays.copyOf(aleatorio, tamanho));
        insertionSort(Arrays.copyOf(aleatorio, tamanho));
        selectionSort(Arrays.copyOf(aleatorio, tamanho));
    }
}

