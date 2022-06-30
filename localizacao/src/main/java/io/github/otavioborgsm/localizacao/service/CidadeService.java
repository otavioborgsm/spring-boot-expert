package io.github.otavioborgsm.localizacao.service;

import io.github.otavioborgsm.localizacao.domain.entity.Cidade;
import io.github.otavioborgsm.localizacao.domain.repository.CidadeRepository;
import static io.github.otavioborgsm.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    public void listaCidadesporQuantidadeHabitantes(Long habitantes, String nome){
        repository.findByHabitantesLessThanAndNomeLike(habitantes, nome)
                .forEach(System.out::println);
    }

    public void listaCidadePorNomeOrdenado(String nome, Sort sort){
        repository.findByNomeLike( nome, sort )
                .forEach(System.out::println);
    }

    public void listaCidadePorNomePaginado(String nome, Pageable pageable){
        repository.findByNomeLike( nome, pageable )
                .forEach(System.out::println);
    }

    public void listaCidadePorNomeSQL(String nome){
        repository
                .findByNomeSqlNativo(nome)
                .stream().map(cidadeProjection -> new Cidade( cidadeProjection.getId(), cidadeProjection.getNome(),null))
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(Long habitantes){
        repository.findByHabitantes(habitantes)
                .forEach(System.out::println);
    }

    @Transactional
    public void salvarCidade(Long id, String nome, Long habitantes){
        var cidade = new Cidade(id , nome, habitantes);
        repository.save(cidade);
    }

    public void listarCidades(){
        repository.findAll()
                .forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico( Cidade cidade ){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(String nome, Long habitantes){
        repository
                .findAll(nomeEqual(nome).and(habitantesGreaterThan(habitantes)))
                .forEach(System.out::println);
    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null){
            specs = specs.and( idEqual(filtro.getId()) );
        }

        if (StringUtils.hasText(filtro.getNome())){
            specs = specs.and(nomeLike(filtro.getNome()));
        }

        if (filtro.getHabitantes() != null){
            specs = specs.and(habitantesGreaterThan(filtro.getHabitantes()));
        }

        repository.findAll(specs).forEach(System.out::println);

    }
}
