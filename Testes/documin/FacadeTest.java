package documin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FacadeTest {

    private Facade facade = new Facade();
    private Throwable exception;

    @BeforeEach
    void preparaAlunosGrupos() {
        facade.criarDocumento("Teste");
        facade.criarTexto("Teste", "Brinks RS", 1);
        facade.criarDocumento("Teste2");
    }

    @Test
    void criarDocumento() {
        assertEquals(true, facade.criarDocumento("Como fazer bolo"));
        assertEquals(false, facade.criarDocumento("Como fazer bolo"));
        assertEquals(false, facade.criarDocumento(""));
    }

    @Test
    void testCriarDocumentoComTamanho() {
        assertEquals(true, facade.criarDocumento("Como fazer cerveja", 5));
        assertEquals(false, facade.criarDocumento("Como fazer cerveja", 5));
        assertEquals(false, facade.criarDocumento("", 1));
    }

    @Test
    void testaExceptionsCriarDocumentoComTamanho() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            facade.criarDocumento("Como fazer Brigadeiro", -1);
        });
        assertEquals("Tamanho Inválido !", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            facade.criarDocumento("Como fazer Pão", 0);
        });
        assertEquals("Tamanho Inválido !", exception.getMessage());
    }

    @Test
    void removerDocumento() {
        facade.criarDocumento("Bolo de batata");
        facade.removerDocumento("Bolo de batata");
        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.removerDocumento("Bolo de batata");
        });
        assertEquals("Esse documento não existe !", exception.getMessage());
    }

    @Test
    void contarElementos() {
        assertEquals(1, facade.contarElementos("Teste"));
        facade.criaTitulo("Teste", "TestandoTítulo", 1, 1, false);
        assertEquals(2, facade.contarElementos("Teste"));
        assertEquals(0, facade.contarElementos("Teste2"));
    }

    @Test
    void exibirDocumento() {
        assertArrayEquals(new String[]{"Brinks RS"}, facade.exibirDocumento("Teste"));
        exception = assertThrows(NoSuchElementException.class, () -> {
           facade.exibirDocumento("EsseDocNãoExiste");
        });
        assertEquals("Esse documento não existe !", exception.getMessage());
    }

    @Test
    void criarTexto() {
        assertEquals(0, facade.criarTexto("Teste2", "Testando...", 1));
        assertArrayEquals(new String[]{"Testando..."}, facade.exibirDocumento("Teste2"));
    }

    @Test
    void criaTitulo() {
        assertEquals(0, facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false));
        assertArrayEquals(new String[]{"1. Mais um Teste"}, facade.exibirDocumento("Teste2"));
    }

    @Test
    void criarLista() {
    }

    @Test
    void criarTermos() {
    }

    @Test
    void pegarRepresentacaoCompleta() {
    }

    @Test
    void pegarrepresentacaoResumida() {
    }

    @Test
    void apagarElemento() {
    }

    @Test
    void moverParaCima() {
    }

    @Test
    void moverParaBaixo() {
    }

    @Test
    void criarAtalho() {
    }

    @Test
    void criarVisaoCompleta() {
    }

    @Test
    void criarVisaoResumida() {
    }

    @Test
    void criarVisaoPrioritaria() {
    }

    @Test
    void criarVisaoTitulo() {
    }

    @Test
    void exibirVisao() {
    }
}