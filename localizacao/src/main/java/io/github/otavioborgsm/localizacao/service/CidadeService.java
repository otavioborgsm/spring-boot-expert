package io.github.otavioborgsm.localizacao.service;

import io.github.otavioborgsm.localizacao.domain.entity.Cidade;
import io.github.otavioborgsm.localizacao.domain.repository.CidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void listaCidadePorNome(String nome){
        repository.findByNomeLike(nome)
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
}
