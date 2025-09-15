
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.VendaService;
import dao.VendaDAO;

class VendaServiceTest {

    private VendaService vendaService;
    private VendaDAO vendaDAO; // Adicione esta linha
    // ...


    @BeforeEach
    void setUp() {
        vendaDAO = new VendaDAO();
        vendaService = new VendaService(vendaDAO);
    }

   

    // ✅ Cenários básicos já discutidos
    @Test
    void testAdicionarVendaCamposVazios() {
        assertFalse(vendaService.adicionarVenda("", ""));
    }

    @Test
    void testAdicionarVendaQuantidadeInvalida() {
        assertFalse(vendaService.adicionarVenda("Produto B", "abc"));
    }

    @Test
    void testAdicionarVendaQuantidadeValida() {
        assertTrue(vendaService.adicionarVenda("Produto C", "10"));
    }

    @Test
    void testAdicionarVendaQuantidadeZero() {
        assertFalse(vendaService.adicionarVenda("Produto Zero", "0"));
    }

    @Test
    void testAdicionarVendaNomeEspecial() {
        assertTrue(vendaService.adicionarVenda("Café 100%", "5"));
    }

    @Test
    void testGerarResumoComMultiplasVendas() {
        vendaService.adicionarVenda("Produto 1", "1");
        vendaService.adicionarVenda("Produto 2", "2");
        String resumo = vendaService.gerarResumo();
        assertTrue(resumo.contains("Produto 1"));
        assertTrue(resumo.contains("Produto 2"));
    }

    @Test
    void testGerarResumoVazio() {
        assertEquals("", vendaService.gerarResumo());
    }

    // 🔹 Cenários avançados / casos de borda
    @Test
    void testAdicionarVendaQuantidadeNegativa() {
        assertFalse(vendaService.adicionarVenda("Produto Negativo", "-5"));
    }

    @Test
    void testAdicionarVendaNomeNulo() {
        assertFalse(vendaService.adicionarVenda(null, "10"));
    }

    @Test
    void testAdicionarVendaQuantidadeNula() {
        assertFalse(vendaService.adicionarVenda("Produto Nulo", null));
    }

    @Test
    void testAdicionarVendaEspacosEmBranco() {
        assertFalse(vendaService.adicionarVenda("   ", "3"));
    }

    @Test
    void testAdicionarVendaMultiplosErros() {
        assertFalse(vendaService.adicionarVenda("", "abc"));
    }
}
