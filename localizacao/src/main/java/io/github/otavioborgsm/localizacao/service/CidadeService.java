package io.github.otavioborgsm.localizacao.service;

import io.github.otavioborgsm.localizacao.domain.entity.Cidade;
import io.github.otavioborgsm.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
