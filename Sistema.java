import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sistema {

    private List<Item> listaDeProdutos = new ArrayList<>();
    private List<Item> listaDeCompras = new ArrayList<>();
    private Item itemTemporario;

    public String verificarCodigoDuplicado(int codigo) {
        for (Item item : listaDeProdutos) {
            if (item.getCodigo() == codigo) {
                return "Erro: Já existe um item cadastrado com este código."; // Mensagem de erro para código
            }
        }
        return null; // Retorna null se não houver duplicatas
    }

    public String verificarNomeDuplicado(String nome) {
        for (Item item : listaDeProdutos) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return "Erro: Já existe um item cadastrado com este nome."; // Mensagem de erro para nome
            }
        }
        return null; // Retorna null se não houver duplicatas
    }

    public Item criarItem(int codigo, String nome, double preco) {
        itemTemporario = new Item(codigo, nome, preco);
        listaDeProdutos.add(itemTemporario); // Adiciona o item à lista de produtos
        return itemTemporario;
    }

    public void adicionarItemNaLista(int codigo) {
        for (Item item : listaDeProdutos) {
            if (item.getCodigo() == codigo) {
                // Verifica se o item já está na lista de compras
                if (listaDeCompras.contains(item)) {
                    System.out.println("Erro: O produto " + item.getNome() + " já está na lista.");
                    return; // Não adiciona se já estiver na lista
                }
                listaDeCompras.add(item); // Adiciona o item à lista de compras
                System.out.println("Produto " + item.getNome() + " adicionado à lista com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado na lista de itens cadastrados.");
    }

    public List<Item> getListaDeProdutos() {
        return listaDeProdutos; // Retorna a lista de produtos cadastrados
    }

    public void listarItensCadastrados() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("Lista de Itens Cadastrados:");
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // Formatação em R$
            for (Item item : listaDeProdutos) {
                System.out.printf("Código: %d, Nome: %s, Preço: %s%n", 
                                  item.getCodigo(), 
                                  item.getNome(), 
                                  formatoMoeda.format(item.getPreco()));
            }
        }
    }

    public void listarItensNaLista() {
        if (listaDeCompras.isEmpty()) {
            System.out.println("Nenhum item adicionado na lista.");
        } else {
            System.out.println("Lista de Itens na Lista de Compras:");
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // Formatação em R$
            for (Item item : listaDeCompras) {
                System.out.printf("Código: %d, Nome: %s, Preço: %s%n", 
                                  item.getCodigo(), 
                                  item.getNome(), 
                                  formatoMoeda.format(item.getPreco()));
            }
        }
    }

    public void pesquisarItemPorCodigo(int codigo) {
        for (Item item : listaDeProdutos) {
            if (item.getCodigo() == codigo) {
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // Formatação em R$
                System.out.printf("Item encontrado: Código: %d, Nome: %s, Preço: %s%n", 
                                  item.getCodigo(), 
                                  item.getNome(), 
                                  formatoMoeda.format(item.getPreco()));
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    public void pesquisarItemPorNome(String nome) {
        boolean encontrado = false;
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // Formatação em R$
        
        for (Item item : listaDeProdutos) {
            if (item.getNome().toLowerCase().contains(nome.toLowerCase())) { // Ignora case sensitivity
                System.out.printf("Item encontrado: Código: %d, Nome: %s, Preço: %s%n", 
                                  item.getCodigo(), 
                                  item.getNome(), 
                                  formatoMoeda.format(item.getPreco()));
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("Nenhum item encontrado com esse nome.");
        }
    }
}
