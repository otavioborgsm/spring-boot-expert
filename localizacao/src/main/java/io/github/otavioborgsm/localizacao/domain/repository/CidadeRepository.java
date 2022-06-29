package io.github.otavioborgsm.localizacao.domain.repository;

import io.github.otavioborgsm.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    // busca pelo nome correto
    List<Cidade> findByNome(String nome);

    // busca pelo nome like
    // "a" exatamente a string
    // "A%" começa com A
    // "%a%" contem a na string
    // "%a" termina com a
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome);

    // começando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    // terminando por aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    // contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);

    // Query Methods numerais

    // procura pelo número exato de habitantes
    List<Cidade> findByHabitantes(Long habitantes);

    // lista cidades com o número de habitantes menor que o informado
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    // lista cidades com o número de habitantes menor e igual que o informado
    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    // lista cidades com mais habitantes que o inofrmado
    List<Cidade> findByHabitantesGreaterThanThan(Long habitantes);

    // lista cidades com o número de habitantes menor que o informado e nome like
    List<Cidade> findByHabitantesLessThanOrNomeLike(Long habitantes);

}
