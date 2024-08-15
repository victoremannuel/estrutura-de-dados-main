package br.com.junitsetup.exercicio;

public class VetorUtil {

    /**
     * Copie o conteúdo do vetor a para o vetor b
     * 
     * @param a vetor de origem
     * @param b vetor de destino
     */
    public void copiarValores(int[] a, int[] b) {
        int tamanho = Math.min(a.length, b.length);
        for (int i = 0; i < tamanho; i++) {
            b[i] = a[i];
        }
    }

    /**
     * Copie o conteúdo do vetor a para o vetor b na ordem inversa
     * 
     * @param a vetor de origem
     * @param b vetor de destino
     */

    public void copiarValoresInverso(int[] a, int[] b) {
        int tamanho = Math.min(a.length, b.length);
        for (int i = 0; i < tamanho; i++) {
            b[i] = a[a.length - 1 - i];
        }
    }

    /**
     * Soma o conteúdo de dois vetores e retorna o resultado em um novo vetor
     * 
     * @param a vetor <strong>A</strong>
     * @param b vetor <strong>B</strong>
     * @return vetor contendo a soma dos elementos em cada posição
     */
    public int[] somarVetores(int[] a, int[] b) {
        int tamanho = Math.max(a.length, b.length);
        int[] resultado = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            int valorA = i < a.length ? a[i] : 0;
            int valorB = i < b.length ? b[i] : 0;
            resultado[i] = valorA + valorB;
        }

        return resultado;
    }

    /**
     * Intercala os elementos de dois vetores em um novo. Os vetores de entrada
     * podem ser de tamanhos diferentes
     * 
     * @param a vetor <strong>A</strong>
     * @param b vetor <strong>B</strong>
     * @return novo vetor com os valores de <strong>A</strong> intercalados com o de
     *         <strong>B</strong>
     */
    public int[] intercalarElementos(int[] a, int[] b) {
        int tamanho = a.length + b.length;
        int[] resultado = new int[tamanho];
        int indexA = 0, indexB = 0, indexResultado = 0;

        while (indexA < a.length || indexB < b.length) {
            if (indexA < a.length) {
                resultado[indexResultado++] = a[indexA++];
            }
            if (indexB < b.length) {
                resultado[indexResultado++] = b[indexB++];
            }
        }
        return resultado;
    }

}