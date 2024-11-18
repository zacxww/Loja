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
            System.out.println("7 - Remover Item da Lista");
            System.out.println("8 - Remover Item Cadastrado");
            System.out.println("9 - Editar nome de um Item");
            System.out.println("10 - Editar código de um Item");
            System.out.println("11 - Filtrar Itens por Faixa de Preço");
            System.out.println("12 - Ordenar Itens por Nome");
            System.out.println("13 - Ordenar Itens por Preço");
            System.out.println("14 - Atualizar Preço de um Item pelo Código");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o código do Item: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                String erroCodigo = sistema.verificarCodigoDuplicado(codigo);
                if (erroCodigo != null) {
                    System.out.println(erroCodigo);
                    continue;
                }

                System.out.print("Digite o nome do Item: ");
                String nome = scanner.nextLine();

                String erroNome = sistema.verificarNomeDuplicado(nome);
                if (erroNome != null) {
                    System.out.println(erroNome);
                    continue;
                }

                System.out.print("Digite o preço do Item: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();

                sistema.criarItem(codigo, nome, preco);
                System.out.println("Produto criado e adicionado à lista de produtos com sucesso!");

            } else if (opcao == 2) {
                sistema.listarItensCadastrados();

                if (!sistema.getListaDeItens().isEmpty()) {
                    System.out.print("Qual produto você gostaria de adicionar à lista? Digite o código: ");
                    int codigoAdicionar = scanner.nextInt();
                    sistema.adicionarItemNaLista(codigoAdicionar);
                } else {
                    System.out.println("Nenhum produto cadastrado para adicionar à lista.");
                }

            } else if (opcao == 3) {
                sistema.listarItensCadastrados();
            } else if (opcao == 4) {
                sistema.listarItensNaLista();
            } else if (opcao == 5) {
                System.out.print("Digite o código do Item para pesquisar: ");
                int codigoPesquisa = scanner.nextInt();
                sistema.pesquisarItemPorCodigo(codigoPesquisa);
            } else if (opcao == 6) {
                System.out.print("Digite o nome do Item para pesquisar: ");
                String nomePesquisa = scanner.nextLine();
                sistema.pesquisarItemPorNome(nomePesquisa);
            } else if (opcao == 7) {
                sistema.listarItensNaLista();
                System.out.print("Digite o código do Item que deseja remover da lista: ");
                int codigoRemoverLista = scanner.nextInt();
                sistema.removerItemDaLista(codigoRemoverLista);
            } else if (opcao == 8) {
                sistema.listarItensCadastrados();
                System.out.print("Digite o código do Item que deseja remover: ");
                int codigoRemoverCadastrado = scanner.nextInt();
                sistema.removerItemCadastrado(codigoRemoverCadastrado);
            } else if (opcao == 9) {
                sistema.listarItensCadastrados();
                System.out.print("Digite o código do Item que deseja editar o nome: ");
                int codigoEditar = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o novo nome do Item: ");
                String novoNome = scanner.nextLine();

                sistema.editarNomeItem(codigoEditar, novoNome);
            } else if (opcao == 10) {
                sistema.listarItensCadastrados();
                System.out.print("Digite o código do Item que deseja editar: ");
                int codigoAntigo = scanner.nextInt();
                System.out.print("Digite o novo código do Item: ");
                int novoCodigo = scanner.nextInt();

                sistema.editarCodigoItem(codigoAntigo, novoCodigo);
            } else if (opcao == 11) {
                System.out.print("Digite o preço mínimo: ");
                double precoMin = scanner.nextDouble();
                System.out.print("Digite o preço máximo: ");
                double precoMax = scanner.nextDouble();
                scanner.nextLine();

                sistema.filtrarItensPorFaixaDePreco(precoMin, precoMax);
            } else if (opcao == 12) {
                sistema.ordenarItensPorNome();
            } else if (opcao == 13) {
                sistema.ordenarItensPorPreco();
            } else if (opcao == 14) {
                System.out.print("Digite o código do Item que deseja atualizar o preço: ");
                int codigoAtualizar = scanner.nextInt();
                System.out.print("Digite o novo preço: ");
                double novoPreco = scanner.nextDouble();
                sistema.atualizarPrecoPorCodigo(codigoAtualizar, novoPreco);
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
