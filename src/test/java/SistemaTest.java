import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaTest {

    private Sistema sistema;

    @BeforeEach
    void setUp() {
        sistema = new Sistema();
        sistema.criarItem(1, "Produto 1", 10.0);
    }

    @Test
    void testAtualizarPrecoPorCodigo_ItemExistente() {
        boolean resultado = sistema.atualizarPrecoPorCodigo(1, 15.0);

        assertTrue(resultado, "O preço deveria ser atualizado com sucesso.");

        assertEquals(15.0, sistema.getListaDeItens().get(0).getPreco(), 0.01,
                "O preço do produto com código 1 deveria ser 15.0.");
    }

}