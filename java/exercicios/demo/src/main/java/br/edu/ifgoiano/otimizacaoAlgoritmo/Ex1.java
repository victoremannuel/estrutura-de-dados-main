package br.edu.ifgoiano.otimizacaoAlgoritmo;

public class Ex1 {
    public static int encontrarPico(int[] arr, int inicio, int fim) {
        int meio = inicio + (fim - inicio) / 2;

        // Verifica se o meio é um pico
        if ((meio == 0 || arr[meio] >= arr[meio - 1]) && 
            (meio == arr.length - 1 || arr[meio] >= arr[meio + 1])) {
            return arr[meio];
        }
        
        // Se o elemento à esquerda do meio for maior, busca na metade esquerda
        else if (meio > 0 && arr[meio - 1] > arr[meio]) {
            return encontrarPico(arr, inicio, meio - 1);
        }
        
        // Senão, busca na metade direita
        else {
            return encontrarPico(arr, meio + 1, fim);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int pico = encontrarPico(arr, 0, arr.length - 1);

        System.out.println("Pico encontrado: " + pico);
    }
}

