package io.github.otavioborgsm.domain.repository;

import io.github.otavioborgsm.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
