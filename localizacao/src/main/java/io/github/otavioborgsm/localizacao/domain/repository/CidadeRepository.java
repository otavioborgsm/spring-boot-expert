package io.github.otavioborgsm.localizacao.domain.repository;

import io.github.otavioborgsm.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
