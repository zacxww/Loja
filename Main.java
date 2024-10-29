import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Item");
            System.out.println("2 - Adicionar produto à lista");
            System.out.println("3 - Listar Itens Cadastrados");
            System.out.println("4 - Listar produtos adicionados à lista");
            System.out.println("5 - Pesquisar Item por Código");
            System.out.println("6 - Pesquisar Item por Nome");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 1) {
                System.out.print("Digite o código do Item: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                
                // Verifica duplicata do código antes de solicitar o nome
                String erroCodigo = sistema.verificarCodigoDuplicado(codigo);
                if (erroCodigo != null) { 
                    System.out.println(erroCodigo); // Exibe a mensagem de erro se houver duplicatas
                    continue; // Volta ao início do loop sem solicitar mais dados
                }

                System.out.print("Digite o nome do Item: ");
                String nome = scanner.nextLine();

                // Verifica duplicata do nome antes de criar o produto
                String erroNome = sistema.verificarNomeDuplicado(nome);
                if (erroNome != null) { 
                    System.out.println(erroNome); // Exibe a mensagem de erro se houver duplicatas
                    continue; // Volta ao início do loop sem solicitar mais dados
                }

                System.out.print("Digite o preço do Item: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();

                // Tenta criar o produto e verifica se foi bem-sucedido
                Item novoItem = sistema.criarItem(codigo, nome, preco);
                if (novoItem != null) { // Verifica se a criação foi bem-sucedida
                    System.out.println("Produto criado e adicionado à lista de produtos com sucesso!");
                }
                
            } else if (opcao == 2) {
                sistema.listarItensCadastrados(); // Lista os itens cadastrados antes da adição
                
                if (!sistema.getListaDeProdutos().isEmpty()) { // Verifica se há itens cadastrados
                    System.out.print("Qual produto você gostaria de adicionar à lista? Digite o código: ");
                    int codigoAdicionar = scanner.nextInt();
                    sistema.adicionarItemNaLista(codigoAdicionar); // Adiciona o produto selecionado à lista de compras
                } else {
                    System.out.println("Nenhum produto cadastrado para adicionar à lista.");
                }
                
            } else if (opcao == 3) {
                sistema.listarItensCadastrados(); // Lista itens cadastrados
            } else if (opcao == 4) {
                sistema.listarItensNaLista(); // Lista itens na lista de compras
            } else if (opcao == 5) {
                System.out.print("Digite o código do Item para pesquisar: ");
                int codigoPesquisa = scanner.nextInt();
                sistema.pesquisarItemPorCodigo(codigoPesquisa);
            } else if (opcao == 6) {
                System.out.print("Digite o nome do Item para pesquisar: ");
                String nomePesquisa = scanner.nextLine();
                sistema.pesquisarItemPorNome(nomePesquisa);
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
