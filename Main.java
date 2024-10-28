import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Item");
            System.out.println("2 - Adicionar produto à lista");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                System.out.print("Digite o código do Item: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome do Item: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o preço do Item: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();
                sistema.criarItem(codigo, nome, preco);
                System.out.println("Produto criado com sucesso!");
            } else if (opcao == 2) {
                sistema.adicionarItemNaLista();
            } else if (opcao == 0) {
                System.out.println("Encerrando o sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
