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
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void contarElementos() {
        assertEquals(1, facade.contarElementos("Teste"));
        facade.criaTitulo("Teste", "TestandoTítulo", 1, 1, false);
        assertEquals(2, facade.contarElementos("Teste"));
        assertEquals(0, facade.contarElementos("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.contarElementos("Bolo de batata");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void exibirDocumento() {
        assertArrayEquals(new String[]{"Brinks RS"}, facade.exibirDocumento("Teste"));
        exception = assertThrows(NoSuchElementException.class, () -> {
           facade.exibirDocumento("EsseDocNãoExiste");
        });
        assertEquals("Esse documento não existe", exception.getMessage());

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.exibirDocumento("Bolo de batata");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarTexto() {
        assertEquals(0, facade.criarTexto("Teste2", "Testando...", 1));
        assertArrayEquals(new String[]{"Testando..."}, facade.exibirDocumento("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarTexto("Bolo de batata", "Testando...", 1);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criaTitulo() {
        assertEquals(0, facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false));
        assertArrayEquals(new String[]{"1. Mais um Teste"}, facade.exibirDocumento("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criaTitulo("Bolo de batata", "Mais um Teste", 1, 1, false);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarLista() {
        assertEquals(0, facade.criarLista("Teste2", "TestandoListas...", 1, "/", "-"));
        assertArrayEquals(new String[]{"\n- TestandoListas..."}, facade.exibirDocumento("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarLista("Bolo de batata", "TestandoListas...", 1, "/", "-");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarTermos() {
        assertEquals(0, facade.criarTermos("Teste2", "TestandoTermos...", 1, "-", "ALFABETICA"));
        assertArrayEquals(new String[]{"Total termos: 1\n- TestandoTermos..."}, facade.exibirDocumento("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarTermos("Bolo de batata", "TestandoTermos...", 1, "-", "ALFABETICA");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void pegarRepresentacaoCompleta() {
        assertEquals("Brinks RS", facade.pegarRepresentacaoCompleta("Teste", 0));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.pegarRepresentacaoCompleta("Bolo de batata", 0);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void pegarrepresentacaoResumida() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        assertEquals("1. Mais um Teste", facade.pegarrepresentacaoResumida("Teste2", 0));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.pegarrepresentacaoResumida("Bolo de batata", 0);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void apagarElemento() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        assertTrue(facade.apagarElemento("Teste2", 0));
        assertFalse(facade.apagarElemento("Teste2", 0));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.apagarElemento("Bolo de batata", 0);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
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
    void testaExeptionMoverPraCima() {
        assertEquals(0, facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false));
        assertEquals(1, facade.criarTexto("Teste2", "Testando Ordem", 1));

        exception = assertThrows(IllegalArgumentException.class, () -> {
           facade.moverParaCima("Teste2", 0);
        });
        assertEquals("Posição Inválida !", exception.getMessage());

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.moverParaCima("Bolo de batata", 1);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void moverParaBaixo() {
        //Index 0
        assertEquals(0, facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false));
        //Index 1
        assertEquals(1, facade.criarTexto("Teste2", "Testando Ordem", 1));

        //Invertendo Ordem
        facade.moverParaBaixo("Teste2", 0);
        //Verificando troca de ordem
        assertEquals("Testando Ordem", facade.pegarRepresentacaoCompleta("Teste2", 0));
        assertEquals("1. Mais um Teste", facade.pegarRepresentacaoCompleta("Teste2", 1));
    }

    @Test
    void testaExeptionMoverPraBaixo() {
        assertEquals(0, facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false));
        assertEquals(1, facade.criarTexto("Teste2", "Testando Ordem", 1));

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            facade.moverParaBaixo("Teste2", 1);
        });
        assertEquals("Posição Inválida !", exception.getMessage());

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.moverParaBaixo("Bolo de batata", 0);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarAtalho() {
        assertEquals(0, facade.criarAtalho("Teste2", "Teste"));

        exception = assertThrows(IllegalStateException.class, () -> {
            facade.criarAtalho("Teste2", "Teste");
        });
        assertEquals("Já possui Atalho", exception.getMessage());

        exception = assertThrows(IllegalStateException.class, () -> {
            facade.criarAtalho("Teste", "Teste2");
        });
        assertEquals("Já possui Atalho", exception.getMessage());


        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarAtalho("Bolo de batata", "Teste");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarVisaoCompleta() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        facade.criarTexto("Teste2", "Testando...", 1);
        assertEquals(0, facade.criarVisaoCompleta("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarVisaoCompleta("Bolo de batata");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarVisaoResumida() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        facade.criarTexto("Teste2", "Testando...", 1);
        assertEquals(0, facade.criarVisaoResumida("Teste2"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarVisaoResumida("Bolo de batata");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarVisaoPrioritaria() {
        assertEquals(0, facade.criarVisaoPrioritaria("Teste", 1));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarVisaoPrioritaria("Bolo de batata", 1);
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void criarVisaoTitulo() {
        assertEquals(0, facade.criarVisaoTitulo("Teste"));

        exception = assertThrows(NoSuchElementException.class, () -> {
            facade.criarVisaoTitulo("Bolo de batata");
        });
        assertEquals("Esse documento não existe", exception.getMessage());
    }

    @Test
    void exibirVisao() {
        facade.criaTitulo("Teste2", "Mais um Teste", 1, 1, false);
        facade.criarTexto("Teste2", "Testando...", 1);
        assertEquals(0, facade.criarVisaoCompleta("Teste2"));
        assertEquals(1, facade.criarVisaoResumida("Teste2"));
        assertEquals(2, facade.criarVisaoPrioritaria("Teste2", 1));
        assertEquals(3, facade.criarVisaoTitulo("Teste2"));

        assertArrayEquals(new String[]{"1. Mais um Teste", "Testando..."}, facade.exibirVisao(0));
        assertArrayEquals(new String[]{"1. Mais um Teste", "Testando..."}, facade.exibirVisao(1));
        assertArrayEquals(new String[]{"1. Mais um Teste", "Testando..."}, facade.exibirVisao(2));
        assertArrayEquals(new String[]{"1. Mais um Teste"}, facade.exibirVisao(3));

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
           facade.exibirVisao(-1);
        });
        assertEquals("Essa visão não existe !", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            facade.exibirVisao(4);
        });
        assertEquals("Essa visão não existe !", exception.getMessage());
    }
}