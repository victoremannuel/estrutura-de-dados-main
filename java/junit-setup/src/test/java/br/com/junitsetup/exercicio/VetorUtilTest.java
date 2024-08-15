package br.com.junitsetup.exercicio;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class VetorUtilTest {

    private final VetorUtil vetorUtil = new VetorUtil();

    @Nested
    class CopiarValores {
        @Test
        public void testCopiarValores() {
            int[] a = { 1, 2, 3 };
            int[] b = new int[3];
            vetorUtil.copiarValores(a, b);
            assertArrayEquals(a, b);
        }

        @Test
        public void testCopiarValoresVazio() {
            int[] aVazio = {};
            int[] bVazio = new int[0];
            vetorUtil.copiarValores(aVazio, bVazio);
            assertArrayEquals(aVazio, bVazio);
        }

        @Test
        public void testCopiarValoresMaior() {
            int[] a = { 1, 2, 3 };
            int[] bMaior = new int[5];
            vetorUtil.copiarValores(a, bMaior);
            assertArrayEquals(new int[] { 1, 2, 3, 0, 0 }, bMaior);
        }

        @Test
        public void testCopiarValoresMenor() {
            int[] a = { 1, 2, 3 };
            int[] bMenor = new int[2];
            vetorUtil.copiarValores(a, bMenor);
            assertArrayEquals(new int[] { 1, 2 }, bMenor);
        }
    }

    @Nested
    class CopiarValoresInverso {

        @Test
        public void testCopiarValoresInverso() {
            int[] a = { 1, 2, 3 };
            int[] b = new int[3];
            vetorUtil.copiarValoresInverso(a, b);
            assertArrayEquals(new int[] { 3, 2, 1 }, b);
        }

        @Test
        public void testCopiarValoresInversoVazio() {
            int[] aVazio = {};
            int[] bVazio = new int[0];
            vetorUtil.copiarValoresInverso(aVazio, bVazio);
            assertArrayEquals(aVazio, bVazio);
        }

        @Test
        public void testCopiarValoresInversoMaior() {
            int[] a = { 1, 2, 3 };
            int[] bMaior = new int[5];
            vetorUtil.copiarValoresInverso(a, bMaior);
            assertArrayEquals(new int[] { 3, 2, 1, 0, 0 }, bMaior);
        }

        @Test
        public void tetestCopiarValoresInversoMenor() {
            int[] a = { 1, 2, 3 };
            int[] bMenor = new int[2];
            vetorUtil.copiarValoresInverso(a, bMenor);
            assertArrayEquals(new int[] { 3, 2 }, bMenor);
        }
    }

    @Nested
    class SomarVetores {
        @Test
        public void testSomarVetores() {
            int[] a = { 1, 2, 3 };
            int[] b = { 4, 5, 6 };
            int[] resultado = vetorUtil.somarVetores(a, b);
            assertArrayEquals(new int[] { 5, 7, 9 }, resultado);
        }

        @Test
        public void testSomarVetoresVazio() {
            int[] aVazio = {};
            int[] bVazio = {};
            int[] resultadoVazio = vetorUtil.somarVetores(aVazio, bVazio);
            assertArrayEquals(new int[0], resultadoVazio);
        }

        @Test
        public void testSomarVetoresDesigual() {
            int[] aMenor = { 1, 2 };
            int[] bMaior = { 4, 5, 6 };
            int[] resultadoDesigual = vetorUtil.somarVetores(aMenor, bMaior);
            assertArrayEquals(new int[] { 5, 7, 6 }, resultadoDesigual);
        }

        @Test
        public void testSomarVetoresDesigual2() {
            int[] aMaior = { 1, 2, 3 };
            int[] bMenor = { 4, 5 };
            int[] resultadoDesigual2 = vetorUtil.somarVetores(aMaior, bMenor);
            assertArrayEquals(new int[] { 5, 7, 3 }, resultadoDesigual2);
        }
    }

    @Nested
    class IntercalarElementos {
        @Test
        public void testIntercalarElementos() {
            int[] a = { 1, 3, 5 };
            int[] b = { 2, 4, 6 };
            int[] resultado = vetorUtil.intercalarElementos(a, b);
            assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, resultado);
        }

        @Test
        public void testIntercalarElementosVazio() {
            int[] aVazio = {};
            int[] bVazio = {};
            int[] resultadoVazio = vetorUtil.intercalarElementos(aVazio, bVazio);
            assertArrayEquals(new int[0], resultadoVazio);
        }

        @Test
        public void testIntercalarElementosDesigual() {
            int[] aMenor = { 1 };
            int[] bMaior = { 2, 4, 6 };
            int[] resultadoDesigual = vetorUtil.intercalarElementos(aMenor, bMaior);
            assertArrayEquals(new int[] { 1, 2, 4, 6 }, resultadoDesigual);
        }

        @Test
        public void testIntercalarElementosDesigual2() {
            int[] aMaior = { 1, 3, 5 };
            int[] bMenor = { 2 };
            int[] resultadoDesigual2 = vetorUtil.intercalarElementos(aMaior, bMenor);
            assertArrayEquals(new int[] { 1, 2, 3, 5 }, resultadoDesigual2);
        }
    }
}
