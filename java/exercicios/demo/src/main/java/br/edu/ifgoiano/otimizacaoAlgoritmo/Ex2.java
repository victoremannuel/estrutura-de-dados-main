package br.edu.ifgoiano.otimizacaoAlgoritmo;

public class Ex2 {
    public static boolean buscarEmMatriz(int[][] matriz, int valor) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        
        // Começa no canto superior direito
        int i = 0, j = colunas - 1;
        
        while (i < linhas && j >= 0) {
            if (matriz[i][j] == valor) {
                return true;
            } else if (matriz[i][j] > valor) {
                j--; // Move para a esquerda
            } else {
                i++; // Move para baixo
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int valor = 5;
        boolean encontrado = buscarEmMatriz(matriz, valor);

        if (encontrado) {
            System.out.println("Valor encontrado.");
        } else {
            System.out.println("Valor não encontrado.");
        }
    }
}
