import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            System.out.println(" ");
            System.out.println("Selecione o arquivo a ser lido:");
            System.out.println("1. arquivos//caixas_5.txt");
            System.out.println("2. arquivos//caixas_11.txt");
            System.out.println("3. arquivos//caixas_12.txt");
            System.out.println("4. arquivos//caixas_15.txt");
            System.out.println("5. arquivos//caixas_1005.txt");
            System.out.println("6. Sair");

            System.out.print("Digite a opção : ");

            int opcao = scanner.nextInt();
            String caminhoArquivo = " ";

            switch (opcao) {
                case 1:
                    caminhoArquivo = "arquivos//caixas_5.txt";
                    break;
                case 2:
                    caminhoArquivo = "arquivos//caixas_11.txt";
                    break;
                case 3:
                    caminhoArquivo = "arquivos//caixas_12.txt";
                    break;
                case 4:
                    caminhoArquivo = "arquivos//caixas_15.txt";
                    break;
                case 5:
                    caminhoArquivo = "arquivos//caixas_1005.txt";
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    continuar = false;
                    continue;
                default:
                    System.out.println("Opção inválida. Usando arquivo padrão.");
                    break;

            }
            gerenciador.lerArquivo(caminhoArquivo);
            gerenciador.ordenarCaixas();
            int max = gerenciador.maiorSequencia();
            System.out.println("O comprimento da maior sequência é: " + max);
        }
    }
}
