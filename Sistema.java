import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sistema {

    private List<Item> listaDeItens = new ArrayList<>();
    private List<Item> listaDeCompras = new ArrayList<>();

    public String verificarCodigoDuplicado(int codigo) {
        for (Item item : listaDeItens) {
            if (item.getCodigo() == codigo) {
                return "Erro: Já existe um item cadastrado com este código.";
            }
        }
        return null;
    }

    public String verificarNomeDuplicado(String nome) {
        for (Item item : listaDeItens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return "Erro: Já existe um item cadastrado com este nome.";
            }
        }
        return null;
    }

    public Item criarItem(int codigo, String nome, double preco) {
        Item novoItem = new Item(codigo, nome, preco);
        listaDeItens.add(novoItem);
        return novoItem;
    }

    public void adicionarItemNaLista(int codigo) {
        for (Item item : listaDeItens) {
            if (item.getCodigo() == codigo) {
                if (listaDeCompras.contains(item)) {
                    System.out.println("Erro: O produto " + item.getNome() + " já está na lista.");
                    return;
                }
                listaDeCompras.add(item);
                System.out.println("Produto " + item.getNome() + " adicionado à lista com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado na lista de itens cadastrados.");
    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void listarItensCadastrados() {
        if (listaDeItens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("Lista de Itens Cadastrados:");
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            for (Item item : listaDeItens) {
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
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            for (Item item : listaDeCompras) {
                System.out.printf("Código: %d, Nome: %s, Preço: %s%n",
                        item.getCodigo(),
                        item.getNome(),
                        formatoMoeda.format(item.getPreco()));
            }
        }
    }

    public void pesquisarItemPorCodigo(int codigo) {
        for (Item item : listaDeItens) {
            if (item.getCodigo() == codigo) {
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
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
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Item item : listaDeItens) {
            if (item.getNome().toLowerCase().contains(nome.toLowerCase())) {
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

    public void removerItemDaLista(int codigo) {
        Item itemParaRemover = null;
        for (Item item : listaDeCompras) {
            if (item.getCodigo() == codigo) {
                itemParaRemover = item;
                break;
            }
        }
        if (itemParaRemover != null) {
            listaDeCompras.remove(itemParaRemover);
            System.out.println("Item removido da lista de compras com sucesso!");
        } else {
            System.out.println("Item não encontrado na lista de compras.");
        }
    }

    public void removerItemCadastrado(int codigo) {
        Item itemParaRemover = null;
        for (Item item : listaDeItens) {
            if (item.getCodigo() == codigo) {
                itemParaRemover = item;
                break;
            }
        }
        if (itemParaRemover != null) {
            listaDeItens.remove(itemParaRemover);
            System.out.println("Item removido da lista de cadastrados com sucesso!");
        } else {
            System.out.println("Item não encontrado na lista de cadastrados.");
        }
    }

    public void editarNomeItem(int codigo, String novoNome) {
        for (Item item : listaDeItens) {
            if (item.getCodigo() == codigo) {
                // Verifica se o novo nome já está em uso
                String erroNome = verificarNomeDuplicado(novoNome);
                if (erroNome != null) {
                    System.out.println(erroNome);
                    return;
                }
                item.setNome(novoNome);
                System.out.println("Nome do item atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Item não encontrado para edição.");
    }

    public void editarCodigoItem(int codigoAntigo, int novoCodigo) {
        for (Item item : listaDeItens) {
            if (item.getCodigo() == codigoAntigo) {
                // Verifica se o novo código já está em uso
                String erroCodigo = verificarCodigoDuplicado(novoCodigo);
                if (erroCodigo != null) {
                    System.out.println(erroCodigo);
                    return;
                }
                item.setCodigo(novoCodigo);
                System.out.println("Código do item atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Item não encontrado para edição.");
    }
}
