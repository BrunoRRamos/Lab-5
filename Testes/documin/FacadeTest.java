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
        assertTrue(facade.criarDocumento("Como fazer bolo"));
        assertFalse(facade.criarDocumento("Como fazer bolo"));
        assertFalse(facade.criarDocumento(""));
    }

    @Test
    void testCriarDocumentoComTamanho() {
        assertTrue(facade.criarDocumento("Como fazer cerveja", 5));
        assertFalse(facade.criarDocumento("Como fazer cerveja", 5));
        assertFalse(facade.criarDocumento("", 1));
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
        assertEquals(0, facade.criarLista("Teste2", "TestandoListas...", 1, "/", "-"));
        assertArrayEquals(new String[]{"\n- TestandoListas..."}, facade.exibirDocumento("Teste2"));
    }

    @Test
    void criarTermos() {
        assertEquals(0, facade.criarTermos("Teste2", "TestandoTermos...", 1, "-", "ALFABETICA"));
        assertArrayEquals(new String[]{"Total termos: 1\n- TestandoTermos..."}, facade.exibirDocumento("Teste2"));
    }

    @Test
    void pegarRepresentacaoCompleta() {
        assertEquals("Brinks RS", facade.pegarRepresentacaoCompleta("Teste", 0));
    }

    @Test
    void pegarrepresentacaoResumida() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        assertEquals("1. Mais um Teste", facade.pegarrepresentacaoResumida("Teste2", 0));
    }

    @Test
    void apagarElemento() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        assertTrue(facade.apagarElemento("Teste2", 0));
        assertFalse(facade.apagarElemento("Teste2", 0));
    }

    @Test
    void moverParaCima() {
        //Index 0
        assertEquals(0, facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false));
        //Index 1
        assertEquals(1, facade.criarTexto("Teste2", "Testando Ordem", 1));

        //Invertendo Ordem
        facade.moverParaCima("Teste2", 1);
        //Verificando troca de ordem
        assertEquals("Testando Ordem", facade.pegarRepresentacaoCompleta("Teste2", 0));
        assertEquals("1. Mais um Teste", facade.pegarRepresentacaoCompleta("Teste2", 1));


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