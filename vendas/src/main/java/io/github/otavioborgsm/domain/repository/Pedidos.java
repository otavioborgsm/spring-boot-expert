package io.github.otavioborgsm.domain.repository;

import io.github.otavioborgsm.domain.entity.Cliente;
import io.github.otavioborgsm.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left join fetch p.itens where p.id = :id")
    Optional<Pedido> findBtIdFetchItens(@Param("id") Integer id);
}
