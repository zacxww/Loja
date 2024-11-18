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
        // Dado que um item com código 1 existe e tem o preço 10.0
        // Quando eu tento atualizar o preço para 15.0
        // Então o preço do item deve ser atualizado corretamente.

        boolean resultado = sistema.atualizarPrecoPorCodigo(1, 15.0);
        assertTrue(resultado, "O preço deveria ser atualizado com sucesso.");
    }

}