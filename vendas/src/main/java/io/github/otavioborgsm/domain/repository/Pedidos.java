package io.github.otavioborgsm.domain.repository;

import io.github.otavioborgsm.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    
}
