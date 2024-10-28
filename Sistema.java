import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Item> listaDeProdutos = new ArrayList<>();
    private Item itemTemporario;

    public Item criarItem(int codigo, String nome, double preco) {
        itemTemporario = new Item(codigo, nome, preco);
        return itemTemporario;
    }

    public void adicionarItemNaLista() {
        if (itemTemporario != null) {
            listaDeProdutos.add(itemTemporario);
            System.out.println("Produto adicionado à lista com sucesso!");
            itemTemporario = null;
        } else {
            System.out.println("Nenhum produto disponível para adicionar. Crie um produto primeiro.");
        }
    }
}
