import java.io.*;
import java.util.*;

public class Gerenciador {
    private ArrayList<Caixa> caixas;

    public Gerenciador() {
        caixas = new ArrayList<>();
    }

    public void lerArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dims = linha.trim().split("\\s+");
                if (dims.length == 3) {
                    int l = Integer.parseInt(dims[0]);
                    int w = Integer.parseInt(dims[1]);
                    int h = Integer.parseInt(dims[2]);

                    System.out.println(dims[0]);
                    System.out.println(dims[1]);
                    System.out.println(dims[2]);

                    if (caixas.add(new Caixa(l, w, h))) {
                        System.out.println("Caixa adicionada\n");
                    } else {
                        System.out.println("Deu ruim '-'");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ordenarCaixas() {
        Collections.sort(caixas);
    }

    public int maiorSequencia() {
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
