

public class Main {

    public static void main(String[] args) {
        GerenciadorCaixas gerenciador = new GerenciadorCaixas();
        String caminhoArquivo = "arquivos//caixas_1005.txt";   // Caminho do arquivo

        // Ler o arquivo
        gerenciador.lerArquivo(caminhoArquivo);

        // Ordenar as caixas
        gerenciador.ordenarCaixas();

        // Encontrar a maior sequência de caixas
        int maxLength = gerenciador.encontrarMaiorSequenciaAninhada();
        System.out.println("O comprimento da maior sequência é: " + maxLength);
    }
}
