import java.io.*;
import java.util.*;

public class Main {

    static class Caixa implements Comparable<Caixa> {
        int l, w, h;

        // Construtor que recebe as três dimensões e as ordena
        Caixa(int l, int w, int h) {
            int[] dims = {l, w, h};
            Arrays.sort(dims); // Ordenar as dimensões para facilitar comparações
            this.l = dims[0];
            this.w = dims[1];
            this.h = dims[2];
        }

        // Implementação do método de comparação
        @Override
        public int compareTo(Caixa o) {
            if (this.l != o.l) return this.l - o.l;
            if (this.w != o.w) return this.w - o.w;
            return this.h - o.h;
        }

        // Verificar se uma caixa pode conter outra
        boolean podeConter(Caixa b) {
            return this.l < b.l && this.w < b.w && this.h < b.h;
        }
    }

    public static void main(String[] args) {


        List<Caixa> caixas = new ArrayList<>();
        String caminhoArquivo = "arquivos//caixas_2000.txt";

        // Leitura do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dims = linha.trim().split("\\s+");
                if (dims.length == 3) {
                    int l = Integer.parseInt(dims[0]);
                    int w = Integer.parseInt(dims[1]);
                    int h = Integer.parseInt(dims[2]);
                    caixas.add(new Caixa(l, w, h));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordenar as caixas
        Collections.sort(caixas);

        // Encontrar a maior sequência de caixas
        int maxLength = encontrarMaiorSequenciaAninhada(caixas);
        System.out.println("O comprimento da maior sequência é: " + maxLength);
    }

    // Método para encontrar a maior sequência de caixas aninhadas
    private static int encontrarMaiorSequenciaAninhada(List<Caixa> caixas) {
        int n = caixas.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (caixas.get(j).podeConter(caixas.get(i))) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}
