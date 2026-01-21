package io.github.otavioborgsm.locadora.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class ClienteTest {

    @Test
    void deveCriarClienteComNome(){
        var cliente  = new Cliente("Maria");

        String nome = cliente.getNome();

        assertEquals(nome, "Maria");
        assertNotNull(nome);
        assertTrue(nome.startsWith("M"));
        assertFalse(nome.length() == 100);

        assertThat(nome).isEqualTo("Maria");
    }

    @Test
    void deveCriarClienteSemNome(){
        var cliente  = new Cliente(null);

        String nome = cliente.getNome();

        assertNull(nome);
    }
}
