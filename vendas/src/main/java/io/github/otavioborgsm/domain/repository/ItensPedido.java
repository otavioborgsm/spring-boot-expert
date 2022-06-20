package io.github.otavioborgsm.domain.repository;

import io.github.otavioborgsm.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
    
}
