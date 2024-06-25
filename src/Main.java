
public class Main {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        String caminhoArquivo = "arquivos//caixas_1005.txt";

        gerenciador.lerArquivo(caminhoArquivo);
        gerenciador.ordenarCaixas();
        int max = gerenciador.maiorSequencia();
        System.out.println("O comprimento da maior sequência é: " + max);
    }
}
