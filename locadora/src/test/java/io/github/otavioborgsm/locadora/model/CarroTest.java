package io.github.otavioborgsm.locadora.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarroTest {

    @Test
    @DisplayName("Deve calcular o valor correto do Aluguel")
    void deveCalcularValorAluguel() {
        Carro carro = new Carro("Sedan", 100.0);
        double total = carro.calcularValorAluguel(3);
        Assertions.assertEquals(300.0, total);
    }
}
